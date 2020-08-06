/*
   限制条数查询
   关键字 limit (SQL语句的最末尾)
   语法: limit m,n
   m: 数据表的开始索引0开始
   n: 限制显示多少条
*/
SELECT  * FROM product LIMIT 1,10;

SELECT * FROM product LIMIT 0, 1000;