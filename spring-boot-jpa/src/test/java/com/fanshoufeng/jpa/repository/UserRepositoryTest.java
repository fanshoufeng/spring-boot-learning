package com.fanshoufeng.jpa.repository;

import com.fanshoufeng.jpa.jdbc.datasource.DynamicDataSource;
import com.fanshoufeng.jpa.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;

@SpringBootTest
class UserRepositoryTest {

    @BeforeEach
    void setUp() {
        DynamicDataSource.setDataSourceLookupKey("LOOKUP_KEY_02");
    }

    @Resource
    private UserRepository userRepository;

    @Test
    void save() {
        Date date = new Date();
        userRepository.save(new User("aa", "aa123456", "aa@163.com", "aa", date));
        userRepository.save(new User("bb", "bb123456", "bb@163.com", "bb", date));
        userRepository.save(new User("cc", "cc123456", "cc@163.com", "cc", date));
    }

    @Test
    void baseQuery() {
        Date date = new Date();
        User user = new User("ff", "ff123456", "ff@126.com", "ff", date);
        userRepository.findAll();
        userRepository.findById(3L);
        userRepository.save(user);
        user.setId(2L);
        userRepository.delete(user);
        userRepository.count();
        userRepository.existsById(3L);
    }

    @Test
    void customSql() {
        userRepository.modifyNameById("Michael", 3L);
        userRepository.deleteById(3L);
        userRepository.findByEmail("ff@126.com");
    }

}