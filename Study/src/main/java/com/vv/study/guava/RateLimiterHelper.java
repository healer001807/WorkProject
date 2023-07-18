package com.vv.study.guava;

import com.google.common.util.concurrent.RateLimiter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kw
 * @program WorkProject
 * @description
 * @create 2023 - 07 - 18 21:39
 **/
public class RateLimiterHelper {

    private static Map<String, RateLimiter> rateMap = new HashMap<>();

    /***
    * @description 
    * @param [limitType, limitCount]
    * @return com.google.common.util.concurrent.RateLimiter
    * @author 
    * @date 2023/7/18
    
    **/
    
    public static RateLimiter getRateLimiter(String limitType,double limitCount ){
        RateLimiter rateLimiter = rateMap.get(limitType);
        if(rateLimiter == null){
            rateLimiter = RateLimiter.create(limitCount);
            rateMap.put(limitType,rateLimiter);
        }
        return rateLimiter;
    }
}
