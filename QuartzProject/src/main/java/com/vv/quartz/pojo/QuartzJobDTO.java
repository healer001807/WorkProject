package com.vv.quartz.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * @program: WorkProject
 * @description: quartz 任务信息
 * @author: kangwei
 * @create: 2023-07-17 15:41
 **/
@Data
public class QuartzJobDTO implements Serializable {

    /**
     * 任务名称
     */
    private String jobName;
    /**
     * 任务所属组
     */
    private String groupName;

    /**
     * 任务所属类
     */
    private String jobClass;

    /**
     * 任务调度时间表达式
     */
    private String cronExpression;

    /**
     * 附加参数
     */
    private String param;

}
