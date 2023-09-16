package com.kk.mybatis;

import com.kk.mybatis.entity.Coupon;
import com.kk.mybatis.entity.CouponKey;
import com.kk.mybatis.mapper.CouponMapper;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyBatisApplicationTests {
    @Resource
    private CouponMapper couponMapper;

    @Test
    void contextLoads() {
        CouponKey couponKey = new CouponKey();
        couponKey.setCouponSeq("11");
        System.out.println(couponMapper.selectByPrimaryKey(couponKey));
    }

}
