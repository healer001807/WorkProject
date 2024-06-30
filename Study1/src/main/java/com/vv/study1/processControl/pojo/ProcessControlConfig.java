package com.vv.study1.processControl.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author kw
 * @program WorkProject
 * @description 流程控制配置类
 * @create 2023 - 12 - 21 21:46
 **/
@Data
@Accessors(chain = true)
public class ProcessControlConfig implements Serializable {

    /**
     * 编号
     */
    private String id;
    /**
     * 操作场景 1-5 场景1-场景5
     */
    private String operatorScene;
    /**
     * 产品 1-5 产品1-产品5
     */
    private String productType;
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
}
