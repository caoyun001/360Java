/*
  数据表添加数据
  关键字 insert  into  values
*/

# 添加数据的格式1:
# insert [into] 表名(列名1,列名2,列名3)values(值1,值2,值3)
# 数据库中,值的引号问题,数字可以不写任何符号,其他数据类型加引号,单引号
INSERT INTO student(id,NAME,age,description)VALUES(1,'张三',20,'学习努力');

# 添加数据的格式2:
# insert [into]表名 values(全部的值)
INSERT INTO student VALUES(2,'李四',21,'不好好学习');

# 添加数据的格式3: 批量数据
# insert [into]表名 values(全部的值),(全部的值),(全部的值)
INSERT INTO student VALUES
(3,'王五',24,'还是可以'),
(4,'赵柳',30,'天天扫雷'),
(5,'冯琦',19,'天天空档接龙')



