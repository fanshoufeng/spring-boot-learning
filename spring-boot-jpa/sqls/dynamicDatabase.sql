drop table if exists user;
create table user (
    id bigint not null auto_increment,
    create_time datetime comment '创建时间',
    modify_time datetime comment '修改时间',
    email char(255) comment '邮箱',
    name char(36) comment '姓名',
    nick_name char(255) comment '昵称',
    password char(36) comment '密码',
    reg_time datetime comment '注册时间',
    primary key (id)
) comment='用户'engine=InnoDB default charset=utf8mb4 default collate=utf8mb4_bin;

drop table if exists userdetail;
create table userdetail (
    id bigint not null auto_increment,
    create_time datetime comment '创建时间',
    modify_time datetime comment '修改时间',
    age integer comment '年龄',
    hobby char(255) comment '爱好',
    introduction char(255) comment '介绍',
    last_login_ip char(255) comment '最近登录Ip',
    real_name char(255) comment '姓名',
    status char(255) comment '状态',
    user_id bigint not null comment '用户Id',
    primary key (id)
) comment='用户明细'engine=InnoDB default charset=utf8mb4 default collate=utf8mb4_bin;
alter table userdetail add constraint UK_90967b34b8g7o7uyt8uujn4ya unique (user_id);

drop table if exists address;
create table address (
    id bigint not null auto_increment,
    create_time datetime comment '创建时间',
    modify_time datetime comment '修改时间',
    city char(255) comment '城市',
    province char(255) comment '省',
    street char(255) comment '街道',
    user_id bigint not null comment '用户Id',
    primary key (id)
) comment='地址'engine=InnoDB default charset=utf8mb4 default collate=utf8mb4_bin;
