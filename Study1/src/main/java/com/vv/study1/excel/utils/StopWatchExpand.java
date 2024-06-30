package com.vv.study1.excel.utils;

import org.springframework.util.StopWatch;

/**
 * @author kw
 * @program WorkProject
 * @description
 * @create 2023 - 12 - 16 17:16
 **/
public class StopWatchExpand {

    private final static StopWatch STOP_WATCH = new StopWatch("代码运行时间检测");

    // 开始计时
    public static void start(String taskName) {
        STOP_WATCH.start(taskName);
    }

    // 停止计时
    public static void stop() {
        STOP_WATCH.stop();
    }

    // 打印所有任务的执行时间
    public static String print() {
        return STOP_WATCH.prettyPrint();
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("开始执行");
        Thread.sleep(5000L);
        System.out.println("执行完毕");
    }
}
