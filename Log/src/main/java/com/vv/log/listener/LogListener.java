package com.vv.log.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.ServletRequestHandledEvent;

/**
 * @author kw
 * @program WorkProject
 * @description 日志监听器
 * @create 2023 - 11 - 27 21:28
 **/
@Component
public class LogListener implements ApplicationListener<ServletRequestHandledEvent> {
    private static final Logger logger = LoggerFactory.getLogger(LogListener.class);

    @Override
    public void onApplicationEvent(ServletRequestHandledEvent event) {
        String requestUrl = event.getRequestUrl();
        logger.info("request url {}", requestUrl);
        String clientAddress = event.getClientAddress();
        logger.info("clientAddress {}", clientAddress);
        String method = event.getMethod();
        logger.info("method {}", method);

    }
}
