package com.vv.mybatisflex;

import com.vv.mybatisflex.mapper.CouponTemplateMapper;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyBatisFlexApplicationTests {

	@Resource
	private CouponTemplateMapper couponTemplateMapper;
	@Test
	void contextLoads() {
		System.out.println(couponTemplateMapper.selectAll());
	}

}
