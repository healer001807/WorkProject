package com.vv;

import com.vv.service.CouponService;
import com.vv.utils.ResUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

/**
 * @author kw
 * @program WorkProject
 * @description
 * @create 2023 - 05 - 23 22:44
 **/

@SpringBootTest
public class CouponServiceTest {

    @Autowired
    private CouponService couponService;

    @Test
    public void exportCoupon() {
        // 测插入导出流水
        couponService.exportCoupon();
    }

    @Test
    public void doExportCoupon() throws IOException {
        ResUtils doExportCoupon = couponService.doExportCoupon();
        System.out.println(doExportCoupon);
    }

    @Test
    public void uploadTest() {
        couponService.uploadExcel("20230524210223.xlsx");
    }

}
