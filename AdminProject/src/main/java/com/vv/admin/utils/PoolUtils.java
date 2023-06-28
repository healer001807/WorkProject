package com.vv.admin.utils;

import java.util.concurrent.*;

/**
 * @author kw
 * @program WorkProject
 * @description 线程工具类
 * @create 2023 - 06 - 03 23:19
 **/
public class PoolUtils {

    private static int corePoolSize = 5; // 核心线程数
    private static int maxPoolSize = 10; // 最大线程数
    private static long keepAliveTime = 60; // 活跃时间
    private static int blockingDeque = 1000; // 允许等待最大数

    private static final ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
            corePoolSize,
            maxPoolSize,
            keepAliveTime,
            TimeUnit.SECONDS,
            new LinkedBlockingDeque<>(blockingDeque),
            Executors.defaultThreadFactory(), // 线程工厂
            new ThreadPoolExecutor.AbortPolicy()  // 拒绝策略
    );

    /**
     * 异步无回调
     *
     * @param command
     */
    public static void createAsyncExecutor(Runnable command) {
        poolExecutor.execute(command);
    }

    /**
     * 同步回调
     *
     * @param task
     * @return futureTask
     */
    public static Future<?> createSyncExecutor(Callable<?> task) {
        return poolExecutor.submit(task);
    }
}
