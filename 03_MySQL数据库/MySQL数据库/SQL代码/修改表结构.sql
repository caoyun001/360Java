/*
  修改表结构
  在已经创建好的数据表中,修改他的结构
  操作具有风险性(数据丢失)
  关键字  alter  table
*/

# 数据表添加列 列名 desc 可变字符255
# alter table 表名 add 列名 数据类型[长度] [约束]
ALTER TABLE student ADD `desc` VARCHAR(255);

# 修改列的数据类型 desc列,修改为int
# alter table 表名 modify 列名 新数据类型[长度] [约束]
ALTER TABLE student MODIFY `desc` INT ;

# 修改列名 desc列名改为 description
# alter table 表明 change 旧列名 新列名 新数据类型[长度] [约束]
ALTER TABLE student CHANGE `desc` `description` INT;

# 修改表名 student 修改为 student_table 
# rename TABLE 旧表名 to 新表明

RENAME TABLE student TO student_table 



