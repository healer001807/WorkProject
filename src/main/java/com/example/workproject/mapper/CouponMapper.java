package com.example.workproject.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author kw
 * @program WrokProject
 * @description 优惠券数据操作
 * @create 2023 - 05 - 20 17:49
 **/
@Mapper
public interface CouponMapper {

    /***
     * @description 批量绑定优惠券
     * @param couponBatch
     * @return java.lang.Integer
     * @author
     * @date 2023/5/21
     **/

    Integer insertCouponBatch(List<Map<String, Object>> couponBatch);
}
