package com.example.workproject.controller;

import com.example.workproject.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author kw
 * @program WrokProject
 * @description 优惠券
 * @create 2023 - 05 - 20 14:27
 **/
@RestController
@RequestMapping("coupon")
public class CouponController {

    @Autowired
    private CouponService couponService;

    /***
     * @description 批量绑定优惠券
     * @param multipartFile
     * @return java.lang.String
     * @author
     * @date 2023/5/21
     **/

    @PostMapping("sendCoupon")
    public String sendCoupon(@RequestParam("file") MultipartFile multipartFile) {
        return couponService.sendCoupon(multipartFile);
    }

}
