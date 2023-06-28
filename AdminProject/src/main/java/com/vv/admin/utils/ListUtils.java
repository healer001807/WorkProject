package com.vv.admin.utils;

import java.util.List;

/**
 * @author kw
 * @program WrokProject
 * @description 集合工具类
 * @create 2023 - 05 - 20 15:55
 **/
public class ListUtils<T> {

    /***
     * @description 根据索引取集合
     * @param tList, fromIndex, toIndex
     * @return java.util.List<T>
     * @author
     * @date 2023/5/20
     **/

    public static <T> List<T> getSubList(List<T> tList, int fromIndex, int toIndex) {
        return tList.subList(fromIndex, toIndex);
    }



}
