package com.example.workproject.task;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONString;
import cn.hutool.json.JSONUtil;
import com.example.workproject.service.CouponService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @program: WorkProject
 * @description: 优惠券定时任务
 * @author: kangwei
 * @create: 2023-05-22 16:25
 **/
@Lazy // 解决启动时执行定时任务
@Configuration
public class CouponScheduleTask {

    @Resource(name = "couponServiceImpl")
    private CouponService couponService;

    @Async // 解决cron一个周期内未执行完不执行下一个周期
    @Scheduled(cron = "0/2 * *  * * ?") // 每两分钟定时任务执行一次
    public void doExportCoupon() throws IOException {
        // 1.查任务表中待导出任务,可设计为一次查一个
        // 2.如果查询成功，则执行导出任务
        String resp = couponService.doExportCoupon();
        JSONObject parseObj = JSONUtil.parseObj(resp);
        // 如果导出失败，更新任务流水表
        if (!"0000".equals(parseObj.get("code"))) {
            // todo
            return;
        }
        // 导出成功 更新流水,excel上传到OSS
    }
}
