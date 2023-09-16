package com.vv.mybatisflex.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.Table;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  实体类。
 *
 * @author kw
 * @since 2023-09-13
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "t_coupon_template")
public class CouponTemplate implements Serializable {

    @Id
    private String templateSeq;

    private String templateName;

    private Date createTime;

    private Date updateTime;

    private String deleteStatus;

    private List<Coupon> coupons;

}
