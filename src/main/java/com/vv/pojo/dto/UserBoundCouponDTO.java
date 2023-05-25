package com.vv.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @program: WorkProject
 * @description: 用户绑定券
 * @author: kangwei
 * @create: 2023-05-23 15:04
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserBoundCouponDTO {

    private String userCouponId;
    private String userPhone;
    private String couponId;
    private Date createTime;
    private Date updateTime;

}
