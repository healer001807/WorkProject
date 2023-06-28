package com.vv.admin.config;

import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author kw
 * @program WrokProject
 * @description 线程池
 * @create 2023 - 05 - 20 15:03
 **/
@Component
public class ThreadPoolConfig {

    @Resource
    private ThreadPoolProperties properties;


    /***
     * @description ThreadPoolExecutor
     * @param []
     * @return java.util.concurrent.ThreadPoolExecutor
     * @author
     * @date 2023/5/20
     **/

    @Bean
    public ThreadPoolExecutor threadPoolExecutor() {
        return
                new ThreadPoolExecutor(
                        properties.getCorePoolSize(),
                        properties.getMaxPoolSize(),
                        properties.getKeepAliveTime(),
                        TimeUnit.SECONDS,
                        new LinkedBlockingDeque<>(properties.getBlockingDeque()),
                        Executors.defaultThreadFactory(), // 线程工厂
                        new ThreadPoolExecutor.AbortPolicy()  // 拒绝策略
                );
    }

    /***
     * @description ThreadPoolTaskExecutor todo 还需要研究下
     * @param []
     * @return org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor
     * @author
     * @date 2023/5/21
     **/

//    @Bean
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(properties.getCorePoolSize());
        taskExecutor.setMaxPoolSize(properties.getMaxPoolSize());
        taskExecutor.setKeepAliveSeconds((int) properties.getKeepAliveTime());
//        taskExecutor.setAllowCoreThreadTimeOut(true);
        taskExecutor.setQueueCapacity(10000); // todo
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        return taskExecutor;
    }
}
