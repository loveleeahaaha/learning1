package com.learning.learningconsumer.component;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
/**
 * 消息发送者（生产者）
 */
@Component
public class SimpleSender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send() {
        String context = "helloMQ" + new Date().getTime();
        amqpTemplate.convertAndSend("helloMQ", context);
    }
}
