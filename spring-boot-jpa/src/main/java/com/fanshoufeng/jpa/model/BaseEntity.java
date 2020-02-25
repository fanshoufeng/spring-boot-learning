package com.fanshoufeng.jpa.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class BaseEntity implements Serializable {

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
