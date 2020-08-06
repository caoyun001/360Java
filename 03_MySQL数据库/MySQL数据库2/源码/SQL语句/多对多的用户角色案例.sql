/*
  用户和角色:多对多
*/

-- 用户表
CREATE TABLE `user` (
	uid VARCHAR(32) PRIMARY KEY,
	username VARCHAR(32)
);

-- 角色表
CREATE TABLE role (
	rid VARCHAR(32) PRIMARY KEY,
	rname VARCHAR(32)
);

-- 中间表,都是外键
CREATE TABLE user_role(
	uid VARCHAR(32),
	rid VARCHAR(32)
);
/*
  中间表创建外键约束: 省略约束名
  uid外键,user表的uid主键
  rid外键,role表的rid主键
*/
ALTER TABLE user_role ADD CONSTRAINT FOREIGN KEY (uid)
REFERENCES `user` (uid);

ALTER TABLE user_role ADD CONSTRAINT FOREIGN KEY (rid)
REFERENCES role (rid);

# 中间表添加数据,用户是唐国强,角色皇帝
INSERT INTO user_role VALUES(1,2);

# 中间表添加数据,用户是唐国强,角色大臣
INSERT INTO user_role VALUES(1,1);

# 中间表添加数据,用户是刘德华,角色大臣
INSERT INTO user_role VALUES(2,1);

# 中间表添加数据,用户是刘德华,角色歌手
INSERT INTO user_role VALUES(2,3);