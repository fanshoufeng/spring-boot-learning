package com.fanshoufeng.rabbitmq.rabbit.many;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MichaelSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(int i) {
        String context = "spring boot michael queue ****** " + i;
        System.out.println("Sender 1 : " + context);
        this.amqpTemplate.convertAndSend("michael", context);
    }

}
