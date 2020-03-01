package com.fanshoufeng.shiro.service.impl;

import com.fanshoufeng.shiro.model.UserInfo;
import com.fanshoufeng.shiro.repository.UserInfoRepository;
import com.fanshoufeng.shiro.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoRepository userInfoRepository;

    @Override
    public UserInfo findByUsername(String username) {
        System.out.println("UserInfoServiceImpl.findByUsername()");
        return userInfoRepository.findByUsername(username);
    }

}
