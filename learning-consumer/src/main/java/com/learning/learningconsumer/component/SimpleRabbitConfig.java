package com.learning.learningconsumer.component;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.impl.AMQImpl;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SimpleRabbitConfig {
    @Bean
    public Queue queue () {
        return new Queue("helloMQ");
    }
}
