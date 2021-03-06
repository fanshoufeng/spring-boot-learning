package com.fanshoufeng.shiro.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class UserInfo extends BaseEntity implements Serializable {

    /**
     * 帐号
     */
    @Column(unique = true)
    @Getter
    @Setter
    private String username;

    /**\
     * 名称（昵称或者真实姓名，不同系统不同定义）
     */
    @Getter
    @Setter
    private String name;

    /**
     * 密码
     */
    @Getter
    @Setter
    private String password;

    /**
     * 加密密码的盐
     */
    @Getter
    @Setter
    private String salt;

    /**
     * 用户状态，0:创建未认证（比如没有激活，没有输入验证码等等）--等待验证的用户，1:正常状态，2:用户被锁定
     */
    @Getter
    @Setter
    private byte state;

    /**
     * 一个用户具有多个角色
     * fetch = FetchType.EAGER:立即从数据库中进行加载数据
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "SysUserRole", joinColumns = {@JoinColumn(name = "userId")}, inverseJoinColumns = {@JoinColumn(name = "roleId")})
    @Getter
    @Setter
    private List<SysRole> roleList;

    /**
     * 密码盐，重新对盐进行了定义，用户名+salt，这样就更加不容易被破解
     * @return
     */
    public String getCredentialsSalt() {
        return this.username + this.salt;
    }

}
