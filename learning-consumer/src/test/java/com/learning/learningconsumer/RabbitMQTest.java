package com.learning.learningconsumer;

import com.learning.learningconsumer.component.SimpleSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = LearningConsumerApplication.class)
public class RabbitMQTest {
    @Autowired
    private SimpleSender simpleSender;

    @Test
    public void hello() throws Exception {
        for (int i = 0; i < 10; i++) {
            simpleSender.send();
            Thread.sleep(1000);
        }
    }
}
