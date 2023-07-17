package com.vv.admin.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author kw
 * @program WorkProject
 * @description post/get请求模板
 * @create 2023 - 07 - 08 13:15
 **/

//@Configuration
public class RestTemplateConfig {
    @Value("${connect.timeout}")
    private Integer connectTimeout;
    @Value("${read.timeout}")
    private Integer readTimeout;

    /***
     * @description rest模板
     * @param [requestFactory]
     * @return org.springframework.web.client.RestTemplate
     * @author
     * @date 2023/7/8
     **/
    @Bean
    public RestTemplate restTemplate(ClientHttpRequestFactory requestFactory) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(requestFactory);
        return restTemplate;
    }

    /***
     * @description http连接工厂
     * @param []
     * @return org.springframework.http.client.ClientHttpRequestFactory
     * @author
     * @date 2023/7/8
     **/

    @Bean
    public ClientHttpRequestFactory requestFactory() {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        //   requestFactory.setProxy(); // 设置代理 可根据实际业务需要
        requestFactory.setConnectTimeout(connectTimeout); // 超时时间
        requestFactory.setReadTimeout(readTimeout); // 读超时时间
        return requestFactory;
    }
}
