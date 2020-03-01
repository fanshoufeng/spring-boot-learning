drop database if exists spring_boot_jpa;
create database if not exists spring_boot_jpa default character set utf8mb4 default collate utf8mb4_bin;
drop database if exists spring_boot_jpa_01;
create database if not exists spring_boot_jpa_01 default character set utf8mb4 default collate utf8mb4_bin;
drop database if exists spring_boot_jpa_02;
create database if not exists spring_boot_jpa_02 default character set utf8mb4 default collate utf8mb4_bin;
drop database if exists spring_boot_jpa_03;
create database if not exists spring_boot_jpa_03 default character set utf8mb4 default collate utf8mb4_bin;

drop table if exists datasource;
create table datasource (
    id bigint not null auto_increment,
    create_time datetime comment '创建时间',
    modify_time datetime comment '修改时间',
    is_active char(3) comment '数据源的是否有效：YES，NO',
    lookup_key char(36) comment '数据源的lookupKey',
    password char(36) comment '数据源的密码',
    url char(255) comment '数据源的url',
    username char(100) comment '数据源的用户名',
    primary key (id)
) comment='数据源'engine=InnoDB default charset=utf8mb4 default collate=utf8mb4_bin;

insert into datasource (create_time, modify_time, is_active, lookup_key, password, url, username) values (current_time(), current_time(), 'YES', 'LOOKUP_KEY_01', 'test', 'jdbc:mysql://localhost:3306/spring_boot_jpa_01?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&useSSL=true', 'test');
insert into datasource (create_time, modify_time, is_active, lookup_key, password, url, username) values (current_time(), current_time(), 'YES', 'LOOKUP_KEY_02', 'test', 'jdbc:mysql://localhost:3306/spring_boot_jpa_02?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&useSSL=true', 'test');
insert into datasource (create_time, modify_time, is_active, lookup_key, password, url, username) values (current_time(), current_time(), 'YES', 'LOOKUP_KEY_03', 'test', 'jdbc:mysql://localhost:3306/spring_boot_jpa_03?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&useSSL=true', 'test');
