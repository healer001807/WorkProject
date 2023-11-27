package com.vv.log;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author kw
 * @program WorkProject
 * @description
 * @create 2023 - 11 - 05 14:02
 **/
@SpringBootTest
public class LogbackTest {

    private static final Logger logger = LoggerFactory.getLogger(LogbackTest.class);

    @Test
    public void test() {
        logger.error("error");
        logger.warn("warn");
        logger.info("info");
        logger.info("debug");
        logger.info("trace");

    }
}
