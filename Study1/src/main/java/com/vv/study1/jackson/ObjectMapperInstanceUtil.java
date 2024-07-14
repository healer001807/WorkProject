package com.vv.study1.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.UUID;

/**
 * @author kw
 * @program WorkProject
 * @description
 * @create 2024 - 07 - 14 10:05
 **/
public class ObjectMapperInstanceUtil {

    /**
     * 转string
     *
     * @param userInfo
     * @return
     * @throws JsonProcessingException
     */
    public static String objToString(UserInfo userInfo) throws JsonProcessingException {
        return ObjectMapperInstance.INSTANCE.getObjectMapper().writeValueAsString(userInfo);
    }

    public static Object stringToObj(String value, Class clazz) throws JsonProcessingException {
        return ObjectMapperInstance.INSTANCE.getObjectMapper().readValue(value, clazz);
    }

    public static void main(String[] args) throws JsonProcessingException {
        UserInfo userInfo
                = new UserInfo();
        userInfo.setUserName("测试单例");
        userInfo.setId(UUID.randomUUID().toString().substring(0, 10));
        userInfo.setPrice(12.5);
        System.out.println(objToString(userInfo));

        System.out.println(stringToObj(objToString(userInfo), UserInfo.class));
    }
}
