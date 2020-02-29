package com.fanshoufeng.jpa.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "userdetail")
@org.hibernate.annotations.Table(appliesTo = "userdetail", comment = "用户明细")
public class UserDetail extends BaseEntity implements Serializable {

    @Column(nullable = false, unique = true, columnDefinition = "bigint comment '用户Id'")
    @Getter
    @Setter
    private Long userId;

    @Column(columnDefinition = "integer comment '年龄'")
    @Getter
    @Setter
    private Integer age;

    @Column(columnDefinition = "char(255) comment '姓名'")
    @Getter
    @Setter
    private String realName;

    @Column(columnDefinition = "char(255) comment '状态'")
    @Getter
    @Setter
    private String status;

    @Column(columnDefinition = "char(255) comment '爱好'")
    @Getter
    @Setter
    private String hobby;

    @Column(columnDefinition = "char(255) comment '介绍'")
    @Getter
    @Setter
    private String introduction;

    @Column(columnDefinition = "char(255) comment '最近登录Ip'")
    @Getter
    @Setter
    private String lastLoginIp;

}
