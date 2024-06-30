package com.vv.study1.processControl.service.impl;

import cn.hutool.core.util.StrUtil;
import com.vv.study1.processControl.pojo.ProcessControlConfig;
import com.vv.study1.processControl.service.ProcessControlService;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * @author kw
 * @program WorkProject
 * @description 流程控制业务实现
 * @create 2023 - 12 - 21 21:56
 **/
@Service
public class ProcessControlServiceImpl implements ProcessControlService {
    @Override
    public List<ProcessControlConfig> getProcessControlList() {
        List<ProcessControlConfig> processControlConfigList = new LinkedList<>();
        // 先模拟一个场景 3个产品
        for (int i = 1; i <= 3; i++) {
            ProcessControlConfig processControlConfig = new ProcessControlConfig();
            processControlConfig.setId(StrUtil.uuid());
            processControlConfig.setDeleteStatus(1);
            processControlConfig.setOperatorScene("3");
            processControlConfig.setProductType(String.valueOf(i));
            processControlConfigList.add(processControlConfig);
        }
        return processControlConfigList;
    }
}
