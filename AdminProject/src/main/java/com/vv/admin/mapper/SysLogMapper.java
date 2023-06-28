package com.vv.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vv.admin.pojo.dto.SysLogDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author kw
 * @program WorkProject
 * @description 系统日志数据层
 * @create 2023 - 06 - 28 21:22
 **/
@Mapper
public interface SysLogMapper extends BaseMapper<SysLogDTO> {
    /***
     * @description 保存系统操作日志
     * @param [sysLogDTO]
     * @return void
     * @author
     * @date 2023/6/28
     **/
    void saveSysLog(SysLogDTO sysLogDTO);
}
