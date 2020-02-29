package com.fanshoufeng.jpa.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;

@Entity
@org.hibernate.annotations.Table(appliesTo = "user", comment = "用户")
public class User extends BaseEntity implements Serializable {

    @Column(columnDefinition = "char(36) comment '用户名'")
    @Getter
    @Setter
    private String name;

    @Column(columnDefinition = "char(36) comment '密码'")
    @Getter
    @Setter
    private String password;

    @Column(columnDefinition = "char(255) comment '邮箱'")
    @Getter
    @Setter
    private String email;

    @Column(columnDefinition = "char(255) comment '昵称'")
    @Getter
    @Setter
    private String nickName;

    @CreatedDate
    @Column(columnDefinition = "datetime comment '注册时间'")
    @Getter
    @Setter
    private Date regTime;

    public User() {
        super();
    }

    public User(String name, String password, String email, String nickName, Date regTime) {
        super();
        this.name = name;
        this.password = password;
        this.email = email;
        this.nickName = nickName;
        this.regTime = regTime;
    }

}
