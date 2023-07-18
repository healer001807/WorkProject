package com.vv.study.controller;

import com.vv.study.guava.GuavaLimitAnnotation;
import com.vv.util.ResUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kw
 * @program WorkProject
 * @description
 * @create 2023 - 07 - 18 21:50
 **/
@RestController
@RequestMapping("guava")
public class GuavaDemoController {

    @GetMapping("index")
    @GuavaLimitAnnotation(limitType = "index", limitCount = 1)
    public ResUtils index() {
        return ResUtils.success();
    }
}
