/*
   约束: 限制
   数据表的数据,不能随意,需要做限制
   主键约束 primary key
   约束内容:
     被设置为主键约束的列,数据在表中具有唯一性
     这个主键列的数据,不能是空(null)
     每个表只能设置一个主键,每个数据表都应该有一个主键
*/

# 创建主键约束的方式1: 创建表的同时,直接创建,推荐使用
CREATE TABLE persons(
	id INT PRIMARY KEY,
	firstname VARCHAR(50),
	lastname VARCHAR(50),
	address VARCHAR(50)
);
INSERT INTO persons(id,firstname,lastname,address)VALUES
(1,'刘','德华','香港');

INSERT INTO persons(id,firstname,lastname,address)VALUES
(2,'张','学友','香港');

# 创建主键约束的方式2: 在创建表的约束区域创建
# 关键字 constraint,可以指定约束的名字 约束字母缩写_列名
DROP TABLE persons;

CREATE TABLE persons(
	id INT ,
	firstname VARCHAR(50),
	lastname VARCHAR(50),
	address VARCHAR(50),
	CONSTRAINT PRIMARY KEY pk_id (id)
);

# 创建主键约束的方式3: 先建好表,修改alter table

CREATE TABLE persons(
	id INT ,
	firstname VARCHAR(50),
	lastname VARCHAR(50),
	address VARCHAR(50)
);

ALTER TABLE persons ADD CONSTRAINT PRIMARY KEY pk_id (id);

# 联合主键,多个列一起,实现一个主键

CREATE TABLE persons(
	id INT ,
	firstname VARCHAR(50),
	lastname VARCHAR(50),
	address VARCHAR(50),
	CONSTRAINT PRIMARY KEY pk(firstname,lastname)
);

/*
  数据的自动增长列 (免维护)
  设置为自动增长列:
    必须是整数
    必须是主键
    关键字 : auto_increment
*/
CREATE TABLE persons(
	id INT PRIMARY KEY AUTO_INCREMENT,
	firstname VARCHAR(50),
	lastname VARCHAR(50),
	address VARCHAR(50)
);
INSERT INTO persons(firstname,lastname,address)VALUES('刘','德华','香港');
INSERT INTO persons(firstname,lastname,address)VALUES('张','学友','香港');

# 添加语句,可以简化书写
# 主键列,写值是null,自动增长
INSERT INTO persons VALUES(NULL,'黎','明','香港');

# 删除主键是3的数据
DELETE FROM persons WHERE id = 3;

DELETE FROM persons

INSERT INTO persons VALUES(NULL,'周','星驰','香港');


# 摧毁表,并重建,主键数据从1开始
TRUNCATE persons;


