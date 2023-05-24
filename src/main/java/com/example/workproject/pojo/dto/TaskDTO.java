package com.example.workproject.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author kw
 * @program WorkProject
 * @description 任务执行表
 * @create 2023 - 05 - 23 22:52
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDTO {

    private String taskSeq;
    private String taskType;
    private String taskStatus;
    private Date createTime;
    private Date updateTime;
}
