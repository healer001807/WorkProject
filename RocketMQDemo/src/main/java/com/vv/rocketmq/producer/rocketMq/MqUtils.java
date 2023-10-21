package com.vv.rocketmq.producer.rocketMq;

import cn.hutool.core.util.StrUtil;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.vv.rocketmq.producer.rocketMq.MqProducerInit.defaultMQProducerMap;

/**
 * @author kw
 * @program WorkProject
 * @description
 * @create 2023 - 10 - 21 21:19
 **/
public class MqUtils {

    private static Logger logger = LoggerFactory.getLogger(MqUtils.class);

    /**
     * 根据生产者标识获取生产者
     *
     * @param producerId
     * @return
     */
    public static DefaultMQProducer getDefaultMQProducer(String producerId) {
        DefaultMQProducer defaultMQProducer = defaultMQProducerMap.get(producerId);
        if (StrUtil.isBlank(producerId) || null == defaultMQProducer) {
            logger.info("get rocket mq error", producerId);
            return null;
        }
        return defaultMQProducer;
    }
}
