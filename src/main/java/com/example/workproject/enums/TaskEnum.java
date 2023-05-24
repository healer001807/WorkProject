package com.example.workproject.enums;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author kw
 * @program WorkProject
 * @description 任务枚举
 * @create 2023 - 05 - 24 20:11
 **/
@NoArgsConstructor
@AllArgsConstructor
public enum TaskEnum {

    NOT_EXECUTED("0", "未执行"),
    EXECUTING("1", "执行中"),

    SUCCESS("2", "执行成功"),

    FAIL("3", "执行失败");

    private String status;
    private String statusVal;

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public String getStatusVal() {
        return statusVal;
    }

    public void setStatusVal(String statusVal) {
        this.statusVal = statusVal;
    }
}
