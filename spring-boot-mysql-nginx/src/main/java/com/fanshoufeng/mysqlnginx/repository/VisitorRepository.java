package com.fanshoufeng.mysqlnginx.repository;

import com.fanshoufeng.mysqlnginx.entity.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitorRepository extends JpaRepository<Visitor, Long> {

    Visitor findByIp(String ip);

}
