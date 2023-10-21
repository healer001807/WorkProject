package com.vv.rocketmq.producer.controller;

import com.vv.rocketmq.producer.rocketMq.MqUtils;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kw
 * @program WorkProject
 * @description 测试发送
 * @create 2023 - 10 - 21 21:26
 **/

@RestController
@RequestMapping("producer")
public class MqProducerController {

    @GetMapping
    public SendResult sendResult() throws MQBrokerException, RemotingException, InterruptedException, MQClientException {
        String str = "模拟发送积分";
        Message message = new Message("point-topic", str.getBytes());
        DefaultMQProducer points = MqUtils.getDefaultMQProducer("points");
        SendResult sendResult = points.send(message);
        return sendResult;
    }
}
