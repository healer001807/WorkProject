package com.vv.quartz.config;

import org.quartz.SchedulerConfigException;
import org.quartz.spi.ThreadPool;
import org.springframework.context.annotation.Configuration;

/**
 * @author kw
 * @program WorkProject
 * @description 线程池
 * @create 2023 - 07 - 16 14:02
 **/

@Configuration
public class SimpleThreadPool implements ThreadPool {

    @Override
    public boolean runInThread(Runnable runnable) {
        return false;
    }

    @Override
    public int blockForAvailableThreads() {
        return 0;
    }

    @Override
    public void initialize() throws SchedulerConfigException {

    }

    @Override
    public void shutdown(boolean b) {

    }

    @Override
    public int getPoolSize() {
        return 0;
    }

    @Override
    public void setInstanceId(String s) {

    }

    @Override
    public void setInstanceName(String s) {

    }
}
