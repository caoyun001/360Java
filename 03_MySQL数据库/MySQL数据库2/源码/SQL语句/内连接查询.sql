/*
  多表查询: 内连接 隐式
  查询语法:
   select 列名 from 表A,表B
   where条件 主表的主键=从表的外键
*/
SELECT * FROM category,products WHERE
cid = category_id;

/*
  假如,主表的主键和从表的外键的列名,相同
  表名.列名
*/
SELECT * FROM category,products WHERE
category.cid = products.category_id;

/*
  可以使用 as 重命名
*/
SELECT * FROM category c ,products p 
WHERE c.cid = p.category_id;

/*
  内连接: 显示内连接
  关键字 inner join
  条件过滤,关键字 on
*/
SELECT * FROM category c INNER JOIN products p
ON c.cid = p.category_id;

