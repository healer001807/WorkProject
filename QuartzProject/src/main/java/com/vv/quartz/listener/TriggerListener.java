package com.vv.quartz.listener;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.Trigger;
import org.quartz.listeners.TriggerListenerSupport;
import org.springframework.stereotype.Component;

/**
 * @author kw
 * @program WorkProject
 * @description 创建触发器
 * @create 2023 - 07 - 18 20:53
 **/
@Slf4j
@Component
public class TriggerListener extends TriggerListenerSupport {
    @Override
    public String getName() {
        return "simpleTriggerListener";
    }

    @Override
    public void triggerFired(Trigger trigger, JobExecutionContext context) {
        super.triggerFired(trigger, context);
        log.info("trigger is Fired" + trigger.getCalendarName());
    }

    @Override
    public boolean vetoJobExecution(Trigger trigger, JobExecutionContext context) {
        return super.vetoJobExecution(trigger, context);
    }

    @Override
    public void triggerMisfired(Trigger trigger) {
        super.triggerMisfired(trigger);
    }

    @Override
    public void triggerComplete(Trigger trigger, JobExecutionContext context, Trigger.CompletedExecutionInstruction triggerInstructionCode) {
        super.triggerComplete(trigger, context, triggerInstructionCode);
    }
}
