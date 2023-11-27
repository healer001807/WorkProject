package com.vv.log;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.helpers.LogLog;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author kw
 * @program WorkProject
 * @description
 * @create 2023 - 11 - 04 08:52
 **/
@SpringBootTest
public class Logger4jTest {
    @Test
    public void logger4J() {

        // 开启logg4j内置日志记录
        LogLog.setInternalDebugging(true);

       // BasicConfigurator.configure(); // 不使用配置文件
        Logger logger = Logger.getLogger(Logger4jTest.class);

        for (int i = 0; i < 10000; i++) {
            // 日志级别
            logger.fatal("fatal:严重错误，一般会造成系统崩溃并终止运行");
            logger.error("error:错误信息，不会影响系统使用");
            logger.warn("warn:警告信息，可能会发生问题");
            logger.info("info:运行信息，数据连接，IO操作，在测试或者生产环境使用");
            logger.debug("debug:调试信息，一般在开发中使用，记录程序变量参数传递信息等");
            logger.trace("trace:追踪信息，记录程序所有的流程信息");

        }
    }

}
