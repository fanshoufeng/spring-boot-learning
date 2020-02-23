package com.fanshoufeng.rabbitmq.rabbit;

import com.fanshoufeng.rabbitmq.rabbit.topic.TopicSender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TopicTest {

    @Autowired
    private TopicSender topicSender;

    @Test
    public void topic() {
        topicSender.send();
    }

    @Test
    public void topic1() {
        topicSender.send1();
    }

    @Test
    public void topic2() {
        topicSender.send2();
    }

}
