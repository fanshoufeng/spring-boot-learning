package com.fanshoufeng.jpa.service.impl;

import com.fanshoufeng.jpa.model.UserDetail;
import com.fanshoufeng.jpa.param.UserDetailParam;
import com.fanshoufeng.jpa.repository.UserDetailRepository;
import com.fanshoufeng.jpa.service.UserDetailService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailService {

    @Resource
    private UserDetailRepository userDetailRepository;

    @Override
    public Page<UserDetail> findByCondition(UserDetailParam detailParam, Pageable pageable) {
        return userDetailRepository.findAll((root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            //equal 示例
            String introduction = detailParam.getIntroduction();
            if (!StringUtils.isEmpty(introduction)) {
                predicates.add(cb.equal(root.get("introduction"), introduction));
            }
            //like 示例
            String realName = detailParam.getRealName();
            if (!StringUtils.isEmpty(realName)) {
                predicates.add(cb.like(root.get("realName"), "%" + realName + "%"));
            }
            //greaterThan 大于等于示例
            if (detailParam.getMinAge() != null) {
                predicates.add(cb.greaterThan(root.get("age"), detailParam.getMinAge()));
            }
            return query.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
        }, pageable);
    }

}
