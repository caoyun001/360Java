/*
   一对多练习
   省和市
*/

# 创建省份表,主键,名字
CREATE TABLE province(
	pid INT PRIMARY KEY AUTO_INCREMENT,
	pname VARCHAR(20)
);

# 创建城市表,主键,名字,外键
CREATE TABLE city(
	cid  INT PRIMARY KEY AUTO_INCREMENT,
	cname VARCHAR(20),
	pid INT
);

# 城市表添加外键约束,外键是pid,主键是省份表的pid
ALTER TABLE city ADD CONSTRAINT FOREIGN KEY fk_city_pid (pid)
REFERENCES province(pid);

# 省份表添加测试数据
INSERT INTO province VALUES(NULL,'北京市'),(NULL,'河北省'),(NULL,'辽宁省');

# 城市表添加数据,参考省份表的主键!
INSERT INTO city VALUES(NULL,'昌平区',1);
INSERT INTO city VALUES(NULL,'海淀区',1);
INSERT INTO city VALUES(NULL,'朝阳区',1);


INSERT INTO city VALUES(NULL,'石家庄',2);
INSERT INTO city VALUES(NULL,'保定市',2);

INSERT INTO city VALUES(NULL,'沈阳市',3);
INSERT INTO city VALUES(NULL,'葫芦岛市',3);

INSERT INTO city VALUES(NULL,'东莞市',4);
