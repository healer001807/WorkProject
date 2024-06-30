package com.vv.study1.processControl.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;

/**
 * @author kw
 * @program WorkProject
 * @description 时间控制
 * @create 2023 - 12 - 21 21:46
 **/
@Data
public class TimeControlConfig {

    /**
     * 编号
     */
    private String id;
    /**
     * 时间类型 0-单次控制 1-每日控制
     */
    private String timeType;
    /**
     * 控制开始时间
     */
    private String controlStartTime;
    /**
     * 控制结束时间
     */
    private String controlEndTime;
    /**
     * 创建时间
     */
    @JsonIgnore
    private Date createTime;
    /**
     * 更新时间
     */
    @JsonIgnore
    private Date updateTime;
    /**
     * 删除状态 0-已删除 1-未删除
     */
    @JsonIgnore
    private Integer deleteStatus;

    /**
     * 流程id
     */
    private String processControlId;
    /**
     * 用户白名单
     */
    private String userList;
}
