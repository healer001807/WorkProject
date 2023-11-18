package com.vv.huttolstudy.utils;

import com.vv.huttolstudy.pojo.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author kw
 * @program WorkProject
 * @description
 * @create 2023 - 11 - 18 12:31
 **/
class MergeUtilsTest {

    @Test
    void merge() {
        User source = new User(null, "小明", null);
        User target = new User("2", "小李", "18887814120");
        Object merge = MergeUtils.merge(source, target);
        System.out.println(merge);
    }

    @Test
    void mergeOverride() {
        User source = new User(null, "小明", null);
        User target = new User("2", "小李", "18887814120");
        Object mergeOverride = MergeUtils.mergeOverride(source, target);
        System.out.println(mergeOverride);
    }
}