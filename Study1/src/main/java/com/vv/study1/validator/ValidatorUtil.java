package com.vv.study1.validator;


import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

/**
 * @author kw
 * @program WorkProject
 * @description 校验工具
 * @create 2023 - 12 - 19 22:09
 **/
public class ValidatorUtil {
    public static Validator getValidator() {
        return validator;
    }

    static Validator validator;

    static {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

}
