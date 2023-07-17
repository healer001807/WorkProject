package com.vv.quartz.job;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author kw
 * @program WorkProject
 * @description quartz配置类
 * 此方式基于内存的重启后丢失，而且一个任务就要创建一个jobDetail
 * @create 2023 - 07 - 16 11:45
 **/

//@Configuration
public class QuartzConfig2 {


    /***
     * @description 任务的详细信息
     * @param []
     * @return org.quartz.JobDetail
     * @author
     * @date 2023/7/16
     **/

    @Bean
    public JobDetail jobDetail() {
        // newJob 具体任务
        return JobBuilder.newJob(MyJob.class).withIdentity("任务名称") // withIdentity 任务名称
                .withDescription("任务描述")
                .storeDurably() // 任务执行后进行存储
                .build();
    }

    /***
     * @description 任务触发器 一个job可以绑定多个出发器
     * @param []
     * @return org.quartz.Trigger
     * @author
     * @date 2023/7/16
     **/

    @Bean
    public Trigger trigger() {
        // 触发器
        return TriggerBuilder.newTrigger()
                .forJob(jobDetail()) // 任务具体描述
                .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(5)) // 任务执行时间间隔
                .build();
    }
}
