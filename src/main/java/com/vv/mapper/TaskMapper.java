package com.vv.mapper;

import com.vv.pojo.dto.TaskDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author kw
 * @program WorkProject
 * @description 任务流水数据操作
 * @create 2023 - 05 - 23 22:55
 **/
@Mapper
public interface TaskMapper {


    /***
     * @description 插入一条导出计划
     * @param taskDTO
     * @return int
     * @author
     * @date 2023/5/23
     **/

    int insertTask(TaskDTO taskDTO);

    /***
     * @description 更新任务流水状态
     * @param taskDTO
     * @return int
     * @author
     * @date 2023/5/25
     **/

    int updateTask(TaskDTO taskDTO);

    /***
     * @description 根据任务类型查询任务流水
     * @param [taskType]
     * @return com.vv.pojo.dto.TaskDTO
     * @author
     * @date 2023/5/25
     **/

    TaskDTO selectTaskByType(String taskType);

    /***
     * @description 根据任务类型和执行状态查询任务流水
     * @param [taskDTO]
     * @return java.util.List<com.vv.pojo.dto.TaskDTO>
     * @author
     * @date 2023/5/25
     **/

    List<TaskDTO> selectTaskList(TaskDTO taskDTO);
}
