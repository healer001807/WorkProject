package com.vv.admin.service;

import com.vv.admin.pojo.dto.SysLogDTO;

/**
 * @author kw
 * @program WorkProject
 * @description 日志业务接口
 * @create 2023 - 06 - 28 21:18
 **/
public interface SysLogService {
    /***
    * @description 保存系统操作日志
    * @param [sysLogDTO]
    * @return void
    * @author 
    * @date 2023/6/28
    
    **/
    
    void saveSysLog(SysLogDTO sysLogDTO);
}
