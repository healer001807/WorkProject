package com.vv.admin.controller;

import com.vv.admin.enums.BusinessTypeEnum;
import com.vv.admin.log.Log;
import com.vv.admin.service.SysLogService;
import com.vv.util.ResUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kw
 * @program WorkProject
 * @description 日志接口
 * @create 2023 - 06 - 28 21:36
 **/
@Slf4j
@RestController
@RequestMapping("sysLog")
public class SysLogController {

    @Log(title = "测试", businessType = BusinessTypeEnum.OTHER)
    @GetMapping("saveSysLog")
    public ResUtils saveSysLog() {
        log.info("测试日志");
        return ResUtils.success();
    }
}
