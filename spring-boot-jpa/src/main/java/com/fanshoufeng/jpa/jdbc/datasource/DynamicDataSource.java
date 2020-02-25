package com.fanshoufeng.jpa.jdbc.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

public class DynamicDataSource extends AbstractRoutingDataSource {

    private static final ThreadLocal<String> dynamicDataSourceContextHolder = new ThreadLocal<>();

    private Map<Object, Object> dynamicTargetDataSources;

    @Override
    public void setTargetDataSources(Map<Object, Object> targetDataSources) {
        dynamicTargetDataSources = new HashMap<>();
        dynamicTargetDataSources.putAll(targetDataSources);
        super.setTargetDataSources(targetDataSources);
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

    public void add(String dataSourceKey, DataSource dataSource) {
        dynamicTargetDataSources.put(dataSourceKey, dataSource);
        setDynamicTargetDataSources();
    }

    public void remove(String dataSourceKey) {
        dynamicTargetDataSources.remove(dataSourceKey);
        setDynamicTargetDataSources();
    }

    private void setDynamicTargetDataSources() {
        setTargetDataSources(dynamicTargetDataSources);
    }

}
