package com.fanshoufeng.shiro.service;

import com.fanshoufeng.shiro.model.UserInfo;

public interface UserInfoService {

    /**
     * 通过username查找用户信息
     * @param username
     * @return
     */
    UserInfo findByUsername(String username);

}
