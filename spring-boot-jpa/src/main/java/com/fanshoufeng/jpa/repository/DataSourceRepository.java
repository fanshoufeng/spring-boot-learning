package com.fanshoufeng.jpa.repository;

import com.fanshoufeng.jpa.enums.IsActive;
import com.fanshoufeng.jpa.model.DataSource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DataSourceRepository extends JpaRepository<DataSource, Long> {

    List<DataSource> findByIsActiveEquals(IsActive isActive);

}
