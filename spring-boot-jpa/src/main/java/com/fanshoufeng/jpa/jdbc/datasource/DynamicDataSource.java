package com.fanshoufeng.jpa.jdbc.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.Map;

public class DynamicDataSource extends AbstractRoutingDataSource {

    private static final ThreadLocal<String> dynamicDataSourceContextHolder = new ThreadLocal<>();

    public DynamicDataSource(DataSource defaultTargetDataSource, Map<String, DataSource> targetDataSources) {
        super.setDefaultTargetDataSource(defaultTargetDataSource);
        super.setDefaultTargetDataSource(targetDataSources);
        super.afterPropertiesSet();
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return getDataSourceLookupKey();
    }

    public static void setDataSourceLookupKey(String dataSourceLookupKey) {
        dynamicDataSourceContextHolder.set(dataSourceLookupKey);
    }

    private static String getDataSourceLookupKey() {
        return dynamicDataSourceContextHolder.get();
    }

    public static void clearDataSourceLookupKey() {
        dynamicDataSourceContextHolder.remove();
    }

}
