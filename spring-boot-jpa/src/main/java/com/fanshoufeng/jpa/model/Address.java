package com.fanshoufeng.jpa.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@org.hibernate.annotations.Table(appliesTo = "address", comment = "地址")
public class Address extends BaseEntity implements Serializable {

    @Column(nullable = false, columnDefinition = "bigint comment '用户Id'")
    @Getter
    @Setter
    private Long userId;

    @Column(columnDefinition = "char(255) comment '省'")
    @Getter
    @Setter
    private String province;

    @Column(columnDefinition = "char(255) comment '城市'")
    @Getter
    @Setter
    private String city;

    @Column(columnDefinition = "char(255) comment '街道'")
    @Getter
    @Setter
    private String street;

}
