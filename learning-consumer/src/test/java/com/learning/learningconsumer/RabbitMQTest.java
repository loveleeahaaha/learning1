package com.learning.learningconsumer;

import com.learning.learningconsumer.component.SimpleRabbitConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RabbitMQTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testSendEmail() {
        String message = "send email to user";
        rabbitTemplate.convertAndSend(SimpleRabbitConfig.EXCHANGE_TOPICS_INFORM, "inform.email", message);
    }
}
