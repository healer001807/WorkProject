package com.vv.study1.controller;

import com.vv.study1.pojo.vo.LocationVo;
import com.vv.study1.service.RestTemplateService;
import com.vv.study1.validator.Coupon;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author kw
 * @program WorkProject
 * @description
 * @create 2024 - 01 - 20 19:47
 **/
@Slf4j
@RestController
@RequestMapping("rest")
public class RestTemplateController {

    @Resource
    private RestTemplateService restTemplateService;

    //    @GetMapping
//    public String getForEntity() {
//        String url = "http://localhost:8881/upload/downLoad";
//        return restTemplateService.getForEntity(url);
//    }
    @GetMapping
    public String getForEntity() {
        return "hello resttemplate";
    }

}
