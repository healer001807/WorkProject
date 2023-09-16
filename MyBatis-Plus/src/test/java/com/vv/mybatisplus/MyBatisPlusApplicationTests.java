package com.vv.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vv.mybatisplus.entity.TCoupon;
import com.vv.mybatisplus.entity.TCouponTemplate;
import com.vv.mybatisplus.mapper.TCouponMapper;
import com.vv.mybatisplus.mapper.TCouponTemplateMapper;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MyBatisPlusApplicationTests {

    @Resource
    private TCouponMapper tCouponMapper;
    @Resource
    private TCouponTemplateMapper tCouponTemplateMapper;

    @Test
    void contextLoads() {
        List<TCoupon> tCoupons = tCouponMapper.selectList(null);
        System.out.println(tCoupons);
        List<TCouponTemplate> tCouponTemplates = tCouponTemplateMapper.selectList(null);
        System.out.println(tCouponTemplates);
    }

}
