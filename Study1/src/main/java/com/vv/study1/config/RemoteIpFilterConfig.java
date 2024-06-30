package com.vv.study1.config;

import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

/**
 * @author kw
 * @program WorkProject
 * @description 远程IP配置
 * @create 2023 - 12 - 20 20:33
 **/
@Configuration
public class RemoteIpFilterConfig {

    /**
     * 远程IP bean注入
     *
     * @return
     */
    @Bean
    public RemoteIpFilter remoteIpFilter() {
        return new RemoteIpFilter();
    }
//    @Bean
//    public LocaleChangeInterceptor localeChangeInterceptor() {
//        return new LocaleChangeInterceptor();
//    }
}
