package com.vv.admin.service.impl;

import com.vv.admin.mapper.TaskMapper;
import com.vv.admin.pojo.dto.TaskDTO;
import com.vv.admin.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kw
 * @program WorkProject
 * @description 任务业务接口
 * @create 2023 - 05 - 25 21:28
 **/
@Slf4j
@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskMapper taskMapper;

    @Override
    public int updateTask(TaskDTO taskDTO) {
        return taskMapper.updateTask(taskDTO);
    }

    @Override
    public TaskDTO selectTaskByType(String taskType) {
//        if (StrUtil.isBlank(taskType)){
//            return "";
//        }
        return taskMapper.selectTaskByType(taskType);
    }

    @Override
    public List<TaskDTO> selectTaskList(TaskDTO taskDTO) {
        return taskMapper.selectTaskList(taskDTO);
    }
}
