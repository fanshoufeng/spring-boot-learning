package com.fanshoufeng.rabbitmq.rabbit;

import com.fanshoufeng.rabbitmq.rabbit.many.MichaelSender;
import com.fanshoufeng.rabbitmq.rabbit.many.MichaelSender2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ManyTest {

    @Autowired
    private MichaelSender michaelSender;
    @Autowired
    private MichaelSender2 michaelSender2;

    @Test
    void oneToMany() {
        for (int i = 0; i < 100; i++) {
            michaelSender.send(i);
        }
    }

    @Test
    void manyToMany() {
        for (int i = 0; i < 100; i++) {
            michaelSender.send(i);
            michaelSender2.send(i);
        }
    }

}
