/*
  创建数据表: 关键字 create table
  格式:
    create table 表名(
       列名1 数据类型[长度] [约束],
       列名2 数据类型[长度] [约束],
       列名3 数据类型[长度] [约束]
    );
    
   细节: 可以使用关键字作为名字,但是为了规范,避开关键字
   使用关键字作为名字,请你添加反引号 ``	  ''  ""
   
   创建学生信息表
   编号,姓名,年龄
*/
CREATE TABLE student(
	id INT,
	NAME VARCHAR(10),
	age INT
);

#需求：创建雇员表，包含雇员的姓名，密码，性别, 生日信息。
CREATE TABLE employee(
	NAME VARCHAR(50),
	PASSWORD VARCHAR(50),
	gender CHAR(1),
	birthday DATE
);



