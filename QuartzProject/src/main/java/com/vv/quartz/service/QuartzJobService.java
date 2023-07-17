package com.vv.quartz.service;

import com.vv.quartz.pojo.QuartzJobDTO;

import java.util.Map;

/**
 * @program: WorkProject
 * @description: quartz 定时任务业务逻辑接口
 * @author: kangwei
 * @create: 2023-07-17 10:52
 **/
public interface QuartzJobService {
    /***
     * @description 添加任务可以传参数
     * @author kangwei
     * @date 2023-7-17
     * @param [clazzName, cronExp, quartzJobDTO]
     @return void
     */
    void addJob(QuartzJobDTO quartzJobDTO);

    /***
     * @description 暂停任务
     * @author kangwei
     * @date 2023-7-17
     * @param [quartzJobDTO]
     @return void
     */
    void pauseJob(QuartzJobDTO quartzJobDTO);

    /***
     * @description 恢复任务
     * @author kangwei
     * @date 2023-7-17
     * @param [quartzJobDTO]
     @return void
     */
    void resumeJob(QuartzJobDTO quartzJobDTO);

    /*** 
     * @description 立即运行一次定时任务
     * @author kangwei
     * @date 2023-7-17
     * @param [quartzJobDTO]
     @return void
     */
    void runOnce(QuartzJobDTO quartzJobDTO);

    /***
     * @description 更新任务
     * @author kangwei
     * @date 2023-7-17
     * @param [quartzJobDTO, cronExp]
     @return void
     */
    void updateJob(QuartzJobDTO quartzJobDTO);

    /***
     * @description 删除任务
     * @author kangwei
     * @date 2023-7-17
     * @param [quartzJobDTO]
     @return void
     */
    void deleteJob(QuartzJobDTO quartzJobDTO);

    /**
     * 启动所有任务
     */
    void startAllJobs();

    /**
     * 暂停所有任务
     */
    void pauseAllJobs();

    /**
     * 恢复所有任务
     */
    void resumeAllJobs();

    /**
     * 关闭所有任务
     */
    void shutdownAllJobs();
}
