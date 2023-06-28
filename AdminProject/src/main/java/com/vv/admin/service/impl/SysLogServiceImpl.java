package com.vv.admin.service.impl;

import com.vv.admin.mapper.SysLogMapper;
import com.vv.admin.pojo.dto.SysLogDTO;
import com.vv.admin.service.SysLogService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author kw
 * @program WorkProject
 * @description 日志业务接口
 * @create 2023 - 06 - 28 21:18
 **/
@Service
public class SysLogServiceImpl implements SysLogService {
    @Resource
    private SysLogMapper sysLogMapper;

    @Override
    public void saveSysLog(SysLogDTO sysLogDTO) {
        sysLogMapper.insert(sysLogDTO);
    }
}
