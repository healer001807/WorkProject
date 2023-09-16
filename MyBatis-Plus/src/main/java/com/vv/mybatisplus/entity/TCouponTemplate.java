package com.vv.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("t_coupon_template")
//@ApiModel(value = "TCouponTemplate对象", description = "")
public class TCouponTemplate implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("template_seq")
    private String templateSeq;

    private String templateName;

    private LocalDate createTime;

    private LocalDate updateTime;

    private String deleteStatus;

    public String getTemplateSeq() {
        return templateSeq;
    }

    public void setTemplateSeq(String templateSeq) {
        this.templateSeq = templateSeq;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
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

    public String getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(String deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

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
