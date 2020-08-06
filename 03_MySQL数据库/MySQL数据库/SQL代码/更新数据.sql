/*
  更新数据
  对原有数据进行修改
  没有确定,改了就是改了
  关键字 update  set where
  注意:
    修改数据一定要进行条件的筛选
    没有条件筛选,表中的所有数据,都会修改
*/
# update 表名 set 列=值,列=值,列=值 where 条件
# 修改王五,名字,年龄,描述
UPDATE student SET NAME='王五五',age=25,description='一般般' 
WHERE id=3;