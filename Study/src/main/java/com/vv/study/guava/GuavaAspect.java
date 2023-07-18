package com.vv.study.guava;

import com.google.common.util.concurrent.RateLimiter;
import com.vv.util.ResUtils;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Optional;

/**
 * @author kw
 * @program WorkProject
 * @description Guava 限流切面
 * @create 2023 - 07 - 18 21:25
 **/
@Slf4j
@Aspect
@Component
public class GuavaAspect {

    @Pointcut("execution(@GuavaLimitAnnotation * *(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
//@Before("execution(@GuavaLimitAnnotation * *(..))")
    public void limitJoinPoint(JoinPoint joinPoint) {
        // 获取方法
        Method[] methods = joinPoint.getTarget().getClass().getMethods();

        System.out.println(joinPoint.getSignature().getName());
        Optional.ofNullable(methods).orElseThrow(() -> new RuntimeException("切面异常，请重新操作"));
        Method currMethod = null;
        for (Method method : methods) {
            System.out.println(method.getName());
            if (method.getName().equals(joinPoint.getSignature().getName())) {
                log.info("method==>" + method);
                currMethod = method;
                break;
            }
        }
        // 非空校验
        Optional.ofNullable(currMethod).orElseThrow(() -> new RuntimeException("切面异常，请重新操作"));

        //
        String limitType = currMethod.getAnnotation(GuavaLimitAnnotation.class).limitType();
        int limitCount = currMethod.getAnnotation(GuavaLimitAnnotation.class).limitCount();
        // guava令牌桶算法
        RateLimiter rateLimiter = RateLimiterHelper.getRateLimiter(limitType, limitCount);
        if (rateLimiter.tryAcquire()) {
            log.info("非限流");
        } else {
            log.info("限流");
            //todo 要怎么返回比较好 看案例使用的时response输出，我用的ResUtils.failed这种方式不行
            // ResUtils.failed(10001, "限流中");
        }
    }
}
