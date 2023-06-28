package com.vv.admin.pojo.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author kw
 * @program WorkProject
 * @description 导出优惠券实体
 * @create 2023 - 05 - 24 20:44
 **/
@Setter
@Getter
@EqualsAndHashCode
public class CouponEasyExcelVO {
    @ExcelProperty("优惠券编号")
    private String couponId;
    @ExcelProperty("用户手机号")
    private String userPhone;
    @ExcelProperty("优惠券创建时间")
    @DateTimeFormat(value = "yyyy-MM-dd")
    private Date createTime;
}
