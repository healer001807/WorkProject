package com.vv.study1.pay;

/**
 * @author kw
 * @program WorkProject
 * @description
 * @create 2024 - 03 - 30 17:55
 **/
public interface IPay {
    boolean supports(String code);

    void pay();
}
