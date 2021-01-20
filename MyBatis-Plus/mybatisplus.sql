use mybatisPlus;
drop table if exists user;
create table user
(
	id bigint(20) not null comment '主键ID',
    name varchar(30) null default null comment '姓名',
    age int(11) null default null comment '年龄',
    email varchar(50) null default null comment '邮箱',
    primary key(id)
);
insert into user(id,name,age,email) values
(1,'Jone',18,'test1qq.com'),
(2,'Jack',20,'test2qq.com'),
(3,'Tom',28,'test3qq.com'),
(4,'Sandy',21,'test4qq.com'),
(5,'Billie',24,'test5qq.com');

-- 设置主键自增
ALTER TABLE `mybatisplus`.`user` 
CHANGE COLUMN `id` `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID' ;

-- 增加创建和更新时间字段
ALTER TABLE `mybatisplus`.`user` 
ADD COLUMN `create_time` DATETIME NULL COMMENT '创建时间' AFTER `email`,
ADD COLUMN `update_time` DATETIME NULL COMMENT '更新时间' AFTER `create_time`;

-- 增加乐观锁
ALTER TABLE `mybatisplus`.`user` 
ADD COLUMN `version` INT(10) NULL DEFAULT 1 COMMENT '乐观锁' AFTER `email`;

-- 增加逻辑删除字段
ALTER TABLE `mybatisplus`.`user` 
ADD COLUMN `deleted` INT(1) NULL DEFAULT 0 COMMENT '逻辑删除' AFTER `version`;

    