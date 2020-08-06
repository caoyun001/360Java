/*
  排序查询:
    对查询的结果集排序
    关键字 order by
    升序: asc  默认的,可以不写
    降序: desc
    排序写在SQL语句的最后
*/

#使用价格排序(降序)
SELECT * FROM product ORDER BY price DESC;

#在价格排序(降序)的基础上，以分类排序(降序)

SELECT * FROM product ORDER BY category_id DESC;


#显示商品的价格(去重复)，并排序(降序)
SELECT DISTINCT (price) FROM product ORDER BY price DESC;