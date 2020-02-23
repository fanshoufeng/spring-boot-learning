package com.fanshoufeng.mybatis.mapper;

import com.fanshoufeng.mybatis.enums.UserSex;
import com.fanshoufeng.mybatis.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void insert() {
        userMapper.insert(new User("aa1", "a123456", UserSex.MALE));
        userMapper.insert(new User("bb1", "b123456", UserSex.FEMALE));
        userMapper.insert(new User("cc1", "c123456", UserSex.FEMALE));

        Assertions.assertEquals(3, userMapper.getAll().size());
    }

    @Test
    void query() {
        List<User> userList = userMapper.getAll();
        System.out.println(userList.toString());
    }

    @Test
    void update() {
        Long id = 30L;
        User user = userMapper.getOne(id);
        System.out.println(user.toString());
        user.setNickName("Michael");
        userMapper.update(user);
        Assertions.assertTrue(("Michael".equals(userMapper.getOne(id).getNickName())));
    }
}