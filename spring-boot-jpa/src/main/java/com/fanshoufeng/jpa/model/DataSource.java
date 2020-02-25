package com.fanshoufeng.jpa.model;

import com.fanshoufeng.jpa.enums.IsActive;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class DataSource extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;
    @Column(nullable = false, columnDefinition = "nvarchar(255)")
    @Getter
    @Setter
    private String url;
    @Column(nullable = false, columnDefinition = "nvarchar(255)")
    @Getter
    @Setter
    private String username;
    @Getter
    @Setter
    @Column(nullable = false, columnDefinition = "nvarchar(255)")
    private String password;
    @Getter
    @Setter
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private IsActive isActive;
    @Getter
    @Setter
    @Column(nullable = false)
    private Long createTime;
    @Getter
    @Setter
    @Column(nullable = false)
    private Long modifyTime;

}
