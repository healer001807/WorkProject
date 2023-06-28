package com.vv.admin.listener;

import com.vv.admin.pojo.dto.SysLogDTO;
import com.vv.admin.service.SysLogService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author kw
 * @program WorkProject
 * @description 时间监听
 * @create 2023 - 06 - 28 21:18
 **/
@Slf4j
@Component
public class MyEventListener {

    @Resource
    private SysLogService sysLogService;


    @Async("threadPoolExecutor")
    @EventListener(SysLogDTO.class)
    public void saveSysLog(SysLogDTO sysLogDTO) {
        log.info("异步保存系统操作日志");
        sysLogService.saveSysLog(sysLogDTO);
    }

}
