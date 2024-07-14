package com.vv.study1.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;

/**
 * @author kw
 * @program WorkProject
 * @description 单例模式-解决每次new ObjectMapper对象
 * @create 2024 - 07 - 14 10:05
 **/
@Getter
public enum ObjectMapperInstance {
    INSTANCE,
    ;
    private final ObjectMapper objectMapper = new ObjectMapper();

    ObjectMapperInstance() {
    }
}
