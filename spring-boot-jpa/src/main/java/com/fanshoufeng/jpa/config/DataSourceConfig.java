package com.fanshoufeng.jpa.config;

import com.fanshoufeng.jpa.enums.IsActive;
import com.fanshoufeng.jpa.jdbc.datasource.DynamicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class DataSourceConfig {

    @Autowired
    private DataSourceProperties dataSourceProperties;

    @Bean(name = "dynamicDataSource")
    @Primary
    public DataSource dynamicDataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        DataSource primaryDataSource = DataSourceBuilder
                .create()
                .driverClassName(dataSourceProperties.getDriverClassName())
                .url(dataSourceProperties.getUrl())
                .username(dataSourceProperties.getUsername())
                .password(dataSourceProperties.getPassword())
                .build();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(primaryDataSource);
        StringBuilder sql = new StringBuilder()
                .append("select ")
                .append(" * ")
                .append("from DataSource ")
                .append("where is_active = ? ");
        List<com.fanshoufeng.jpa.model.DataSource> list = jdbcTemplate.query(sql.toString(), new Object[]{IsActive.YES.name()}, new RowMapper<com.fanshoufeng.jpa.model.DataSource>() {
            @Override
            public com.fanshoufeng.jpa.model.DataSource mapRow(ResultSet resultSet, int i) throws SQLException {
                return null;
            }
        });
        dynamicDataSource.setDefaultTargetDataSource(primaryDataSource);
        Map<Object, Object> targetDataSources = new HashMap<>();
        if (list != null && list.size() > 0) {
            list.forEach(map -> {
                DataSource dataSource = DataSourceBuilder
                        .create()
                        .driverClassName(dataSourceProperties.getDriverClassName())
                        .url(dataSourceProperties.getUrl())
                        .username(dataSourceProperties.getUsername())
                        .password(dataSourceProperties.getPassword())
                        .build();
                targetDataSources.put("primaryDataSource", dataSource);
            });
        }
        dynamicDataSource.setTargetDataSources(targetDataSources);
        return dynamicDataSource;
    }

}
