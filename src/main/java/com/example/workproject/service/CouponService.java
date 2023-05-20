package com.example.workproject.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author kw
 * @program WrokProject
 * @description 优惠券业务接口
 * @create 2023 - 05 - 20 14:31
 **/
public interface CouponService {
    /***
     * @description 批量给客户发券
     * @param multipartFile
     * @return java.lang.String
     * @author
     * @date 2023/5/20
     **/

    String sendCoupon(MultipartFile multipartFile);
}