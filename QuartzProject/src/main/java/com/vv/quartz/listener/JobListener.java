package com.vv.quartz.listener;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.listeners.JobListenerSupport;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @author kw
 * @program WorkProject
 * @description 创建任务执行监听器
 * @create 2023 - 07 - 18 20:55
 **/
@Slf4j
@Component
public class JobListener extends JobListenerSupport {
    @Override
    public String getName() {
        return "simpleJobListener";
    }

    public JobListener() {
        super();
    }

    @Override
    protected Logger getLog() {
        return super.getLog();
    }

    @Override
    public void jobToBeExecuted(JobExecutionContext context) {
        super.jobToBeExecuted(context);
    }

    @Override
    public void jobExecutionVetoed(JobExecutionContext context) {
        super.jobExecutionVetoed(context);
    }

    @Override
    public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
        super.jobWasExecuted(context, jobException);
    }
}
