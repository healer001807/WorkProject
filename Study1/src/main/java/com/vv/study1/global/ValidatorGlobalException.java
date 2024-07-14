package com.vv.study1.global;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * @author kw
 * @program WorkProject
 * @description
 * @create 2024 - 07 - 13 10:24
 **/
@RestControllerAdvice
public class ValidatorGlobalException {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public String methodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<ObjectError> allErrors = e.getAllErrors();
        List<String> collect = allErrors.stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .toList();
        return collect.toString();
    }

}
