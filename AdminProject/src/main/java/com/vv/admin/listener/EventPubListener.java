package com.vv.admin.listener;

import com.vv.admin.pojo.dto.SysLogDTO;
import jakarta.annotation.Resource;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author kw
 * @program WorkProject
 * @description 发布者
 * @create 2023 - 06 - 28 21:15
 **/
@Component
public class EventPubListener {

    @Resource
    private ApplicationContext applicationContext;

    public void pushListener(SysLogDTO sysLogDTO) {
        applicationContext.publishEvent(sysLogDTO);
    }
}
