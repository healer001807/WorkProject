package com.vv.config;

import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import org.springframework.context.annotation.Bean;

/**
 * @author kw
 * @program WorkProject
 * @description 七牛云配置
 * @create 2023 - 05 - 25 20:35
 **/
@org.springframework.context.annotation.Configuration
public class OSSConfig {


    /***
     * @description 初始化Region对象配置类
     * @param []
     * @return com.qiniu.storage.UploadManager
     * @author
     * @date 2023/5/25
     **/

    @Bean
    public UploadManager uploadManager() {
        Configuration cfg = new Configuration(Region.huanan()); // 华南
        cfg.resumableUploadAPIVersion = Configuration.ResumableUploadAPIVersion.V2;
        UploadManager uploadManager = new UploadManager(cfg);
        return uploadManager;
    }
}
