package com.vv.study1.pay;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.List;
import java.util.Map;

/**
 * @author kw
 * @program WorkProject
 * @description
 * @create 2024 - 03 - 30 17:58
 **/
public class PayService implements InitializingBean, ApplicationContextAware {

    List<IPay> pays;
    private ApplicationContext applicationContext;

    public void pay(String code) {
        for (IPay pay : pays) {
            if (pay.supports(code)) {
                pay.pay();
            }
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Map<String, IPay> beansOfType = applicationContext.getBeansOfType(IPay.class);
        beansOfType.forEach((k, v) -> pays.add(v));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
