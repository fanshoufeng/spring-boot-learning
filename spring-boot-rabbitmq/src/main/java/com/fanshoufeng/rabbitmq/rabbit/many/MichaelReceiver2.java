package com.fanshoufeng.rabbitmq.rabbit.many;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "michael")
public class MichaelReceiver2 {

    @RabbitHandler
    public void process(String michael) {
        System.out.println("Receiver 2 : " + michael);
    }

}
