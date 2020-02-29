package com.fanshoufeng.jpa.repository;

import com.fanshoufeng.jpa.jdbc.datasource.DynamicDataSource;
import com.fanshoufeng.jpa.model.UserDetail;
import com.fanshoufeng.jpa.param.UserDetailParam;
import com.fanshoufeng.jpa.service.UserDetailService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.annotation.Resource;

@SpringBootTest
class JpaSpecificationTest {

    @Resource
    private UserDetailService userDetailService;

    @BeforeEach
    void setUp() {
        DynamicDataSource.setDataSourceLookupKey("LOOKUP_KEY_02");
    }

    @Test
    void findByCondition() {
        int page = 0, size = 10;
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(page, size, sort);
        UserDetailParam param = new UserDetailParam();
        param.setIntroduction("程序员");
        param.setMinAge(10);
        param.setMaxAge(30);
        Page<UserDetail> page1 = userDetailService.findByCondition(param, pageable);
        page1.forEach(userDetail -> {
            System.out.println("userDetail: " + userDetail.toString());
        });
    }

}
