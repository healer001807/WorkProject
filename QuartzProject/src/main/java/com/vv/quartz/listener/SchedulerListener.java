package com.vv.quartz.listener;

import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.quartz.listeners.SchedulerListenerSupport;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @author kw
 * @program WorkProject
 * @description 任务调度监听器
 * @create 2023 - 07 - 18 20:48
 **/
@Slf4j
@Component
public class SchedulerListener extends SchedulerListenerSupport {
    public SchedulerListener() {
        super();
    }

    @Override
    protected Logger getLog() {
        return super.getLog();
    }

    @Override
    public void jobAdded(JobDetail jobDetail) {
        super.jobAdded(jobDetail);
        log.info("任务被添加时执行==>" + jobDetail.getJobClass());
    }

    @Override
    public void jobDeleted(JobKey jobKey) {
        super.jobDeleted(jobKey);
        log.info("任务被删除时执行==>" + jobKey.getName());
    }

    @Override
    public void jobPaused(JobKey jobKey) {
        super.jobPaused(jobKey);
        log.info("任务被暂停时执行==>" + jobKey.getName());
    }

    @Override
    public void jobResumed(JobKey jobKey) {
        super.jobResumed(jobKey);
        log.info("任务被恢复时执行==>" + jobKey.getName());
    }

    @Override
    public void jobScheduled(Trigger trigger) {
        super.jobScheduled(trigger);
    }

    @Override
    public void jobsPaused(String jobGroup) {
        super.jobsPaused(jobGroup);
    }

    @Override
    public void jobsResumed(String jobGroup) {
        super.jobsResumed(jobGroup);
    }

    @Override
    public void jobUnscheduled(TriggerKey triggerKey) {
        super.jobUnscheduled(triggerKey);
    }

    @Override
    public void schedulerError(String msg, SchedulerException cause) {
        super.schedulerError(msg, cause);
    }

    @Override
    public void schedulerInStandbyMode() {
        super.schedulerInStandbyMode();
    }

    @Override
    public void schedulerShutdown() {
        super.schedulerShutdown();
    }

    @Override
    public void schedulerShuttingdown() {
        super.schedulerShuttingdown();
    }

    @Override
    public void schedulerStarted() {
        super.schedulerStarted();
        log.info("任务被开始时执行");
    }

    @Override
    public void schedulerStarting() {
        super.schedulerStarting();
    }

    @Override
    public void triggerFinalized(Trigger trigger) {
        super.triggerFinalized(trigger);
    }

    @Override
    public void triggerPaused(TriggerKey triggerKey) {
        super.triggerPaused(triggerKey);
    }

    @Override
    public void triggerResumed(TriggerKey triggerKey) {
        super.triggerResumed(triggerKey);
    }

    @Override
    public void triggersPaused(String triggerGroup) {
        super.triggersPaused(triggerGroup);
    }

    @Override
    public void triggersResumed(String triggerGroup) {
        super.triggersResumed(triggerGroup);
    }

    @Override
    public void schedulingDataCleared() {
        super.schedulingDataCleared();
    }
}
