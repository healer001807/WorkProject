package com.vv.mybatisflex;

import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.update.UpdateWrapper;
import com.mybatisflex.core.util.UpdateEntity;
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
import java.util.UUID;

import static com.vv.mybatisflex.table.CouponTableDef.coupon;

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
        QueryWrapper queryWrapper = QueryWrapper.create().select().where(coupon.couponSeq.eq("1"));
        List<Coupon> coupons = couponMapper.selectListByQuery(queryWrapper);
        System.out.println(coupons);
    }

    @Test
    public void test4() {
        QueryWrapper select = QueryWrapper.create().select(coupon.couponSeq, coupon.couponStatus);
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
        QueryWrapper queryWrapper = QueryWrapper.create().select().where(coupon.couponSeq.ge(100)).and(coupon.couponStatus.ge(100));
        List<Coupon> coupons = couponMapper.selectListByQuery(queryWrapper);
        System.out.println(coupons);
    }

    @Test
    public void test6() {
        Coupon coupon = UpdateEntity.of(Coupon.class);
        coupon.setCouponSeq("100");
        coupon.setUserPhone("18781540377");

        int update = couponMapper.update(coupon);
        System.out.println(update);
    }

    @Test
    public void test7() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.where(coupon.couponSeq.eq(1)).or(coupon.userPhone.eq("1"));

        Coupon coupon1 = couponMapper.selectOneByQuery(queryWrapper);
        System.out.println(coupon1);
    }

    @Test
    public void test8() {
        QueryWrapper queryWrapper = new QueryWrapper()
                .where(coupon.userPhone.eq("100"));

        Page<Coupon> paginate = couponMapper.paginate(1, 10, queryWrapper);
        System.out.println(paginate);
    }

    @Test
    public void test9() {
        // xml分页
        QueryWrapper queryWrapper = new QueryWrapper()
                .where(Coupon::getCouponSeq).eq("1")
                .and(Coupon::getCouponStatus).eq("1");

        Page<Object> objectPage = couponMapper.xmlPaginate("selectByPage", Page.of(1, 10), queryWrapper);
        System.out.println(objectPage);
    }

    @Test
    public void test10() {

        Coupon coupon1 = new Coupon();
        coupon1.setUserPhone("18781540377");
        coupon1.setCouponSeq("2");
        coupon1.setTemplateSeq("100");
        coupon1.setCouponStatus("0");
        Coupon entity = UpdateWrapper.of(coupon1)
                .setRaw(coupon.createTime, "now()") // 用这种方式需要insert，不能用insertSelective
                .setRaw(coupon.updateTime, "now()").toEntity();
        System.out.println(entity);
        couponMapper.insert(entity);
    }

}
