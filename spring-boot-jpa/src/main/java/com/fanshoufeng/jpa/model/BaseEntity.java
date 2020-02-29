package com.fanshoufeng.jpa.model;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @CreatedDate
    @Column(columnDefinition = "datetime comment '创建时间'")
    @Getter
    @Setter
    private Date createTime;

    @LastModifiedDate
    @Column(columnDefinition = "datetime comment '修改时间'")
    @Getter
    @Setter
    private Date modifyTime;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
