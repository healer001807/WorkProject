package com.vv.mybatisflex.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

/**
 * 实体类。
 *
 * @author kw
 * @since 2023-09-07
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "t_coupon")
public class Coupon implements Serializable {

    /**
     * 券序列号
     */
    @Id
    private String couponSeq;

    /**
     * 用户手机号
     */
    private String userPhone;

    /**
     * 券模板
     */
    private String templateSeq;

    /**
     * 券状态 0-未使用 1-已使用
     */
    private String couponStatus;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    private UserInfo userInfo;


    public UserInfo getUserInfo() {
        if (userInfo == null) {
            this.userInfo = new UserInfo();
        }
        return this.userInfo;
    }

    public UserInfo enableUserInfo() {
        return getUserInfo();
    }

}
