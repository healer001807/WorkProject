package com.vv.quartz.job;

import com.vv.quartz.listener.JobListener;
import com.vv.quartz.listener.SchedulerListener;
import com.vv.quartz.listener.TriggerListener;
import jakarta.annotation.Resource;
import org.quartz.*;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.io.IOException;
import java.util.Objects;

/**
 * @author kw
 * @program WorkProject
 * @description quartz配置类
 * 此方式基于内存的重启后丢失，而且一个任务就要创建一个jobDetail
 * @create 2023 - 07 - 16 11:45
 **/

@Configuration
public class QuartzConfig {

    @Resource
    private QuartzJobFactory quartzJobFactory;

    @Resource
    private JobListener jobListener;
    @Resource
    private SchedulerListener schedulerListener;
    @Resource
    private TriggerListener triggerListener;


    /***
     * @description 获取SchedulerFactoryBean
     * @param []
     * @return org.springframework.scheduling.quartz.SchedulerFactoryBean
     * @author
     * @date 2023/7/16
     **/

//    @Bean
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() {
        try {
            PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
            propertiesFactoryBean.setLocation(new ClassPathResource("/quartz.properties"));
            propertiesFactoryBean.afterPropertiesSet();

            SchedulerFactoryBean schedulerFactory = new SchedulerFactoryBean();
            schedulerFactory.setQuartzProperties(Objects.requireNonNull(propertiesFactoryBean.getObject()));
            schedulerFactory.setJobFactory(quartzJobFactory);//支持在JOB实例中注入其他的业务对象
            schedulerFactory.setApplicationContextSchedulerContextKey("applicationContextKey");
            schedulerFactory.setWaitForJobsToCompleteOnShutdown(true);//这样当spring关闭时，会等待所有已经启动的quartz job结束后spring才能完全shutdown。
            schedulerFactory.setOverwriteExistingJobs(false);//是否覆盖己存在的Job
            schedulerFactory.setStartupDelay(10);//QuartzScheduler 延时启动，应用启动完后 QuartzScheduler 再启动

//            schedulerFactory.setDataSource(); 使用自定义数据库 todo
            return schedulerFactory;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /***
     * @description 通过SchedulerFactoryBean获取Scheduler的实例
     * @param []
     * @return org.quartz.Scheduler
     * @author
     * @date 2023/7/16
     **/

    @Bean
    public Scheduler scheduler() {
        try {
            Scheduler scheduler = schedulerFactoryBean().getScheduler();
            scheduler.getListenerManager().addJobListener(jobListener);
            scheduler.getListenerManager().addSchedulerListener(schedulerListener);
            // 注入后会一直打印日志，这样对于日志文件来说，还是消耗挺大的，直接注释
            // scheduler.getListenerManager().addTriggerListener(triggerListener);
            return scheduler;
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
    }
}
