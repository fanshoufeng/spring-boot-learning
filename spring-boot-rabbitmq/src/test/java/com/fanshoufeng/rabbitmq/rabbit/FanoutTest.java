package com.fanshoufeng.rabbitmq.rabbit;

import com.fanshoufeng.rabbitmq.rabbit.fanout.FanoutSender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FanoutTest {

    @Autowired
    private FanoutSender fanoutSender;

    @Test
    void send() {
        fanoutSender.send();
    }

}
