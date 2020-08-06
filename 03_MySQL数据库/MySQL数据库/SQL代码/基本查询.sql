
/*
   产品表,商品表 product
   pid 主键 
   pname 商品名字
   price 价格
   category_id 分类
   c001 家电
   c002 服装
   c003 化妆品
   c004 食品
   c005 饮料
*/
CREATE TABLE product(
    pid INT PRIMARY KEY AUTO_INCREMENT,
    pname VARCHAR(20),
    price DOUBLE,
    category_id VARCHAR(32)
);
INSERT INTO product(pid,pname,price,category_id) VALUES(1,'联想',5000,'c001');
INSERT INTO product(pid,pname,price,category_id) VALUES(2,'海尔',3000,'c001');
INSERT INTO product(pid,pname,price,category_id) VALUES(3,'雷神',5000,'c001');
INSERT INTO product(pid,pname,price,category_id) VALUES(4,'JACK JONES',800,'c002');
INSERT INTO product(pid,pname,price,category_id) VALUES(5,'真维斯',200,'c002');
INSERT INTO product(pid,pname,price,category_id) VALUES(6,'花花公子',440,'c002');
INSERT INTO product(pid,pname,price,category_id) VALUES(7,'劲霸',2000,'c002');
INSERT INTO product(pid,pname,price,category_id) VALUES(8,'香奈儿',800,'c003');
INSERT INTO product(pid,pname,price,category_id) VALUES(9,'相宜本草',200,'c003');
INSERT INTO product(pid,pname,price,category_id) VALUES(10,'面霸',5,'c003');
INSERT INTO product(pid,pname,price,category_id) VALUES(11,'好想你枣',56,'c004');
INSERT INTO product(pid,pname,price,category_id) VALUES(12,'香飘飘奶茶',1,'c005');
INSERT INTO product(pid,pname,price,category_id) VALUES(13,'果9',1,NULL);


/*
  数据的基本查询
  拼接语句  
  关键字 
    select  选择,查询
    from    来自哪里,哪个表
    where   条件
    as      重命名
    distinct 去重
    
    基本语法:
      select 列名,列名 from 表名 查询指定的列
      select * from 表名 查询所有列 
 
*/

# 查询数据表,显示商品名和价格
SELECT pname,price FROM product;

# 查询全部的商品数据
SELECT * FROM product;


# 查询数据表,查询价格,去掉重复的
SELECT DISTINCT(price) FROM product;

# 查询数据表,所有的商品价格上调100元

SELECT pname,price+100 FROM product;

# 查询数据表,所有的商品价格上调100元 对查询的结果集进行列的重命名
SELECT pname,price+100 AS'price' FROM product;

# 查询数据表,所有的商品价格上调100元 对查询的结果集进行列的重命名,简化书写
# 去掉as,直接空格,写上新列名
SELECT pname,price+100 price FROM product;



 