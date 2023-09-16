package com.vv.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDate;
import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author kangwei
 * @since 2023-09-16
 */
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
    private LocalDate createTime;

//    @ApiModelProperty("更新时间")
    private LocalDate updateTime;

    public String getCouponSeq() {
        return couponSeq;
    }

    public void setCouponSeq(String couponSeq) {
        this.couponSeq = couponSeq;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getTemplateSeq() {
        return templateSeq;
    }

    public void setTemplateSeq(String templateSeq) {
        this.templateSeq = templateSeq;
    }

    public String getCouponStatus() {
        return couponStatus;
    }

    public void setCouponStatus(String couponStatus) {
        this.couponStatus = couponStatus;
    }

    public LocalDate getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDate createTime) {
        this.createTime = createTime;
    }

    public LocalDate getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDate updateTime) {
        this.updateTime = updateTime;
    }

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
