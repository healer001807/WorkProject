package com.vv.admin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @program: WorkProject
 * @description: redis模板配置
 * @author: kangwei
 * @create: 2023-07-11 10:24
 **/
@Configuration
public class RedisTemplateConfig {


    /***
     * @description redis 连接工厂Bean
     * @author kangwei
     * @date 2023-7-11
     * @param
     @return org.springframework.data.redis.connection.RedisConnectionFactory
     */
    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
//        JedisConnectionFactory connectionFactory = new JedisConnectionFactory();
        LettuceConnectionFactory connectionFactory = new LettuceConnectionFactory();
        return connectionFactory;
    }

    /***
     * @description redis 模板bean 注入
     * @author kangwei
     * @date 2023-7-11
     * @param
     @return org.springframework.data.redis.core.RedisTemplate
     */
    @Bean(value = "redisTemplate")
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }

    /***
     * @description redis string 模板Bean 注入
     * @author kangwei
     * @date 2023-7-11
     * @param
     @return org.springframework.data.redis.core.StringRedisTemplate
     */
//    @Bean(value = "stringRedisTemplate")
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        stringRedisTemplate.setConnectionFactory(redisConnectionFactory);
        return stringRedisTemplate;
    }


}
