package com.vv.quartz.service;

import com.vv.exception.BusinessException;
import com.vv.quartz.pojo.QuartzJobDTO;
import com.vv.util.ResUtils;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @program: WorkProject
 * @description: quartz 定时任务业务逻辑实现
 * @author: kangwei
 * @create: 2023-07-17 10:52
 **/
@Slf4j
@Service
public class QuartzJobServiceImpl implements QuartzJobService, ApplicationContextAware {

    @Autowired
    private Scheduler scheduler;

    // 上下文
    private ApplicationContext applicationContext;

    /***
     * @description 添加任务可以传参数
     * @author kangwei
     * @date 2023-7-17
     * @param quartzJobDTO
     @return void
     */
    @Override
    public ResUtils addJob(QuartzJobDTO quartzJobDTO) {
        try {
            Optional.ofNullable(quartzJobDTO).orElseThrow(() -> (new BusinessException("任务不能为空")));
            String jobName = quartzJobDTO.getJobName();
            Optional.ofNullable(jobName).orElseThrow(() -> (new BusinessException("任务名不能为空")));

            // 通过jobName获取class
            Class<? extends Job> jobClass = (Class<? extends Job>) applicationContext.getBean(jobName).getClass();
            JobDetail jobDetail = JobBuilder.newJob(jobClass).withIdentity(jobName, quartzJobDTO.getGroupName()).build();
            // 按新的cronExpression表达式构建一个新的trigger
            CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(jobName, quartzJobDTO.getGroupName()).withSchedule(CronScheduleBuilder.cronSchedule(quartzJobDTO.getCronExpression()))// 表达式调度构建器(即任务执行的时间)
                    .build();
            // 获得JobDataMap，写入数据
            // String param = quartzJobDTO.getParam(); // todo
//            if (param != null) {
//                trigger.getJobDataMap().putAll(param);
//            }
            scheduler.scheduleJob(jobDetail, trigger);

        } catch (Exception e) {
            log.error("创建任务失败", e);
            ResUtils.failed();
        }
        return ResUtils.success();
    }

    /***
     * @description 暂停任务
     * @author kangwei
     * @date 2023-7-17
     * @param quartzJobDTO
     @return void
     */
    @Override
    public ResUtils pauseJob(QuartzJobDTO quartzJobDTO) {
        try {
            JobKey jobKey = new JobKey(quartzJobDTO.getJobName(), quartzJobDTO.getGroupName());
            scheduler.pauseJob(jobKey);
            return ResUtils.success();
        } catch (SchedulerException e) {
            log.error("暂停任务异常" + e);
            return ResUtils.failed();
        }
    }

    /***
     * @description 恢复任务
     * @author kangwei
     * @date 2023-7-17
     * @param quartzJobDTO
     @return void
     */
    @Override
    public ResUtils resumeJob(QuartzJobDTO quartzJobDTO) {
        try {
            JobKey jobKey = new JobKey(quartzJobDTO.getJobName(), quartzJobDTO.getGroupName());
            scheduler.resumeJob(jobKey);
            return ResUtils.success();
        } catch (SchedulerException e) {
            log.error("恢复任务异常" + e);
            return ResUtils.failed();
        }
    }

    /***
     * @description 立即运行一次定时任务
     * @author kangwei
     * @date 2023-7-17
     * @param quartzJobDTO
     @return void
     */
    @Override
    public ResUtils runOnce(QuartzJobDTO quartzJobDTO) {
        try {
            // JobKey jobKey1 = new JobKey(quartzJobDTO.getJobName(), quartzJobDTO.getGroupName());
            scheduler.triggerJob(JobKey.jobKey(quartzJobDTO.getJobName(), quartzJobDTO.getGroupName()));
            return ResUtils.success();
        } catch (SchedulerException e) {
            log.error("恢复任务异常" + e);
            return ResUtils.failed();
        }
    }

    /***
     * @description 更新任务
     * @author kangwei
     * @date 2023-7-17
     * @param quartzJobDTO
     @return void
     */
    @Override
    public ResUtils updateJob(QuartzJobDTO quartzJobDTO) {
        try {
            TriggerKey triggerKey = TriggerKey.triggerKey(quartzJobDTO.getJobName(), quartzJobDTO.getGroupName());
            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
            String cronExpression = quartzJobDTO.getCronExpression();
            if (cronExpression != null) {
                // 表达式调度构建器
                CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);
                // 按新的cronExpression表达式重新构建trigger
                trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
            }
            // todo
//            if (quartzJobDTO != null) {
//                trigger.getJobDataMap().putAll(quartzJobDTO);
//            }
            // 按新的trigger重新设置job执行
            scheduler.rescheduleJob(triggerKey, trigger);
            return ResUtils.success();
        } catch (Exception e) {
            log.error("更新任务失败", e);
            return ResUtils.failed();
        }
    }

    /***
     * @description 删除任务
     * @author kangwei
     * @date 2023-7-17
     * @param quartzJobDTO
     @return void
     */
    @Override
    public ResUtils deleteJob(QuartzJobDTO quartzJobDTO) {

        try {
            scheduler.pauseTrigger(TriggerKey.triggerKey(quartzJobDTO.getJobName(), quartzJobDTO.getGroupName()));
            scheduler.unscheduleJob(TriggerKey.triggerKey(quartzJobDTO.getJobName(), quartzJobDTO.getGroupName()));
            scheduler.deleteJob(JobKey.jobKey(quartzJobDTO.getJobName(), quartzJobDTO.getGroupName()));
            return ResUtils.success();
        } catch (SchedulerException e) {
            log.error("删除任务异常" + e);
            return ResUtils.failed();
        }
    }

    /**
     * 启动所有任务
     */
    @Override
    public ResUtils startAllJobs() {
        try {
            scheduler.start();
            return ResUtils.success();
        } catch (SchedulerException e) {
            log.error("启动所有任务异常" + e);
            return ResUtils.failed();
        }
    }

    /**
     * 暂停所有任务
     */
    @Override
    public ResUtils pauseAllJobs() {
        try {
            scheduler.pauseAll();
            return ResUtils.success();
        } catch (SchedulerException e) {
            log.error("启动所有任务异常" + e);
            return ResUtils.failed();
        }
    }

    /**
     * 恢复所有任务
     */
    @Override
    public ResUtils resumeAllJobs() {
        try {
            scheduler.resumeAll();
            return ResUtils.success();
        } catch (SchedulerException e) {
            log.error("启动所有任务异常" + e);
            return ResUtils.failed();
        }
    }

    /**
     * 关闭所有任务
     */
    @Override
    public ResUtils shutdownAllJobs() {
        try {
            if (!scheduler.isShutdown()) {
                // 需谨慎操作关闭scheduler容器
                // scheduler生命周期结束，无法再 start() 启动scheduler
                scheduler.shutdown(true);
            }
            return ResUtils.success();
        } catch (SchedulerException e) {
            log.error("启动所有任务异常" + e);
            return ResUtils.failed();
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
