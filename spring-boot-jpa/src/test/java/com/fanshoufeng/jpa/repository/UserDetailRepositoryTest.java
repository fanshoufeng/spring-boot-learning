package com.fanshoufeng.jpa.repository;

import com.fanshoufeng.jpa.jdbc.datasource.DynamicDataSource;
import com.fanshoufeng.jpa.model.Address;
import com.fanshoufeng.jpa.model.UserDetail;
import com.fanshoufeng.jpa.model.UserInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class UserDetailRepositoryTest {

    @Resource
    private AddressRepository addressRepository;
    @Resource
    private UserDetailRepository userDetailRepository;

    @BeforeEach
    void setUp() {
        DynamicDataSource.setDataSourceLookupKey("LOOKUP_KEY_02");
    }

    @Test
    void saveAddress() {
        Address address = new Address();
        address.setUserId(1L);
        address.setCity("北京");
        address.setProvince("北京");
        address.setStreet("分钟寺");
        addressRepository.save(address);
    }

    @Test
    void saveUserDetail() {
        UserDetail userDetail = new UserDetail();
        userDetail.setUserId(3L);
        userDetail.setHobby("吃鸡游戏");
        userDetail.setAge(28);
        userDetail.setIntroduction("一个爱玩的人");
        userDetailRepository.save(userDetail);
    }

    @Test
    void userInfo() {
        List<UserInfo> userInfos = userDetailRepository.findUserInfo("钓鱼");
        userInfos.forEach(userInfo -> {
            System.out.println("userInfo: " + userInfo.getName() + "-" + userInfo.getEmail() + "-" + userInfo.getHobby() + "-" + userInfo.getIntroduction());
        });
    }

}