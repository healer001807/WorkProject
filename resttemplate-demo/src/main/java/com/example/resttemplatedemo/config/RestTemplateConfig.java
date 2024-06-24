package com.example.resttemplatedemo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.net.InetSocketAddress;
import java.net.Proxy;

/**
 * @author kw
 * @program WorkProject
 * @description
 * @create 2024 - 04 - 10 18:47
 **/
@Configuration
public class RestTemplateConfig {

//    @Value("${proxy.host}")
    private String proxyHost;
//    @Value("${proxy.port}")
    private int proxyPort;

    /**
     * 注入restTemplate
     *
     * @return
     */
    @Bean
    public RestTemplate restTemplate() {
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        return restTemplateBuilder.build();
    }

    /**
     * 代理模式restTemplate
     *
     * @return
     */
//    @Bean
    public RestTemplate restTemplateProxy(ClientHttpRequestFactory clientHttpRequestFactory) {
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.setRequestFactory(clientHttpRequestFactory);
        return restTemplate;
    }

    /**
     * 代理工厂配置
     *
     * @return
     */
//    @Bean
    public ClientHttpRequestFactory clientHttpRequestFactory() {
        SimpleClientHttpRequestFactory client = new SimpleClientHttpRequestFactory();
        client.setProxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, proxyPort)));
        return client;
    }
}
