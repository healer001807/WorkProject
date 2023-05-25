package com.vv.controller;

import com.vv.service.CouponService;
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

    // 导出用户发券信息 模拟百万数据
    // job

    /***
     * @description 导出发券数据
     * @author kangwei
     * @date 2023-5-22
     * @param
     @return java.lang.String
     */
    @GetMapping("exportCoupon")
    public String exportCoupon() {
        // 直接导出全部
        return couponService.exportCoupon();
    }

}
