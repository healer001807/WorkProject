package com.vv.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author kw
 * @program WorkProject
 * @description
 * @create 2023 - 11 - 05 08:51
 **/
@SpringBootTest
public class JCLTest {

    // 减少代码耦合
    // 灵活切换日志框架
    //

    @Test
    public void test(){
        // 获取日志记录对象
        Log log = LogFactory.getLog(JCLTest.class);
        // 日志记录输出
        log.info("JCL");
    }
}
