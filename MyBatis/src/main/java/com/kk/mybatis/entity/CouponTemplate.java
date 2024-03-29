package com.kk.mybatis.entity;

import java.util.Date;

public class CouponTemplate extends CouponTemplateKey {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_coupon_template.template_name
     *
     * @mbg.generated Sat Sep 16 15:02:14 CST 2023
     */
    private String templateName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_coupon_template.create_time
     *
     * @mbg.generated Sat Sep 16 15:02:14 CST 2023
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_coupon_template.update_time
     *
     * @mbg.generated Sat Sep 16 15:02:14 CST 2023
     */
    private Date updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_coupon_template.delete_status
     *
     * @mbg.generated Sat Sep 16 15:02:14 CST 2023
     */
    private String deleteStatus;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_coupon_template.template_name
     *
     * @return the value of t_coupon_template.template_name
     *
     * @mbg.generated Sat Sep 16 15:02:14 CST 2023
     */
    public String getTemplateName() {
        return templateName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_coupon_template.template_name
     *
     * @param templateName the value for t_coupon_template.template_name
     *
     * @mbg.generated Sat Sep 16 15:02:14 CST 2023
     */
    public void setTemplateName(String templateName) {
        this.templateName = templateName == null ? null : templateName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_coupon_template.create_time
     *
     * @return the value of t_coupon_template.create_time
     *
     * @mbg.generated Sat Sep 16 15:02:14 CST 2023
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_coupon_template.create_time
     *
     * @param createTime the value for t_coupon_template.create_time
     *
     * @mbg.generated Sat Sep 16 15:02:14 CST 2023
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_coupon_template.update_time
     *
     * @return the value of t_coupon_template.update_time
     *
     * @mbg.generated Sat Sep 16 15:02:14 CST 2023
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_coupon_template.update_time
     *
     * @param updateTime the value for t_coupon_template.update_time
     *
     * @mbg.generated Sat Sep 16 15:02:14 CST 2023
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_coupon_template.delete_status
     *
     * @return the value of t_coupon_template.delete_status
     *
     * @mbg.generated Sat Sep 16 15:02:14 CST 2023
     */
    public String getDeleteStatus() {
        return deleteStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_coupon_template.delete_status
     *
     * @param deleteStatus the value for t_coupon_template.delete_status
     *
     * @mbg.generated Sat Sep 16 15:02:14 CST 2023
     */
    public void setDeleteStatus(String deleteStatus) {
        this.deleteStatus = deleteStatus == null ? null : deleteStatus.trim();
    }
}