package com.vv.admin.utils;

import cn.hutool.core.collection.CollectionUtil;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author kw
 * @program WorkProject
 * @description 树形结构工具类
 * @create 2023 - 07 - 04 22:42
 **/
public class TreeUtils {

    /***
     * @description list 转树形结构
     * @param [list, nodeIdFun, nodePidFun, childListFun, predicate]
     * @return java.util.List<M>
     * @author
     * @date 2023/7/4
     **/

    public static <M, T> List<M> listToTree(List<M> list, Function<M, T> nodeIdFun, Function<M, T> nodePidFun,
                                            BiConsumer<M, List<M>> childListFun, Predicate<M> predicate) {
        if (CollectionUtil.isEmpty(list)) {
            return Collections.emptyList();
        }
        //
        Map<T, List<M>> tListMap = list.stream().collect(Collectors.groupingBy(nodeIdFun));
        list.forEach(model -> childListFun.accept(model, tListMap.get(nodeIdFun.apply(model))));
        return list.stream().filter(predicate).collect(Collectors.toList());
    }

    /**
     * 树形结构转List
     *
     * @param t
     * @param childListFun
     * @param childConsumer
     * @param predicate
     * @param <M>
     * @return
     */
    public static <M> List<M> treeToList(List<M> t, Function<M, List<M>> childListFun,
                                         BiConsumer<M, List<M>> childConsumer, Predicate<M> predicate) {
        List<M> list = Collections.emptyList();
        if (CollectionUtil.isEmpty(t)) {
            return list;
        }
        treeToList(t, list, childListFun);
        list.forEach(model -> childConsumer.accept(model, null));
        list.addAll(list.stream().filter(predicate).collect(Collectors.toList()));
        return list;
    }

    /***
     * @description 内部转化
     * @param [source, target, childListFun]
     * @return void
     * @author
     * @date 2023/7/4
     **/

    private static <F> void treeToList(List<F> source, List<F> target, Function<F, List<F>> childListFun) {
        target.addAll(source);
        source.forEach(model -> {
            List<F> childList = childListFun.apply(model);
            treeToList(childList, target, childListFun);
        });
    }

}
