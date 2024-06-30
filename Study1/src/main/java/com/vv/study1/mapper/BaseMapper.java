package com.vv.study1.mapper;

import java.util.List;

/**
 * @author kw
 * @program WorkProject
 * @description
 * @create 2024 - 03 - 24 22:17
 **/
public interface BaseMapper {

    <T> List<T> selectListByExample(Object obj);
}
