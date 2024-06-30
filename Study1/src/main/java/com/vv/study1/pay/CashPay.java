package com.vv.study1.pay;

/**
 * @author kw
 * @program WorkProject
 * @description
 * @create 2024 - 03 - 30 17:56
 **/
public class CashPay implements IPay {
    @Override
    public boolean supports(String code) {
        return "cash".equals(code);
    }

    @Override
    public void pay() {
        System.out.println("现金支付");
    }
}
