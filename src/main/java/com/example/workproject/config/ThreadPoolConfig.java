package com.example.workproject.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;

/**
 * @author kw
 * @program WrokProject
 * @description 线程池
 * @create 2023 - 05 - 20 15:03
 **/
@Component
public class ThreadPoolConfig {


    @Value("${core.pool.size}")
    private int corePoolSize; // 核心线程数
    @Value("${max.pool.size}")
    private int maxPoolSize; // 最大线程数

    @Value("${keep.alive.time}")
    private long keepAliveTime; // 活跃时间
    @Value("${blocking.deque}")
    private int blockingDeque; // 允许等待最大数


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
                        corePoolSize,
                        maxPoolSize,
                        keepAliveTime,
                        TimeUnit.SECONDS,
                        new LinkedBlockingDeque<>(blockingDeque),
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
        taskExecutor.setCorePoolSize(corePoolSize);
        taskExecutor.setMaxPoolSize(maxPoolSize);
        taskExecutor.setKeepAliveSeconds((int) keepAliveTime);
//        taskExecutor.setAllowCoreThreadTimeOut(true);
        taskExecutor.setQueueCapacity(10000); // todo
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        return taskExecutor;
    }
}
