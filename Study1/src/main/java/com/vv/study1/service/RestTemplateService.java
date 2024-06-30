package com.vv.study1.service;

/**
 * @author kw
 * @program WorkProject
 * @description
 * @create 2024 - 01 - 20 19:23
 **/
public abstract class RestTemplateService {

    public abstract String postForEntity(String url, Object obj);

    public abstract String getForEntity(String url);

}
