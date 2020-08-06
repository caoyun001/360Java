/*
   分组查询
   举例:
     80人,分成10个组,每个组8人
     统计数据,每个小组统计
     1组: 成绩100
     2组: 成绩99
     
   一个列的相同值,进行分组
   关键字 group by 列名
*/

# 按照商品分类,进行价格求和
SELECT SUM(price),category_id FROM product GROUP BY category_id;

# 需求追加, 不想看到求和后价格低于1000的
# 在分组求和后的数据基础之上,再次条件过滤
# where 条件过滤在表中过滤(真实的数据表)
# 查询后的结果,过滤条件,使用关键字 having

SELECT SUM(price) price,category_id FROM product GROUP BY category_id
HAVING price > 1000;


# 统计各个分类商品的个数
SELECT COUNT(pid),category_id FROM product GROUP BY category_id;

# 统计各个分类商品的个数,且只显示个数大于1的信息
SELECT COUNT(pid) pid,category_id FROM product GROUP BY category_id HAVING pid>1;

# 统计价格>200元的 各个分类商品的个数,且只显示个数大于1的信息
SELECT COUNT(pid) pid,category_id FROM product WHERE price > 200 GROUP BY category_id HAVING pid>1;


