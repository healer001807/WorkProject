package com.vv.study1.processControl.service;

import com.vv.study1.processControl.pojo.ProcessControlConfig;

import java.util.List;

/**
 * @author kw
 * @program WorkProject
 * @description 流程控制业务接口
 * @create 2023 - 12 - 21 21:56
 **/
public interface ProcessControlService {

    /**
     * 查询全部流程
     *
     * @return
     */
    List<ProcessControlConfig> getProcessControlList();
}
