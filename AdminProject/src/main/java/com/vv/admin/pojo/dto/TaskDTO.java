package com.vv.admin.pojo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
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

@Schema(name = "taskDTO", description = "任务流水")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDTO {
    @Schema(name = "taskSeq", description = "任务流水号")
    private String taskSeq;
    @Schema(name = "taskType", description = "任务流水类型")
    private String taskType;
    @Schema(name = "taskStatus", description = "任务流水执行状态")
    private String taskStatus;
    @Schema(name = "createTime", description = "创建时间")
    private Date createTime;
    @Schema(name = "updateTime", description = "执行完成时间")
    private Date updateTime;
}
