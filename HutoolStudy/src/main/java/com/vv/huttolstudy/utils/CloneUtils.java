package com.vv.huttolstudy.utils;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjUtil;

/**
 * @author kw
 * @program WorkProject
 * @description 克隆工具类
 * @create 2023 - 11 - 18 16:17
 **/
public class CloneUtils {

    /**
     * 深克隆：对象必须实现序列化
     *
     * @param obj
     * @param <T>
     * @return
     */
    public static <T> T cloneByStream(T obj) {
        return ObjUtil.cloneByStream(obj);
    }

}
