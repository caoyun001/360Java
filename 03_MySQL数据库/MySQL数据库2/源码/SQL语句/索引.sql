/*
   索引 index
   海量数据的年代,高效
   MySQL数据库,查询数据的时候,全部数据的扫描,找出你要的数据
   索引技术,提升查询效率
   
   MySQL数据的存储引擎: 数据在硬盘中的存储方式 (文件 010101)
     InnoDB:文件
         支持事务
         支持关系,主外键
         数据增删改慢,查询一般
     MyISAM:文件
         不支持事务
         不支持关系,主外键
         数据增删改,快,查询一般
     
     Memory:存储在内存中,关机,丢失
     
     
        1） 单值索引 ：即一个索引只包含单个列，一个表可以有多个单列索引

	2） 唯一索引 ：索引列的值必须唯一，但允许有空值
	   约束,唯一约束 unique, 自动创建索引
	   

	3） 复合索引 ：即一个索引包含多个列
*/

# 价格上创建索引
CREATE INDEX index_price ON  products(price);
# 查询表中的索引
SHOW INDEX  FROM  products;

# 删除索引
DROP  INDEX  index_price  ON  products;
