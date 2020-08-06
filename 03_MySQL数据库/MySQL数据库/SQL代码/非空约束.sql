/*
  非空约束:
    约束的是这个列数据不能是 null
    关键字 not null
*/
DROP TABLE persons;


# 创建非空约束的方式1: 创建表直接创建 
CREATE TABLE persons (
	  id INT PRIMARY KEY AUTO_INCREMENT,
	  firstname VARCHAR(255) NOT NULL,
	  lastname VARCHAR(255),
	  address VARCHAR(255)
);

INSERT INTO persons VALUES(NULL,'郭','富成','香港');

# 下面程序是错误的,写不进去
INSERT INTO persons VALUES(NULL,NULL,'富成','香港');




INSERT INTO persons VALUES(NULL,'','家驹','香港');
INSERT INTO persons (id,lastname,address)VALUES(3,'富成','香港');

# 创建非空约束的方式2: 修改表结构 alter table 
CREATE TABLE persons (
	  id INT PRIMARY KEY AUTO_INCREMENT,
	  firstname VARCHAR(255)  ,
	  lastname VARCHAR(255),
	  address VARCHAR(255)
);

ALTER TABLE persons MODIFY firstname VARCHAR(255) NOT NULL;

# 删除非空约束
ALTER TABLE persons MODIFY firstname VARCHAR(255)
