package com.fanshoufeng.rabbitmq.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class User implements Serializable {

    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String pass;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
