package com.vv.study1.excel.controller;

import cn.hutool.json.JSONUtil;
import com.vv.study1.excel.pojo.PrintActivityDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kw
 * @program WorkProject
 * @description 晒图活动
 * @create 2024 - 01 - 08 22:18
 **/
@RestController
@RequestMapping("printActivity")
public class PrintActivityController {

    @GetMapping
    public PrintActivityDto getPrintActivity() {
        return new PrintActivityDto().setPrintActivityName("元旦节");
    }
}
