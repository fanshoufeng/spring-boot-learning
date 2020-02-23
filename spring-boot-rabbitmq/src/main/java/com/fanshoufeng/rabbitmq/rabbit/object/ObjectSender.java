package com.fanshoufeng.rabbitmq.rabbit.object;

import com.fanshoufeng.rabbitmq.model.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ObjectSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(User user) {
        System.out.println("Sender object: " + user.toString());
        this.amqpTemplate.convertAndSend("object", user);
    }

}
