package com.fanshoufeng.jpa.model;

import com.fanshoufeng.jpa.enums.IsActive;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Index;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 用jpa自动生成表，只用@Entity、@Table这两个注解生成的表：引擎是MyISAM、字段长度全是默认最大、字段没注释、没有添加索引
 * 设置InnoDB引擎：spring.jpa.database-platform=org.hibernate.dialect.MySQL5InnoDBDialect
 * ddl-auto可以是create（每次新建），update（修改），none（不操作）：spring.jpa.properties.hibernate.hbm2ddl.auto=create
 */
@Entity
/**
 * 生成表注解，并制定唯一索引（索引名、字段、类型）
 */
@Table(
        name = "datasource",
        indexes = {
                @Index(
                        name = "datasource_index",
                        columnList = "id",
                        unique = true
                )
        }
)
/**
 * 添加表名注释
 */
@org.hibernate.annotations.Table(appliesTo = "datasource", comment = "数据源")
public class DataSource extends BaseEntity implements Serializable {

    @Column(name = "lookup_key", columnDefinition = "char(36) default '' comment '数据源的lookupKey'")
    @Getter
    @Setter
    private String lookupKey;

    @Column(columnDefinition = "char(255) comment '数据源的url'")
    @Getter
    @Setter
    private String url;

    @Column(columnDefinition = "char(100) comment '数据源的用户名'")
    @Getter
    @Setter
    private String username;

    @Getter
    @Setter
    @Column(columnDefinition = "char(36) comment '数据源的密码'")
    private String password;

    @Getter
    @Setter
    @Column(columnDefinition = "char(3) comment '数据源的是否有效：YES，NO'")
    @Enumerated(EnumType.STRING)
    private IsActive isActive;

}
