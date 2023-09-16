package com.vv.mybatisflex;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.vv.mybatisflex.mapper"})
public class MyBatisFlexApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyBatisFlexApplication.class, args);
	}

}
