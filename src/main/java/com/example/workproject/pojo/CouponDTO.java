package com.example.workproject.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @program: WorkProject
 * @description: 优惠券信息表
 * @author: kangwei
 * @create: 2023-05-23 14:57
 **/
@Data
public class CouponDTO {

    private String couponId;
    private String couponName;
    private String couponType;
    private String couponFaceValue;
    private String couponDeduction;
    private Date createTime;
    private Date updateTime;
}
