package com.vv.admin.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author kw
 * @program WorkProject
 * @description 线程池配置参数类
 * @create 2023 - 06 - 03 23:33
 **/
@Data
@Configuration
@ConfigurationProperties(prefix = "pool")
public class ThreadPoolProperties {

    private int corePoolSize; // 核心线程数
    private int maxPoolSize; // 最大线程数
    private long keepAliveTime; // 活跃时间
    private int blockingDeque; // 允许等待最大数
}
