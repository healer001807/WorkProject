package com.vv.service;

import com.vv.pojo.dto.TaskDTO;

import java.util.List;

/**
 * @author kw
 * @program WorkProject
 * @description 任务业务接口
 * @create 2023 - 05 - 25 21:28
 **/
public interface TaskService {

    /***
     * @description 更新任务执行状态
     * @param taskDTO
     * @return int
     * @author
     * @date 2023/5/25
     **/

    int updateTask(TaskDTO taskDTO);

    /***
     * @description 查询单个任务执行流水
     * @param taskType
     * @return com.vv.pojo.dto.TaskDTO
     * @author
     * @date 2023/5/25
     **/
    TaskDTO selectTaskByType(String taskType);

    /***
     * @description 查询任务执行流水
     * @param taskDTO
     * @return com.vv.pojo.dto.TaskDTO
     * @author
     * @date 2023/5/25
     **/
    List<TaskDTO> selectTaskList(TaskDTO taskDTO);
}
