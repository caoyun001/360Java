CREATE DATABASE day18;

/*
  商品的分类表
  cid主键自动增长
  cname 商品分类名称
*/
CREATE TABLE category(
	cid INT PRIMARY KEY AUTO_INCREMENT,
	cname VARCHAR(32)
);
/*
  商品表
  pid主键自动增长
  category_id 列,是一个外键列
  列的数据,必须以category表的cid列数据为基准
*/

CREATE TABLE product(
	pid INT PRIMARY KEY AUTO_INCREMENT,
	pname VARCHAR(32),
	price INT,
	category_id INT
);

/*
  创建外键约束
  category表的cid列数据 控制  product表的category_id列中的数据
  语法:
    alter table 从表名 add constraint foreign key [约束名] (从表的外键的列名)
    references 主表名(主键列名)
*/
ALTER TABLE product ADD CONSTRAINT FOREIGN KEY fk_category_id (category_id)
REFERENCES category(cid);

# 商品分类表添加测试数据
INSERT INTO category VALUES(NULL,'家电');
INSERT INTO category VALUES(NULL,'服装');

# 商品信息表添加测试数据,注意category_id列的数据,参照主表的主键编写
INSERT INTO product VALUES(NULL,'联想笔记本',5999,1);
INSERT INTO product VALUES(NULL,'花花公子',50,2);

# 添加测试失败的数据
# 主表中没有的数据,从表中添加失败
INSERT INTO product VALUES(NULL,'饼干',99,3);

/*
  创建订单表 orders
  主键,订单总金额
*/
CREATE TABLE orders(
	oid INT PRIMARY KEY AUTO_INCREMENT,
	total INT
);

# 订单表添加测试数据
# 1号订单,联想,Jack
INSERT INTO orders VALUES(NULL,6199);

# 2订单,联想,雷神,Jack
INSERT INTO orders VALUES(NULL,12199);

/*
  商品和订单是多对多关系,中间表,表示关系
  2个列,都是外键,一个关联商品主键,关联订单主键
*/
CREATE TABLE ordersitem(
	pid INT,
	oid INT
);

/*
  中间表创建外键约束
  中间表的pid列外键,主键是商品表pid
*/
ALTER TABLE ordersitem ADD CONSTRAINT FOREIGN KEY fk_pid (pid)
REFERENCES product(pid);

/*
  中间表创建外键约束
  中间表的oid列外键,主键是订单表oid
*/
ALTER TABLE ordersitem ADD CONSTRAINT FOREIGN KEY fk_oid (oid)
REFERENCES orders(oid);

/*
  中间表添加数据
  # 1号订单,联想,Jack
*/
INSERT INTO ordersitem VALUES(1,1);
INSERT INTO ordersitem VALUES(6,1);

/*
  中间表添加数据
  2订单,联想,雷神,Jack
*/
INSERT INTO ordersitem VALUES(1,2);
INSERT INTO ordersitem VALUES(4,2);
INSERT INTO ordersitem VALUES(6,2);