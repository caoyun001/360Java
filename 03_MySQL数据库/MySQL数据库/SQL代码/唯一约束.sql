/*
   唯一约束:
   设置唯一约束的这个列,数据必须唯一性
   
   主键约束也具有唯一性
   唯一约束也具有唯一性
   
   主键约束,数据不能是真实的业务数据
   关键字 unique
   
*/

DROP TABLE persons;

# 创建唯一约束的方式1: 创建表的同时,直接创建  推荐方式
CREATE TABLE persons (
	  id INT PRIMARY KEY AUTO_INCREMENT,
	  firstname VARCHAR(255)  UNIQUE,
	  lastname VARCHAR(255),
	  address VARCHAR(255)
);


INSERT INTO persons VALUES(NULL,'张','三丰','中国');

# 数据添加失败,唯一约束
INSERT INTO persons VALUES(NULL,'张','无忌','中国');


INSERT INTO persons VALUES(NULL,'','三丰','中国');


# 创建唯一约束的方式2: constraint区域添加
CREATE TABLE persons (
	  id INT PRIMARY KEY AUTO_INCREMENT,
	  firstname VARCHAR(255) ,
	  lastname VARCHAR(255),
	  address VARCHAR(255),
	  CONSTRAINT UNIQUE qk_firstname(firstname)
);

# 创建唯一约束的方式3: 修改表结构 alter table
CREATE TABLE persons (
	  id INT PRIMARY KEY AUTO_INCREMENT,
	  firstname VARCHAR(255) ,
	  lastname VARCHAR(255),
	  address VARCHAR(255)

);
ALTER TABLE persons MODIFY firstname VARCHAR(255) UNIQUE;

# 删除唯一约束

/*
   添加唯一约束后: 数据库MySQL认为,这个列会经常被查询
   会为这个列自动添加 索引(提高数据查询效率 )
   删除的是这个索引
*/

ALTER TABLE persons DROP INDEX firstname;