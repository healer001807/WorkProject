package com.vv.admin.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author kw
 * @program WorkProject
 * @description 日期时间工具类
 * @create 2023 - 05 - 23 22:01
 **/
public class DTimeUtils {

    /***
     * @description 获取日期格式文件名
     * @param []
     * @return java.lang.String
     * @author
     * @date 2023/5/23
     **/

    public static String getFileDateTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
    }
}
