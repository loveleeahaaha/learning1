package com.learning.learningconsumer.component;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * consumer
 */
@Component
@RabbitListener(queues = {"helloMQ"})
public class HelloReceiver {
    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver:" + hello);
    }
}
