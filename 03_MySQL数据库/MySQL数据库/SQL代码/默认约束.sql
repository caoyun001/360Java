/*
  默认约束:
   对一个列,数据默认
   关键字 default
*/
DROP TABLE persons;
# 创建默认约束方式1: 创建表直接添加
CREATE TABLE persons (
   id INT PRIMARY KEY AUTO_INCREMENT,
   firstname VARCHAR(255),
   lastname VARCHAR(255),
   address VARCHAR(255) DEFAULT '北京市'
);

INSERT INTO persons VALUE(NULL,'张','三丰',NULL);

INSERT INTO persons(id,firstname,lastname) VALUE(NULL,'宋','无极');

# 创建默认约束方式2: 修改表结构

ALTER TABLE persons MODIFY address VARCHAR(255) DEFAULT '天津市';