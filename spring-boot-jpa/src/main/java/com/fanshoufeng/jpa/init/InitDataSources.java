package com.fanshoufeng.jpa.init;

import com.fanshoufeng.jpa.enums.IsActive;
import com.fanshoufeng.jpa.jdbc.datasource.DynamicDataSource;
import com.fanshoufeng.jpa.repository.DataSourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class InitDataSources implements CommandLineRunner {

    @Autowired
    private DataSourceProperties dataSourceProperties;
    @Autowired
    private DataSourceRepository dataSourceRepository;
    @Autowired
    private DynamicDataSource dynamicDataSource;

    @Override
    public void run(String... args) throws Exception {
        List<com.fanshoufeng.jpa.model.DataSource> list = dataSourceRepository.findByIsActiveEquals(IsActive.YES);
        if (list == null || list.size() == 0) {
            return;
        }
        list.forEach(data -> {
            DataSource dataSource = DataSourceBuilder
                    .create()
                    .driverClassName(dataSourceProperties.getDriverClassName())
                    .url(data.getUrl())
                    .username(data.getUsername())
                    .password(data.getPassword())
                    .build();
            dynamicDataSource.add(data.getLookupKey(), dataSource);
        });
    }

}
