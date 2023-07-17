package com.vv.quartz.service;

import com.vv.quartz.pojo.QuartzJobDTO;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: WorkProject
 * @description: quartz 定时任务业务逻辑实现
 * @author: kangwei
 * @create: 2023-07-17 10:52
 **/
@Slf4j
@Service
public class QuartzJobServiceImpl implements QuartzJobService {

    @Autowired
    private Scheduler scheduler;

    /***
     * @description 添加任务可以传参数
     * @author kangwei
     * @date 2023-7-17
     * @param quartzJobDTO
     @return void
     */
    @Override
    public void addJob(QuartzJobDTO quartzJobDTO) {
        try {
            // 启动调度器，默认初始化的时候已经启动
//            scheduler.start();
            //构建job信息
            Class<? extends Job> jobClass = (Class<? extends Job>) Class.forName(quartzJobDTO.getJobClass());
            JobDetail jobDetail = JobBuilder.newJob(jobClass).withIdentity(quartzJobDTO.getJobName(), quartzJobDTO.getGroupName()).build();
            //表达式调度构建器(即任务执行的时间)
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(quartzJobDTO.getCronExpression());
            //按新的cronExpression表达式构建一个新的trigger
            CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(quartzJobDTO.getJobName(), quartzJobDTO.getGroupName()).withSchedule(scheduleBuilder).build();
            //获得JobDataMap，写入数据
            // String param = quartzJobDTO.getParam(); // todo
//            if (param != null) {
//                trigger.getJobDataMap().putAll(param);
//            }
            scheduler.scheduleJob(jobDetail, trigger);
        } catch (Exception e) {
            log.error("创建任务失败", e);
        }
    }

    /***
     * @description 暂停任务
     * @author kangwei
     * @date 2023-7-17
     * @param quartzJobDTO
     @return void
     */
    @Override
    public void pauseJob(QuartzJobDTO quartzJobDTO) {
        try {
            JobKey jobKey = new JobKey(quartzJobDTO.getJobName(), quartzJobDTO.getGroupName());
            scheduler.pauseJob(jobKey);
        } catch (SchedulerException e) {
            log.error("暂停任务异常" + e);
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
    public void resumeJob(QuartzJobDTO quartzJobDTO) {
        try {
            JobKey jobKey = new JobKey(quartzJobDTO.getJobName(), quartzJobDTO.getGroupName());
            scheduler.resumeJob(jobKey);
        } catch (SchedulerException e) {
            log.error("恢复任务异常" + e);
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
    public void runOnce(QuartzJobDTO quartzJobDTO) {
        try {
            JobKey jobKey = new JobKey(quartzJobDTO.getJobName(), quartzJobDTO.getGroupName());
//            scheduler.triggerJob(jobKey);
            scheduler.triggerJob(JobKey.jobKey(quartzJobDTO.getJobName(), quartzJobDTO.getGroupName()));
        } catch (SchedulerException e) {
            log.error("恢复任务异常" + e);
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
    public void updateJob(QuartzJobDTO quartzJobDTO) {
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
        } catch (Exception e) {
            log.error("更新任务失败", e);
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
    public void deleteJob(QuartzJobDTO quartzJobDTO) {

        try {
            scheduler.pauseTrigger(TriggerKey.triggerKey(quartzJobDTO.getJobName(), quartzJobDTO.getGroupName()));
            scheduler.unscheduleJob(TriggerKey.triggerKey(quartzJobDTO.getJobName(), quartzJobDTO.getGroupName()));
            scheduler.deleteJob(JobKey.jobKey(quartzJobDTO.getJobName(), quartzJobDTO.getGroupName()));
        } catch (SchedulerException e) {
            log.error("删除任务异常" + e);
        }
    }

    /**
     * 启动所有任务
     */
    @Override
    public void startAllJobs() {
        try {
            scheduler.start();
        } catch (SchedulerException e) {
            log.error("启动所有任务异常" + e);
        }
    }

    /**
     * 暂停所有任务
     */
    @Override
    public void pauseAllJobs() {
        try {
            scheduler.pauseAll();
        } catch (SchedulerException e) {
            log.error("启动所有任务异常" + e);
        }
    }

    /**
     * 恢复所有任务
     */
    @Override
    public void resumeAllJobs() {
        try {
            scheduler.resumeAll();
        } catch (SchedulerException e) {
            log.error("启动所有任务异常" + e);
        }
    }

    /**
     * 关闭所有任务
     */
    @Override
    public void shutdownAllJobs() {
        try {
            if (!scheduler.isShutdown()) {
                // 需谨慎操作关闭scheduler容器
                // scheduler生命周期结束，无法再 start() 启动scheduler
                scheduler.shutdown(true);
            }
        } catch (SchedulerException e) {
            log.error("启动所有任务异常" + e);
        }
    }
}
