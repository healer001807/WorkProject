package com.vv.quartz.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author kw
 * @program WorkProject
 * @description 我的任务
 * @create 2023 - 07 - 16 11:48
 **/
@Slf4j
public class MyJob extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        // log.info("自律才能战胜一切");
        try {
            log.info("quartz::" + context.getScheduler().getSchedulerInstanceId() + ":::" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
    }
}
