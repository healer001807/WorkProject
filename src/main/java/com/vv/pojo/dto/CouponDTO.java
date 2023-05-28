package com.vv.pojo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @program: WorkProject
 * @description: 优惠券信息表
 * @author: kangwei
 * @create: 2023-05-23 14:57
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "优惠券信息")
public class CouponDTO {

    private String couponId;
    private String couponName;
    private String couponType;
    private String couponFaceValue;
    private String couponDeduction;
    private Date createTime;
    private Date updateTime;
}
