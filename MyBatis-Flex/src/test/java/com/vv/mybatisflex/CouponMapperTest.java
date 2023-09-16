package com.vv.mybatisflex;

import com.vv.mybatisflex.entity.Coupon;
import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.query.QueryCondition;
import com.mybatisflex.core.query.QueryWrapper;
import com.vv.mybatisflex.mapper.CouponMapper;
import com.vv.mybatisflex.table.CouponTableDef;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author kw
 * @program WorkProject
 * @description
 * @create 2023 - 09 - 10 21:55
 **/

@SpringBootTest
public class CouponMapperTest {

    @Resource
    private CouponMapper couponMapper;
    /**
     * 20230910 QueryWrapper.create()
     */
    @Test
    public void test() {
        QueryColumn queryColumn = new QueryColumn();
        queryColumn.setName("coupon_seq");
        QueryCondition queryCondition = QueryCondition.create(queryColumn, "1111");
        QueryWrapper where = QueryWrapper.create().select().where(queryCondition);
        List<Coupon> coupons = couponMapper.selectListByQuery(where);
        System.out.println(coupons);
    }


    @Test
    public void test3() {
        QueryWrapper queryWrapper = QueryWrapper.create().select().where(CouponTableDef.coupon.couponSeq.eq("1"));
        List<Coupon> coupons = couponMapper.selectListByQuery(queryWrapper);
        System.out.println(coupons);
    }

    @Test
    public void test4() {
        QueryWrapper select = QueryWrapper.create().select(CouponTableDef.coupon.couponSeq, CouponTableDef.coupon.couponStatus);
        List<Coupon> coupons = couponMapper.selectListByQuery(select);
        System.out.println(coupons);
    }

    /**
     * SELECT * FROM tb_account
     * WHERE id >= 100
     * AND (sex = 1 OR sex = 2)
     * OR (age IN (18,19,20) AND user_name LIKE "%michael%" )
     */
    @Test
    public void test5() {
        QueryWrapper queryWrapper = QueryWrapper.create().select().where(CouponTableDef.coupon.couponSeq.ge(100)).and(CouponTableDef.coupon.couponStatus.ge(100));
        List<Coupon> coupons = couponMapper.selectListByQuery(queryWrapper);
        System.out.println(coupons);
    }

}
