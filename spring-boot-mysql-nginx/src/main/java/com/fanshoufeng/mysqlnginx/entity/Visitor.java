package com.fanshoufeng.mysqlnginx.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class Visitor {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Getter
    @Setter
    @Column(nullable = false)
    private long times;
    @Getter
    @Setter
    @Column(nullable = false)
    private String ip;

}
