package com.vv.admin.enums;

/**
 * @author kw
 * @program WorkProject
 * @description 业务枚举
 * @create 2023 - 06 - 27 22:45
 **/
public enum BusinessTypeEnum {
    /**
     * 其它
     */
    OTHER(0,"其它"),

    /**
     * 新增
     */
    INSERT(1,"新增"),

    /**
     * 修改
     */
    UPDATE(2,"修改"),

    /**
     * 删除
     */
    DELETE(3,"删除");

    private Integer code;

    private String msg;

    BusinessTypeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }


}
