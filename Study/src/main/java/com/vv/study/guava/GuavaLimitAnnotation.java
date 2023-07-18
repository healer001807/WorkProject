package com.vv.study.guava;

import java.lang.annotation.*;

/**
 * @author kw
 * @program WorkProject
 * @description Guava 限流注解
 * @create 2023 - 07 - 18 21:24
 **/
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD})
public @interface GuavaLimitAnnotation {
    String limitType();

    int limitCount() default 0;
}
