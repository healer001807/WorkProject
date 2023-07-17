package com.vv.quartz.service;

import com.vv.quartz.pojo.QuartzJobDTO;
import com.vv.util.ResUtils;

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
     @return com.vv.util.ResUtils
     */
    ResUtils addJob(QuartzJobDTO quartzJobDTO);

    /***
     * @description 暂停任务
     * @author kangwei
     * @date 2023-7-17
     * @param [quartzJobDTO]
     @return com.vv.util.ResUtils
     */
    ResUtils pauseJob(QuartzJobDTO quartzJobDTO);

    /***
     * @description 恢复任务
     * @author kangwei
     * @date 2023-7-17
     * @param [quartzJobDTO]
     @return com.vv.util.ResUtils
     */
    ResUtils resumeJob(QuartzJobDTO quartzJobDTO);

    /*** 
     * @description 立即运行一次定时任务
     * @author kangwei
     * @date 2023-7-17
     * @param [quartzJobDTO]
     @return com.vv.util.ResUtils
     */
    ResUtils runOnce(QuartzJobDTO quartzJobDTO);

    /***
     * @description 更新任务
     * @author kangwei
     * @date 2023-7-17
     * @param [quartzJobDTO, cronExp]
     @return com.vv.util.ResUtils
     */
    ResUtils updateJob(QuartzJobDTO quartzJobDTO);

    /***
     * @description 删除任务
     * @author kangwei
     * @date 2023-7-17
     * @param [quartzJobDTO]
     @return com.vv.util.ResUtils
     */
    ResUtils deleteJob(QuartzJobDTO quartzJobDTO);

    /**
     * 启动所有任务
     */
    ResUtils startAllJobs();

    /**
     * 暂停所有任务
     */
    ResUtils pauseAllJobs();

    /**
     * 恢复所有任务
     */
    ResUtils resumeAllJobs();

    /***
     * @description 关闭所有任务
     * @param []
     * @return com.vv.util.ResUtils
     * @author
     * @date 2023/7/17
     **/

    ResUtils shutdownAllJobs();
}
