package com.fanshoufeng.shiro.repository;

import com.fanshoufeng.shiro.model.UserInfo;
import org.springframework.data.repository.CrudRepository;

public interface UserInfoRepository extends CrudRepository<UserInfo, Long> {

    /**
     * 通过username查找用户信息
     * @param username
     * @return
     */
    UserInfo findByUsername(String username);

}
