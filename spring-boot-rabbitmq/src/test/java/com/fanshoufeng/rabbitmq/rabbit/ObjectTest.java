package com.fanshoufeng.rabbitmq.rabbit;

import com.fanshoufeng.rabbitmq.model.User;
import com.fanshoufeng.rabbitmq.rabbit.object.ObjectSender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ObjectTest {

    @Autowired
    private ObjectSender objectSender;

    @Test
    void sendObject() {
        User user = new User();
        user.setName("Michael");
        user.setPass("123456");
        objectSender.send(user);
    }

}
