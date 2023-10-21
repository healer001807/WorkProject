package com.vv.rocketmq.producer.rocketMq;

import cn.hutool.core.collection.CollectionUtil;
import com.vv.rocketmq.producer.config.MqProducerConfig;
import com.vv.rocketmq.producer.pojo.MqProducer;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author kw
 * @program WorkProject
 * @description RocketMq 初始化生产者
 * @create 2023 - 10 - 21 21:06
 **/

@Slf4j
@Component
@Order(9)
public class MqProducerInit implements ApplicationListener<ApplicationEvent> {

    @Resource
    private MqProducerConfig mqProducerConfig;

    static Map<String, DefaultMQProducer> defaultMQProducerMap = new ConcurrentHashMap<>();

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        List<MqProducer> producers = mqProducerConfig.getProducerList();
        if (CollectionUtil.isEmpty(producers)) {
            log.info("rocket mq is empty");
            return;
        }
        for (MqProducer producer : producers) {
            DefaultMQProducer defaultMQProducer = new DefaultMQProducer(producer.getGroupName());
            defaultMQProducer.setInstanceName(producer.getProducerId());
            defaultMQProducer.setNamesrvAddr(producer.getNamesrvAddr());
            defaultMQProducer.setVipChannelEnabled(false);
            defaultMQProducer.setSendMsgTimeout(producer.getSendMsgTimeOut());
            defaultMQProducer.setMaxMessageSize(producer.getMaxMessageSize());
            defaultMQProducer.setRetryTimesWhenSendAsyncFailed(producer.getRetryTimesWhenSendFailed());
            try {
                defaultMQProducer.start();
                log.info("rocket mq start success[namesrvAddr]" + defaultMQProducer.getNamesrvAddr() + "[groupName]" + defaultMQProducer.getProducerGroup());
            } catch (MQClientException e) {
                log.error("rocket mq start error[namesrvAddr]" + defaultMQProducer.getNamesrvAddr() + "[groupName]" + defaultMQProducer.getProducerGroup(), e);
                throw new RuntimeException(e);
            }
            defaultMQProducerMap.put(producer.getProducerId(), defaultMQProducer);
        }
    }
}
