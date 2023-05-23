package com.example.workproject.task;

import com.example.workproject.service.CouponService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @program: WorkProject
 * @description: 优惠券定时任务
 * @author: kangwei
 * @create: 2023-05-22 16:25
 **/
@Configuration
public class CouponScheduleTask {

    @Resource(name = "couponService")
    private CouponService couponService;

    @Scheduled(cron = "0/1 * *  * * ?") // 每一分钟定时任务执行一次
    public void doExportCoupon() {
        // 1.查任务表中待导出任务,可设计为一次查一个
        // 2.如果查询成功，则执行导出任务
        String resp = couponService.doExportCoupon();
        // 3.结束
    }
}
