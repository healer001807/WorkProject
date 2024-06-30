package com.vv.study1.config;

import jakarta.annotation.Resource;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

/**
 * @author kw
 * @program WorkProject
 * @description
 * @create 2024 - 01 - 20 19:12
 **/
@Configuration
public class RestTemplateConfig {

    @Resource
    private RestTemplateBuilder restTemplateBuilder;

    @Bean
    public RestTemplate restTemplate() {
        return restTemplateBuilder
                .setConnectTimeout(Duration.ofSeconds(120))
                .setReadTimeout(Duration.ofSeconds(120))
                .build();
    }
}
