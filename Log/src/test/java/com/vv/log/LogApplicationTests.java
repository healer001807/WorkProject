package com.vv.log;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

@SpringBootTest
class LogApplicationTests {

    @Test
    void contextLoads() {
        // 默认 RootLogger
        Logger logger = Logger.getLogger("com.vv");
        System.out.println(logger);
        logger.info("info level");
        // ConsoleHandler 控制台输出
        // SimpleFormatter 格式化日志对象
        //
        // FileHandler  向日志文件中输出 limit count append
        // 自定义日志 handlers

    }


}
