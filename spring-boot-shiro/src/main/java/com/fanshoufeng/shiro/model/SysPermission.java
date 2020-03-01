package com.fanshoufeng.shiro.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class SysPermission extends BaseEntity implements Serializable {

    /**
     * 名称
     */
    @Getter
    @Setter
    private String name;

    /**
     * 资源类型，[menu/button]
     */
    @Column(columnDefinition = "enum('menu','button')")
    @Getter
    @Setter
    private String resourceType;

    /**
     * 资源路径
     */
    @Getter
    @Setter
    private String url;

    /**
     * 权限字符串，menu例子：role:*，button例子：role:create,role:update,role:delete,role:view
     */
    @Getter
    @Setter
    private String permission;

    /**
     * 父编号
     */
    @Getter
    @Setter
    private Long parentId;

    /**
     * 父编号列表
     */
    @Getter
    @Setter
    private String parentIds;

    @Getter
    @Setter
    private Boolean available = Boolean.FALSE;

    @Getter
    @Setter
    @ManyToMany
    @JoinTable(name = "SysRolePermission", joinColumns = {@JoinColumn(name = "permissionId")}, inverseJoinColumns = {@JoinColumn(name = "roleId")})
    private List<SysRole> roles;

}
