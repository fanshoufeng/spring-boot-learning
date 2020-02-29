package com.fanshoufeng.jpa.config;

import org.hibernate.dialect.MySQL5Dialect;
import org.springframework.stereotype.Component;

@Component
public class MySQL5DialectConfig extends MySQL5Dialect {

    @Override
    public String getTableTypeString() {
        return "engine=InnoDB default charset=utf8";
    }

}
