package com.vv.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;

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
@TableName("t_coupon_template")
//@ApiModel(value = "TCouponTemplate对象", description = "")
public class TCouponTemplate implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("template_seq")
    private String templateSeq;

    private String templateName;

    @TableField(fill = FieldFill.INSERT)
    private LocalDate createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDate updateTime;

    private String deleteStatus;

    @Override
    public String toString() {
        return "TCouponTemplate{" +
                "templateSeq = " + templateSeq +
                ", templateName = " + templateName +
                ", createTime = " + createTime +
                ", updateTime = " + updateTime +
                ", deleteStatus = " + deleteStatus +
                "}";
    }
}
