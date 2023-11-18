package com.vv.huttolstudy.utils;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.vv.huttolstudy.pojo.User;

/**
 * @author kw
 * @program WorkProject
 * @description 对象合并
 * @create 2023 - 11 - 18 12:15
 **/
public class MergeUtils {

    private static final CopyOptions copyOptions = CopyOptions.create().setIgnoreNullValue(true).setOverride(false);
    private static final CopyOptions copyOptionsOverride = CopyOptions.create().setIgnoreNullValue(true).setOverride(true);


    /**
     * 将源对象source中的属性值合并到目标对象target中
     * 忽略源对象中的null值，并且不将源对象中的非null值覆盖到目标对象中
     * 返回目标对象
     *
     * @param source
     * @param target
     * @return
     */
    public static Object merge(Object source, Object target) {
        BeanUtil.copyProperties(source, target, copyOptions);
        return target;
    }

    /**
     * 将源对象source中的属性值合并到目标对象target中
     * 忽略源对象中的null值，并且将源对象中的非null值覆盖到目标对象中
     * 返回目标对象
     *
     * @param source
     * @param target
     * @return
     */

    public static Object mergeOverride(Object source, Object target) {
        BeanUtil.copyProperties(source, target, copyOptionsOverride);
        return target;
    }
}
