package com.fanshoufeng.jpa.service;

import com.fanshoufeng.jpa.model.UserDetail;
import com.fanshoufeng.jpa.param.UserDetailParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserDetailService {

    Page<UserDetail> findByCondition(UserDetailParam detailParam, Pageable pageable);

}
