package com.learning.learningconsumer.component;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveHandler {
    //监听emial队列
    @RabbitListener(queues = {SimpleRabbitConfig.QUEUE_INFORM_EMAIL})
    public void receiveEmail(String msg, Message message, Channel channel) {
        System.out.println("+++" + msg);
        System.out.println("====" + message);
    }

    //监听sms队列
    @RabbitListener(queues = {SimpleRabbitConfig.QUEUE_INFORM_SMS})
    public void receiveSms(String msg, Message message, Channel channel) {
        System.out.println(msg);
    }
}
