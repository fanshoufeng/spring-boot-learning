package com.fanshoufeng.shiro.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class SysRole extends BaseEntity implements Serializable {

    /**
     * 角色标识程序中判断使用，如“admin”，这个是唯一的；
     */
    @Getter
    @Setter
    private String role;

    /**
     * 角色描述，UI界面显示使用
     */
    @Getter
    @Setter
    private String description;

    /**
     * 是否可用，如果不可用将不会添加给用户
     */
    @Getter
    @Setter
    private Boolean available = Boolean.FALSE;

    /**
     * 角色--权限关系：多对多关系；
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "SysRolePermission", joinColumns = {@JoinColumn(name = "roleId")}, inverseJoinColumns = {@JoinColumn(name = "permissionId")})
    @Getter
    @Setter
    private List<SysPermission> permissions;

    /**
     * 用户-角色关系定义；
     */
    @ManyToMany
    @JoinTable(name = "SysUserRole", joinColumns = {@JoinColumn(name = "roleId")}, inverseJoinColumns = {@JoinColumn(name = "userId")})
    @Getter
    @Setter
    private List<UserInfo> userInfos;

}
