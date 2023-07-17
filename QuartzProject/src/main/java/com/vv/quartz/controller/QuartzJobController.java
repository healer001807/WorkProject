package com.vv.quartz.controller;

import com.vv.quartz.pojo.QuartzJobDTO;
import com.vv.quartz.service.QuartzJobService;
import com.vv.util.ResUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResUtils addJob(@RequestBody QuartzJobDTO quartzJobDTO) {
        return quartzJobService.addJob(quartzJobDTO);
    }

    /**
     * 暂停任务
     *
     * @param quartzJobDTO
     * @return
     */
    @RequestMapping("/pauseJob")
    public ResUtils pauseJob(@RequestBody QuartzJobDTO quartzJobDTO) {

        return quartzJobService.pauseJob(quartzJobDTO);
    }

    /**
     * 恢复任务
     *
     * @param quartzJobDTO
     * @return
     */
    @RequestMapping("/resumeJob")
    public ResUtils resumeJob(@RequestBody QuartzJobDTO quartzJobDTO) {

        return quartzJobService.resumeJob(quartzJobDTO);
    }

    /**
     * 立即运行一次定时任务
     *
     * @param quartzJobDTO
     * @return
     */
    @RequestMapping("/runOnce")
    public ResUtils runOnce(@RequestBody QuartzJobDTO quartzJobDTO) {

        return quartzJobService.runOnce(quartzJobDTO);
    }

    /**
     * 更新任务
     *
     * @param quartzJobDTO
     * @return
     */
    @RequestMapping("/updateJob")
    public ResUtils updateJob(@RequestBody QuartzJobDTO quartzJobDTO) {

        return quartzJobService.updateJob(quartzJobDTO);
    }

    /**
     * 删除任务
     *
     * @param quartzJobDTO
     * @return
     */
    @RequestMapping("/deleteJob")
    public ResUtils deleteJob(@RequestBody QuartzJobDTO quartzJobDTO) {

        return quartzJobService.deleteJob(quartzJobDTO);
    }

    /**
     * 启动所有任务
     *
     * @return
     */
    @RequestMapping("/startAllJobs")
    public ResUtils startAllJobs() {

        return quartzJobService.startAllJobs();
    }

    /**
     * 暂停所有任务
     *
     * @return
     */
    @RequestMapping("/pauseAllJobs")
    public ResUtils pauseAllJobs() {

        return quartzJobService.pauseAllJobs();
    }

    /**
     * 恢复所有任务
     *
     * @return
     */
    @RequestMapping("/resumeAllJobs")
    public ResUtils resumeAllJobs() {

        return quartzJobService.resumeAllJobs();
    }

    /**
     * 关闭所有任务
     *
     * @return
     */
    @RequestMapping("/shutdownAllJobs")
    public ResUtils shutdownAllJobs() {

        return quartzJobService.shutdownAllJobs();
    }
}
