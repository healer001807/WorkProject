package com.example.workproject.mapper;

import com.example.workproject.pojo.dto.TaskDTO;
import org.apache.ibatis.annotations.Mapper;

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
     * @param [taskDTO]
     * @return int
     * @author
     * @date 2023/5/23
     **/

    int insertTask(TaskDTO taskDTO);
}
