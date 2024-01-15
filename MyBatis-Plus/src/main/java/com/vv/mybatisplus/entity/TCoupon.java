package com.vv.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 *
 * </p>
 *
 * @author kangwei
 * @since 2023-09-16
 */
@Setter
@Getter
@TableName("t_coupon")
//@ApiModel(value = "TCoupon对象", description = "")
public class TCoupon implements Serializable {

    private static final long serialVersionUID = 1L;

    //    @ApiModelProperty("券序列号")
    @TableId("coupon_seq")
    private String couponSeq;

    //    @ApiModelProperty("用户手机号")
    private String userPhone;

    //    @ApiModelProperty("券模板")
    private String templateSeq;

    //    @ApiModelProperty("券状态 0-未使用 1-已使用")
    private String couponStatus;

    //    @ApiModelProperty("创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDate createTime;

    //    @ApiModelProperty("更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDate updateTime;


    @Override
    public String toString() {
        return "TCoupon{" +
                "couponSeq = " + couponSeq +
                ", userPhone = " + userPhone +
                ", templateSeq = " + templateSeq +
                ", couponStatus = " + couponStatus +
                ", createTime = " + createTime +
                ", updateTime = " + updateTime +
                "}";
    }
}
