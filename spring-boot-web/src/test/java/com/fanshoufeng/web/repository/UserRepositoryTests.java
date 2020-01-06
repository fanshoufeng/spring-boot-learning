package com.fanshoufeng.web.repository;

import com.fanshoufeng.web.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DateFormat;
import java.util.Date;

@SpringBootTest
class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String regTime = dateFormat.format(date);

        userRepository.save(new User("aa", "aa123456", "aa@126.com", "aa1", regTime));
        userRepository.save(new User("bb", "bb123456", "bb@126.com", "bb2", regTime));
        userRepository.save(new User("cc", "cc123456", "cc@126.com", "cc3", regTime));
    }

    @Test
    void findByUserName() {
        String userName = "aa";
        User user = userRepository.findByUserName(userName);
        Assertions.assertNull(user);
        Assertions.assertEquals(userName, user.getUserName());
    }

    @Test
    void findByUserNameOrEmail() {
        String userName = "bb";
        String email = "bb@126.com";
        User user = userRepository.findByUserNameOrEmail(userName, email);
        Assertions.assertNull(user);
        Assertions.assertEquals(userName, user.getUserName());
        Assertions.assertEquals(email, user.getEmail());
    }

}