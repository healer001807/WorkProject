package com.vv.rocketmq.producer.config;

import com.vv.rocketmq.producer.pojo.MqProducer;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author kw
 * @program WorkProject
 * @description RocketMq 生产者配置类
 * @create 2023 - 10 - 21 21:02
 **/
@Component
@Configuration
@ConfigurationProperties(prefix = "rocketmq.producer")
@Data
public class MqProducerConfig {

    private List<MqProducer> producerList;
}
