package com.vv.admin.task;

import cn.hutool.core.collection.CollUtil;
import com.vv.admin.enums.TaskEnum;
import com.vv.admin.pojo.dto.TaskDTO;
import com.vv.admin.service.CouponService;
import com.vv.admin.service.TaskService;
import com.vv.util.ResUtils;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

/**
 * @program: WorkProject
 * @description: 优惠券定时任务
 * @author: kangwei
 * @create: 2023-05-22 16:25
 **/
@Lazy(value = false) // 解决启动时执行定时任务
@EnableScheduling // 开启定时任务
@Component
public class CouponScheduleTask {

    @Resource(name = "couponServiceImpl")
    private CouponService couponService; // 优惠券业务
    @Resource
    private TaskService taskService; // 任务流水业务

    @Async // 解决cron一个周期内未执行完不执行下一个周期
    @Scheduled(cron = "0 0/1 * * * ?") // 每两分钟定时任务执行一次
    public void doExportCoupon() throws IOException {
        // 1.查任务表中待导出任务,可设计为一次查一个，也可设计为多个，暂时设计为一个
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setTaskType(TaskEnum.COUPON.getStatus());
        taskDTO.setTaskStatus(TaskEnum.NOT_EXECUTED.getStatus());
        List<TaskDTO> taskDTOS = taskService.selectTaskList(taskDTO);

        // 2.非空校验
        if (CollUtil.isEmpty(taskDTOS)) {
            return;
        }

        taskDTOS.stream().findFirst().ifPresent(taskDTO1 -> {
            taskDTO1.setTaskStatus(TaskEnum.EXECUTING.getStatus()); // 执行中
            taskService.updateTask(taskDTO1);
            // 2.1.如果查询成功，则执行导出任务
            ResUtils resUtils = null;
            try {
                resUtils = couponService.doExportCoupon();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            // 2.2.如果导出失败，更新任务流水表
            if (2001 != resUtils.getCode()) {
                taskDTO1.setTaskStatus(TaskEnum.FAIL.getStatus());
                taskService.updateTask(taskDTO1);
                return;
            }
            taskDTO1.setTaskStatus(TaskEnum.SUCCESS.getStatus());  // 导出成功
            taskService.updateTask(taskDTO1);
            // 导出成功 更新流水,excel上传到OSS
            String fileName = (String) resUtils.getData();
            resUtils = couponService.uploadExcel(fileName);
            // 上传失败，可在上传一次 或者也是搞个流水
            if (2001 != resUtils.getCode()) {
                resUtils = couponService.uploadExcel(fileName);
                if (2001 != resUtils.getCode()) {
                    return;
                }
            }
            // 上传成功，通知用户，todo 不做这块
        });
    }
}
