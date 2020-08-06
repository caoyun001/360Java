/*
  条件查询
*/

#查询商品名称为“花花公子”的商品所有信息：
SELECT * FROM product WHERE pname = '花花公子';


#查询价格为800商品
SELECT * FROM product WHERE price = 800;


#查询价格不是800的所有商品
SELECT * FROM product WHERE price <> 800;
SELECT * FROM product WHERE NOT(price = 800);


#查询商品价格大于60元的所有商品信息
SELECT * FROM product WHERE price > 60;

#查询商品价格在200到1000之间所有商品
SELECT * FROM product WHERE price >= 200 AND price <= 1000;
# BETWEEN 值 and 值 区间范围查询 ,前面的值必须小于后面的
# BETWEEN 值 and 值 值是日期,前面的日期小, 2019-5-5   and 2019-10-6
SELECT * FROM product WHERE price BETWEEN 200 AND 1000;

#查询商品价格是200或800的所有商品
SELECT * FROM product WHERE price =200 OR price = 800;
# 推荐使用in查询,包含即可  in(数据无顺序关系)
SELECT * FROM product WHERE price IN(200,800,1);



#查询商品名称含有'霸'字的所有商品
# 使用通配符 % 零个或者多个
SELECT * FROM product WHERE pname LIKE '%霸%';


#查询商品名称以'香'开头的所有商品
SELECT * FROM product WHERE pname LIKE '香%';

#查询商品名称第二个字为'想'的所有商品
SELECT * FROM product WHERE pname LIKE '_想%'


#商品没有分类id的商品
#查询列 category_id 是空值
SELECT * FROM product WHERE category_id IS NULL;

#查询有分类id的商品
#查询列 category_id 不是空值
SELECT * FROM product WHERE category_id IS NOT NULL;