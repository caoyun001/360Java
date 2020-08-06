/*
  聚合函数
   sum(列名) 列的所有值求和
   min(列名) 查询列中的最小值
   max(列名) 查询列中的最大值
   avg(列名) 列的所有值求和/列数,平均值
   count(列名) 统计该列共有多少条数据
*/

#查询商品的总条数
SELECT COUNT(*) FROM product;
SELECT COUNT(pid) FROM product;

#查询价格大于200商品的总条数
SELECT COUNT(pid)  FROM product WHERE price > 200;

#查询所有商品的价格总和
SELECT SUM(price) FROM product;

#查询分类为'c001'的所有商品的价格总和
SELECT SUM(price) FROM product WHERE category_id = 'c001';

#查询分类为'c002'所有商品的平均价格
SELECT AVG(price) FROM product WHERE category_id = 'c002';

#查询商品的最大价格和最小价格

SELECT MAX(price),MIN(price) FROM product;

