package com.vv.admin.controller;

import com.vv.admin.pojo.dto.CouponDTO;
import com.vv.admin.service.CouponService;
import com.vv.util.ResUtils;
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
    public ResUtils sendCoupon(@RequestParam("file") MultipartFile multipartFile) {
        return couponService.sendCoupon(multipartFile);
    }

    /***
     * @description 导出发券数据
     * @author kangwei
     * @date 2023-5-22
     * @param
     @return java.lang.String
     */
    @GetMapping("exportCoupon")
    public ResUtils exportCoupon() {
        // 直接导出全部
        return couponService.exportCoupon();
    }

    @PostMapping("selectCouponList")
    public ResUtils selectCouponList(@RequestBody CouponDTO couponDTO, @RequestParam(defaultValue = "0") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize) {

        return couponService.selectCouponList(couponDTO, pageNum, pageSize);
    }

}
