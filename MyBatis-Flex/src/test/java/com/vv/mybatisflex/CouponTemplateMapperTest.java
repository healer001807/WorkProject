package com.vv.mybatisflex;

import com.mybatisflex.core.query.QueryWrapper;
import com.vv.mybatisflex.entity.CouponTemplate;
import com.vv.mybatisflex.mapper.CouponTemplateMapper;
import com.vv.mybatisflex.table.CouponTableDef;
import com.vv.mybatisflex.table.CouponTemplateTableDef;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.vv.mybatisflex.table.CouponTableDef.coupon;
import static com.vv.mybatisflex.table.CouponTemplateTableDef.couponTemplate;

/**
 * @author kw
 * @program WorkProject
 * @description
 * @create 2023 - 09 - 10 21:55
 **/

@SpringBootTest
public class CouponTemplateMapperTest {

    @Resource
    private CouponTemplateMapper couponTemplateMapper;


    @Test
    public void test1() {
        QueryWrapper queryWrapper = QueryWrapper.create().select(couponTemplate.allColumns, coupon.allColumns)
                .from(couponTemplate)
                .leftJoin(coupon)
                .on(coupon.templateSeq.eq(couponTemplate.templateSeq));

        List<CouponTemplate> couponTemplates = couponTemplateMapper.selectListByQuery(queryWrapper);
        System.out.println(couponTemplates);
    }

    @Test
    public void test2() {
        QueryWrapper queryWrapper = QueryWrapper.create()
                .select(couponTemplate.templateSeq, coupon.couponSeq)
                .from(couponTemplate.as("t"), coupon.as("t1"))
                .where(couponTemplate.templateSeq.eq(coupon.templateSeq));

        List<CouponTemplate> couponTemplates = couponTemplateMapper.selectListByQuery(queryWrapper);
        System.out.println(couponTemplates);

    }
}
