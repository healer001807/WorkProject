package com.vv.admin.enums;

/**
 * @author kw
 * @program WorkProject
 * @description ip地址枚举类
 * @create 2023 - 06 - 28 21:05
 **/
public enum IPEnum {
    UN_KNOWN,
    PROXY_CLIENT_IP,
    X_FORWARDED_FOR,
    WL_PROXY_CLIENT_IP,
    X_REAL_IP;
}
