package com.vv.study1.pay;

/**
 * @author kw
 * @program WorkProject
 * @description
 * @create 2024 - 03 - 30 17:56
 **/
public class WXPay implements IPay {
    @Override
    public void pay() {
        System.out.println("微信支付");
    }
    @Override
    public boolean supports(String code) {
        return "wx".equals(code);
    }
}
