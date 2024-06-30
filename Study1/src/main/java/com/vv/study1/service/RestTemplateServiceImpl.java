package com.vv.study1.service;

import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author kw
 * @program WorkProject
 * @description
 * @create 2024 - 01 - 20 19:23
 **/
@Service
public class RestTemplateServiceImpl extends RestTemplateService {

    @Resource
    private RestTemplate restTemplate;

    @Override
    public String postForEntity(String url, Object obj) {
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, obj, String.class);
        HttpStatusCode statusCode = responseEntity.getStatusCode();
        if (statusCode.value() == 200) {
            return responseEntity.getBody();
        }
        return null;
    }

    @Override
    public String getForEntity(String url) {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        if (responseEntity.getStatusCode().value() == 200) {
            return responseEntity.getBody();
        }
        return "";
    }
}
