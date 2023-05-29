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
@Schema(name = "couponDTO",description = "优惠券信息")
public class CouponDTO {

    @Schema(name = "couponId", description = "优惠券id")
    private String couponId;
    @Schema(name = "couponName", description = "优惠券名称")
    private String couponName;
    @Schema(name = "couponType", description = "优惠券类型")
    private String couponType;
    @Schema(name = "couponFaceValue", description = "优惠券优惠面值")
    private String couponFaceValue;
    @Schema(name = "couponDeduction", description = "优惠券折扣")
    private String couponDeduction;
    @Schema(name = "createTime", description = "创建时间")
    private Date createTime;
    @Schema(name = "updateTime", description = "更新时间")
    private Date updateTime;
}
