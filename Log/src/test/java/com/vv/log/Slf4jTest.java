package com.vv.log;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author kw
 * @program WorkProject
 * @description
 * @create 2023 - 11 - 05 09:19
 **/
@SpringBootTest
public class Slf4jTest {

    private static final Logger logger = LoggerFactory.getLogger(Slf4jTest.class);

    @Test
    public void test() {
        logger.error("error");
        logger.warn("warn");
        logger.info("info");
        logger.info("debug");
        logger.info("trace");

        // 占位符
        logger.info("验证{},{}", "", "");
    }
}
