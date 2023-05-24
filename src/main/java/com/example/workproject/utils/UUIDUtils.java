package com.example.workproject.utils;

import java.util.UUID;

/**
 * @author kw
 * @program WorkProject
 * @description 流水号工具类
 * @create 2023 - 05 - 24 20:09
 **/
public class UUIDUtils {

    /***
     * @description 生成UUID
     * @param
     * @return java.lang.String
     * @author
     * @date 2023/5/24
     **/

    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
