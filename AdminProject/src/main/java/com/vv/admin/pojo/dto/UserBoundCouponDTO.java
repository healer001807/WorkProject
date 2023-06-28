package com.vv.admin.pojo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(name = "userBoundCouponDTO", description = "客户绑优惠券")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserBoundCouponDTO {

    @Schema(name = "userCouponId", description = "客户绑优惠券流水号")
    private String userCouponId;
    @Schema(name = "userPhone", description = "客户手机号")
    private String userPhone;
    @Schema(name = "couponId", description = "优惠券流水号")
    private String couponId;
    @Schema(name = "createTime", description = "创建时间")
    private Date createTime;
    @Schema(name = "updateTime", description = "更新时间")
    private Date updateTime;

}
