package com.vv.quartz.controller;

import com.vv.quartz.pojo.QuartzJobDTO;
import com.vv.quartz.service.QuartzJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: WorkProject
 * @description: quartz 定时任务api接口
 * @author: kangwei
 * @create: 2023-07-17 14:19
 **/
@RestController
@RequestMapping("quartzJob")
public class QuartzJobController {


    @Autowired
    private QuartzJobService quartzJobService;

    /**
     * 添加新任务
     *
     * @param quartzJobDTO
     * @return
     */
    @RequestMapping("/addJob")
    public Object addJob(@RequestBody QuartzJobDTO quartzJobDTO) {
        quartzJobService.addJob(quartzJobDTO);
        return HttpStatus.OK;
    }

    /**
     * 暂停任务
     *
     * @param quartzJobDTO
     * @return
     */
    @RequestMapping("/pauseJob")
    public Object pauseJob(@RequestBody QuartzJobDTO quartzJobDTO) {
        quartzJobService.pauseJob(quartzJobDTO);
        return HttpStatus.OK;
    }

    /**
     * 恢复任务
     *
     * @param quartzJobDTO
     * @return
     */
    @RequestMapping("/resumeJob")
    public Object resumeJob(@RequestBody QuartzJobDTO quartzJobDTO) {
        quartzJobService.resumeJob(quartzJobDTO);
        return HttpStatus.OK;
    }

    /**
     * 立即运行一次定时任务
     *
     * @param quartzJobDTO
     * @return
     */
    @RequestMapping("/runOnce")
    public Object runOnce(@RequestBody QuartzJobDTO quartzJobDTO) {
        quartzJobService.runOnce(quartzJobDTO);
        return HttpStatus.OK;
    }

    /**
     * 更新任务
     *
     * @param quartzJobDTO
     * @return
     */
    @RequestMapping("/updateJob")
    public Object updateJob(@RequestBody QuartzJobDTO quartzJobDTO) {
        quartzJobService.updateJob(quartzJobDTO);
        return HttpStatus.OK;
    }

    /**
     * 删除任务
     *
     * @param quartzJobDTO
     * @return
     */
    @RequestMapping("/deleteJob")
    public Object deleteJob(@RequestBody QuartzJobDTO quartzJobDTO) {
        quartzJobService.deleteJob(quartzJobDTO);
        return HttpStatus.OK;
    }

    /**
     * 启动所有任务
     *
     * @return
     */
    @RequestMapping("/startAllJobs")
    public Object startAllJobs() {
        quartzJobService.startAllJobs();
        return HttpStatus.OK;
    }

    /**
     * 暂停所有任务
     *
     * @return
     */
    @RequestMapping("/pauseAllJobs")
    public Object pauseAllJobs() {
        quartzJobService.pauseAllJobs();
        return HttpStatus.OK;
    }

    /**
     * 恢复所有任务
     *
     * @return
     */
    @RequestMapping("/resumeAllJobs")
    public Object resumeAllJobs() {
        quartzJobService.resumeAllJobs();
        return HttpStatus.OK;
    }

    /**
     * 关闭所有任务
     *
     * @return
     */
    @RequestMapping("/shutdownAllJobs")
    public Object shutdownAllJobs() {
        quartzJobService.shutdownAllJobs();
        return HttpStatus.OK;
    }
}
