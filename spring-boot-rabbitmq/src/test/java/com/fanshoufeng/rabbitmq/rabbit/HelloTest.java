package com.fanshoufeng.rabbitmq.rabbit;

import com.fanshoufeng.rabbitmq.rabbit.hello.HelloSender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HelloTest {

    @Autowired
    private HelloSender helloSender;

    @Test
    void hello() {
        helloSender.send();
    }

}
