package com.vv.business.init;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @program: WorkProject
 * @description: 初始化地址缓存
 * @author: kangwei
 * @create: 2023-07-11 09:41
 **/
@Component
public class InitAddressRedis {

    // boot3.0不要使用javax下的 @Resource,此注解无法注入，boot3用jakarta包下的 @Resource
    @Autowired
    private RedisTemplate redisTemplate;

    /*** 
     * @description 初始化加载地址信息到redis缓存
     * @author kangwei
     * @date 2023-7-11
     * @param []
     @return void
     */
    @PostConstruct
    public void initGetAddress() {
        // todo 未建立表
        System.out.println("99999999999999" + redisTemplate);
    }

}
