package com.fanshoufeng.mybatis.model;

import com.fanshoufeng.mybatis.enums.UserSex;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class User implements Serializable {

    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    private String username;
    @Getter
    @Setter
    private String password;
    @Getter
    @Setter
    private UserSex userSex;
    @Getter
    @Setter
    private String nickName;

    public User() {
        super();
    }

    public User(String username, String password, UserSex userSex) {
        super();
        this.username = username;
        this.password = password;
        this.userSex = userSex;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userSex=" + userSex +
                '}';
    }
}
