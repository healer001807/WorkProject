package com.vv.huttolstudy.object;

import cn.hutool.core.util.ObjUtil;

import java.util.function.Supplier;

/**
 * @author kw
 * @program WorkProject
 * @description 工具类学习：用工具类回顾基础知识
 * @create 2023 - 11 - 18 16:30
 **/
public class StudyObjectUtils {

    /**
     * equal：两个数值或对象是否相等,返回boolean类型变量
     * 相等 true
     * 不相等 false
     *
     * @param obj1
     * @param obj2
     * @return
     */
    public static boolean equal(String obj1, String obj2) {
        return ObjUtil.equal(obj1, obj2);
    }

    /**
     * compare比较：两个数值或对象比较，返回int类型值
     * obj1 大于 obj2 返回 1
     * obj1 小于 obj2 返回-1
     * obj1 等于 obj2 返回 0
     *
     * @param obj1
     * @param obj2
     * @return
     */
    public static int compare(String obj1, String obj2) {
        return ObjUtil.compare(obj1, obj2);
    }

    /**
     * 判断obj1是否为null
     * 如为null 返回默认值defaultValue
     * obj1为空字符串（""）都不满足要求
     *
     * @param obj1
     * @param defaultValue
     * @param <T>
     * @return
     */
    public static <T> T defaultIfNull(T obj1, T defaultValue) {
        return ObjUtil.defaultIfNull(obj1, defaultValue);
    }

    /**
     * 默认值用函数式编程代替
     *
     * @param obj1
     * @param supplier
     * @param <T>
     * @return
     */
    public static <T> T defaultIfNullV1(T obj1, Supplier<T> supplier) {
        return ObjUtil.defaultIfNull(obj1, supplier);
    }


    public static void main(String[] args) {
        //System.out.println(equal("1", "0"));
        //System.out.println(compare("2", "2"));
//        System.out.println(defaultIfNull(null, "1"));
        System.out.println(defaultIfNullV1(null, () -> "2"));

    }
}
