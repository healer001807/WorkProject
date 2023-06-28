package com.vv.admin.log;

import com.vv.admin.enums.BusinessTypeEnum;

import java.lang.annotation.*;

/**
 * @author kw
 * @program WorkProject
 * @description 日志注解
 * @create 2023 - 06 - 27 22:43
 **/

@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {

    String value() default "";

    /**
     * 模块
     */
    String title() default "测试模块";

    /**
     * 功能
     */
    BusinessTypeEnum businessType() default BusinessTypeEnum.OTHER;

}
