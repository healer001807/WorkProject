package com.example.workproject;

import com.example.workproject.mapper.CouponMapper;
import com.example.workproject.pojo.dto.UserBoundCouponDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author kw
 * @program WorkProject
 * @description
 * @create 2023 - 05 - 23 22:34
 **/

@SpringBootTest
public class CouponMapperTest {

    @Autowired
    private CouponMapper couponMapper;

    @Test
    public void selectTotal() {
        int total = couponMapper.selectTotal();
        System.out.println(total);
    }

    @Test
    public void selectCouponList() {
        List<UserBoundCouponDTO> userBoundCouponDTOS = couponMapper.selectCouponList(0, 10);
        userBoundCouponDTOS.stream().forEach(System.out::println);
    }

}
