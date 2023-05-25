package com.vv.utils;

/**
 * @author kw
 * @program WrokProject
 * @description
 * @create 2023 - 05 - 20 16:04
 **/
public class NumberUtils {

    /**
     * 计算一批数据需要执行多少次
     *
     * @param total
     * @param perTotal
     * @return
     */
    public static int count(int total, int perTotal) {
        return (total + perTotal) / 2;
    }
}
