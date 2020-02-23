package com.fanshoufeng.rabbitmq.rabbit;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    public Queue hellowQueue() {
        return new Queue("hello");
    }

    @Bean
    public Queue michaelQueue() {
        return new Queue("michael");
    }

    @Bean
    public Queue objectQueue() {
        return new Queue("object");
    }

}
