package com.vv.rocketmq.producer.rocketMq;

import cn.hutool.core.collection.CollectionUtil;
import com.vv.rocketmq.producer.config.MqProducerConfig;
import com.vv.rocketmq.producer.pojo.MqProducer;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author kw
 * @program WorkProject
 * @description RocketMq 初始化生产者
 * @create 2023 - 10 - 21 21:06
 **/

@Slf4j
@Component
public class MqProducerInit implements ApplicationListener<ApplicationReadyEvent> {

    @Resource
    private MqProducerConfig mqProducerConfig;

    static Map<String, DefaultMQProducer> defaultMQProducerMap = new HashMap<>();

    /**
     * ApplicationReadyEvent
     * @param event
     */
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        List<MqProducer> producers = mqProducerConfig.getProducerList();
        if (CollectionUtil.isEmpty(producers)) {
            log.info("rocket mq is empty");
            return;
        }
        for (MqProducer producer : producers) {
            DefaultMQProducer defaultMQProducer = new DefaultMQProducer();
            defaultMQProducer.setProducerGroup(producer.getGroupName());
            defaultMQProducer.setNamesrvAddr(producer.getNamesrvAddr());
            defaultMQProducer.setVipChannelEnabled(false);
            defaultMQProducer.setSendMsgTimeout(producer.getSendMsgTimeOut());
            defaultMQProducer.setMaxMessageSize(producer.getMaxMessageSize());
            defaultMQProducer.setRetryTimesWhenSendAsyncFailed(producer.getRetryTimesWhenSendFailed());
            try {
                defaultMQProducer.start();
                defaultMQProducerMap.put(producer.getProducerId(), defaultMQProducer);
                log.info("rocket mq start success[namesrvAddr]" + defaultMQProducer.getNamesrvAddr() + "[groupName]" + defaultMQProducer.getProducerGroup());
            } catch (MQClientException e) {
                log.error("rocket mq start error[namesrvAddr]" + defaultMQProducer.getNamesrvAddr() + "[groupName]" + defaultMQProducer.getProducerGroup(), e);
                throw new RuntimeException(e);
            }
        }
    }
}
