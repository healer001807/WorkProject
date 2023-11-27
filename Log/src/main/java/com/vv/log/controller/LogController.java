package com.vv.log.controller;

import com.vv.log.listener.LogListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kw
 * @program WorkProject
 * @description 日志控制api
 * @create 2023 - 11 - 27 21:32
 **/
@RestController
@RequestMapping("log")
public class LogController {
    private static final Logger logger = LoggerFactory.getLogger(LogController.class);

    @GetMapping
    public void verifyLogListener(String param) {
        logger.info("verifyLogListener{}", param);
    }
}
