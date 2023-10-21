package com.vv.rocketmq.producer.pojo;

import lombok.Data;

/**
 * @author kw
 * @program WorkProject
 * @description RocketMq 生产配置文件实体
 * @create 2023 - 10 - 21 21:04
 **/
@Data
public class MqProducer {
    /**
     * 组
     */
    private String groupName;
    /**
     * 话题
     */
    private String topicName;
    /**
     * 生产者唯一标识
     */
    private String producerId;
    /**
     * 连接的地址
     */
    private String namesrvAddr;
    /**
     * 消息最大长度 默认 1024*4
     */
    private Integer maxMessageSize;
    /**
     * 发送超市时间 默认3000
     */
    private Integer sendMsgTimeOut;
    /**
     * 重试次数 默认 2
     */
    private Integer retryTimesWhenSendFailed;
}
