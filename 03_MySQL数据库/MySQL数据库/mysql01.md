# 第1章 数据库介绍

## 1 数据库概述

- 什么是数据库

数据库就是存储数据的仓库，其本质是一个文件系统，数据按照特定的格式将数据存储起来。用户可以对数据库中的数据进行增加，修改，删除及查询操作。

```
集合、文件、数据库，三者进行存储数据的对比：
1. 集合：数据存储在内存中；问题是，一旦程序执行完毕了，数据消失了，数据不能永久性的储存
2. 文件：数据储存在磁盘中，可以永久性储存；问题是，当文件储存数据量达到几个G时，文件的打开都成文件，数据的操作就更成问题了
3. 数据库：数据储存的磁盘中，可以永久性储存；当数据量很大时，数据操作起来也很流畅；合适数据的频繁的增删改查的操作
```

## 2 数据库管理系统

数据库管理系统（DataBase Management System，DBMS）：指一种**操作数据库、管理数据库的大型软件**。

作用：**用于数据库的建立、使用和维护数据库**。

```
注意：
1. 用户必须通过数据库管理系统才能访问到数据库中表的数据
2. 数据库中的表，是存储数据的基本单位
```

数据库管理系统的功能：**实现了对多个数据库进行统一管理和控制，以保证数据库的安全性和完整性**

- 数据库与数据库管理系统的内部结构

  ![1568446598173](mysql01.assets/1568446598173.png)

  

## 3 Java类和数据表的对应关系

数据库中以表为基本单位，进行存储数据。那么使用我们熟悉的java类 与 数据表对比，就会发现以下对应关系。

![1568446560864](mysql01.assets/1568446560864.png)

- 表记录与java类的对应关系

| Java           | 数据库     |
| -------------- | ---------- |
| 类             | 表         |
| 定义的成员变量 | 字段（列） |
| 对象           | 记录（行） |

## 4 常见数据库

- 常见的数据库

**MYSQL**：开源免费的数据库，小型的数据库.已经被Oracle收购了.MySQL.x版本也开始收费。

**Oracle**：收费的大型数据库，Oracle公司的产品。Oracle收购SUN公司，收购MYSQL。

**DB2** ：IBM公司的数据库产品,收费的。常应用在银行系统中.

**SQLServer**：MicroSoft 公司收费的中型的数据库。C#、.net等语言常使用。

**SyBase**：已经淡出历史舞台。提供了一个非常专业数据建模的工具PowerDesigner。

**SQLite**：嵌入式的小型数据库，应用在手机端。

常用数据库：**MYSQL**

我们学习的是MySQL数据库。为了追求高性能，开发中多个Mysql，搭建MySQL高可用负载均衡集群

# 第2章 MySql数据库

## 1 卸载：

1、在控制面板中找到  程序和功能   点击  找到 应用程序  mysql  卸载。

2、删除数据库在本机中的数据文件目录。把mysql目录删除。

## 2 **安装：**

1、安装的时候选择 自定义安装， 需要更改默认的安装目录， 安装时 不要安装在有中文 或 空格的目录。

2、安装的其他细节可以参考安装文档。

### 2.1  安装版关键步骤：

：![img](mysql01.assets/wps1.jpg)

![img](mysql01.assets/wps2.jpg) 

![img](mysql01.assets/wps3.jpg) 

选择数据库的安装位置

![img](mysql01.assets/wps4.jpg) 

选择数据库 数据文件安装位置

![img](mysql01.assets/wps5.jpg) 

 

设置mysql数据库的默认编码集

![img](mysql01.assets/wps6.jpg) 

 

设置mysql的默认字符集

![img](mysql01.assets/wps7.jpg) 

![img](mysql01.assets/wps8.jpg) 

 

 

### 2.2 测试：

查看windows服务 ，mysql数据库是否启动。

打开dos窗口测试数据库：

![img](mysql01.assets/wps9.jpg) 

 

显示所有的数据库：

![img](mysql01.assets/wps11.jpg).

注意：书写的所有sql语句， 要求结尾必须有分号。

安装后，MySQL会以windows服务的方式为我们提供数据存储功能。开启和关闭服务的操作：**右键点击我的电脑→管理→服务→可以找到MySQL服务开启或停止**。

![1568446447469](mysql01.assets/1568446447469.png).

![1568446479700](mysql01.assets/1568446479700.png)

也可以在DOS窗口，通过命令完成MySQL服务的启动和停止（必须以管理员身份运行cmd命令窗口）

![1568446500723](mysql01.assets/1568446500723.png).

## 3 连接MySQL数据库

MySQL是一个需要账户名密码进行连接的数据库，连接后才能使用，它提供了一个默认的root账号，使用安装时设置的密码即可登录。

```
-- 格式1，本地连接：cmd>  mysql –u用户名 –p密码
mysql -uroot –proot
```

```
-- 格式2，远程连接：cmd>  mysql --host=ip地址 --user=用户名 --password=密码 
mysql --host=127.0.0.1  --user=root --password=root 
```

默认情况下，mysql只允许本地登录，如果要开启远程连接，则需要修改/etc/mysql/my.conf文件。这里不做讲解

## 4 MySQL图形化开发工具

- 安装：

  提供的SQLyog软件为安装版，需要安装后使用

  提供的Navicat软件为安装版，需要安装后使用

- 使用：

输入用户名、密码，点击连接按钮，进行访问MySQL数据库进行操作

![1568446518891](mysql01.assets/1568446518891.png)



下图为 连接mysql以后, 选择了名为"mysql"的数据库, 展示了这个数据库中所有的表。

![1568446546193](mysql01.assets/1568446546193.png)

# 第3章 SQL语句

![1569032219348](mysql01.assets/1569032219348.png)

## 1 SQL概述

### SQL语句介绍

数据库是不认识JAVA语言的，但是我们同样要与数据库交互，这时需要使用到数据库认识的语言【SQL语句】，它是数据库的代码。结构化查询语言(Structured Query Language)简称SQL，是关系型数据库管理系统都需要遵循的规范。不同的数据库生产厂商都支持SQL语句，但都有特有内容。

![1568446625015](mysql01.assets/1568446625015.png)

### SQL语句分类

- SQL分类：

  - 数据定义语言：简称DDL(Data Definition Language)，用来定义数据库对象：数据库，表，列等。关键字：create，alter，drop等

  - 数据控制语言：简称DCL(Data Control Language)，用来定义数据库的访问权限和安全级别，及创建用户。

  - **数据操作语言：简称DML(Data Manipulation Language)，用来对数据库中表的记录进行更新。关键字：insert，delete，update等**

  - **数据查询语言：简称DQL(Data Query Language)，用来查询数据库中表的记录。关键字：select，from，where等**

    ![1568971186111](mysql01.assets/1568971186111.png)


### SQL语句的书写语法

- MySQL数据库的SQL语句不区分大小写，关键字建议使用大写，以分号结尾。例如：

  ```sql
  SELECT * FROM user;
  ```

- 使用/**/、 -- 、# 的方式完成注释

  ```sql
  /*
  多行注释
  */
  -- 单行注释
  # 单行注释
  SELECT * FROM user;
  ```

### SQL中数据的常用数据类型

- MySQL中的我们常使用的数据类型如下

| **类型名称**     | 说明                                                   |
| ---------------- | ------------------------------------------------------ |
| **int**          | 整数类型                                               |
| **double**       | 小数类型                                               |
| decimal（m,d）   | 指定整数位与小数位长度的小数类型                       |
| **date**         | 日期类型，格式为yyyy-MM-dd，包含年月日，不包含时分秒   |
| datetime         | 日期类型，格式为 YYYY-MM-DD HH:MM:SS，包含年月日时分秒 |
| timestamp        | 日期类型，时间戳                                       |
| **varchar（M）** | 文本类型， M为0~65535之间的整数, 变长                  |
| char(M)          | 文本类型, M为0~65535之间的整数, 定长                   |

char(10)				abc		10个字符

varchar(10)			abcde		5个字符

## 2 数据库操作: database

### 2.1 查看数据库

```sql
/*查看数据库*/
-- 查看所有的数据库. 格式: show databases;
SHOW DATABASES;

-- 查看指定数据库的字符编码. 格式: show create database 数据库名;
SHOW CREATE DATABASE mydb;
SHOW CREATE DATABASE mydb2;
```







```http
需求1 查询mysql数据库软件的所有 数据库
需求2 查看mysql数据库的编码
```

![1569034499158](mysql01.assets/1569034499158.png)

### 2.2 创建数据库

```sql
/*创建数据库*/
-- 方式一: 使用指定的字符编码表,创建数据库.  格式: create database 数据库名 [character set 字符编码];
-- 方式二: 使用默认的字符编码表,创建数据库.  格式: create database 数据库名;
CREATE DATABASE mydb CHARACTER SET utf8; -- 方式一
CREATE DATABASE mydb2; -- 方式二
```





```http
需求1 创建一个名称为mydb1的数据库。
需求2 创建一个使用utf8字符集的mydb2数据库。
```

答案

```
需求1 创建一个名称为mydb1的数据库。
create database mydb1;
show databases;
show create database mydb1;

需求2 创建一个使用utf8字符集的mydb2数据库。
create database mydb2 character set utf8;
show databases;
show create database mydb2;
```



### 2.3 删除数据库

```sql
/*删除数据库*/
-- 删除数据库. 格式: drop database 数据库名;
DROP DATABASE mydb2;
```





```http
需求：删除前面创建的mydb1数据库
drop database mydb1;
```



### 2.4 修改数据库编码集

```
语法：alter database 数据库名称 character set 字符集 [collate 排序规则]; 
```





```http
需求: 将mydb2的编码集改成 gbk
alter database mydb2 character set gbk;
show create database mydb2;
```

### 2.5 切换数据库和查看正在使用的数据库

```sql
/*使用数据库*/
-- 查看当前使用的数据库. 格式: select database();
SELECT DATABASE();

-- 设置当前使用的数据库. 格式: use 数据库名;
USE mydb;
```



## 3 表操作：table

### 3.1 创建表

```sql
/*
创建表, 格式:
    create table 表名 (
        字段名 数据类型[长度] [约束],
        字段名 数据类型[长度] [约束],
        ...
    );
注:[]中的内容是可选项
*/
-- 创建表student, 字段包括 编号id\ 姓名name\ 年龄age
CREATE TABLE student (
    id INT,
    NAME VARCHAR(100),
    age INT
);

-- 创建表users, 字段包括 编号id\ 用户名username \ 密码password
CREATE TABLE users (
    id INT,
    username VARCHAR(100),
    PASSWORD VARCHAR(100)
);
```



```http
需求：创建雇员表，包含雇员的姓名，密码，性别, 生日信息。
```





```
需求：创建雇员表，包含雇员的姓名，密码，性别, 生日信息。
create table emp(
	name varchar(32),
	password varchar(16),
	sex char(1),
	birthday date
);
```



### 3.2 查看表

```sql
-- 查看表结构
desc 表名;

-- 查看所有表, 格式: show tables
SHOW TABLES;

-- 查看指定表的建表结构, 格式: show create table 表名;
SHOW CREATE TABLE users;
```







```http
需求：查看雇员表结构
```



### 3.3 删除表

```sql
-- 删除表, 格式: drop table 表名;
DROP TABLE users;
```





```http
需求：删除emp表

drop table emp;
show tables;
```



### 3.4 修改表结构格式

```sql
/*
对表中的列进行修改
1. 添加新的列, 格式: alter table 表名 add 新列名 数据类型(长度);
2. 修改列的数据类型(长度), 格式: alter table 表名 modify 列名 修改后的数据类型(长度);
3. 修改列的名称, 格式: alter table 表名 change 列名 新列名 新列名的数据类型(长度);
4. 删除指定列, 格式: alter table 表名 drop 列名;
*/
ALTER TABLE student ADD `desc` VARCHAR(100); -- 添加新的列
ALTER TABLE student MODIFY `desc` VARCHAR(50);-- 修改列的数据类型(长度)
ALTER TABLE student CHANGE `desc` description VARCHAR(100);-- 修改列的名称
ALTER TABLE student DROP description;-- 删除指定列

/*
对表进行修改
1. 修改表的名称, 格式: rename table 表名 to 新表名; 
2. 修改表的字符编码, 格式: alter table 表名 character set 字符编码;
*/
RENAME TABLE student TO stu; -- 修改表的名称
ALTER TABLE stu CHARACTER SET gbk; -- 修改表的字符编码
```







```http
需求1 在employee2表上增加salary列
需求2 修改name列的长度为60
需求3 修改列名name为username
需求4 删除sex列
需求5 将employee2表名修改为person表
需求6 将employee的编码修改成utf8
```





```
需求1 在emp表上增加salary列
alter table emp add salary double;

需求2 修改name列的长度为64
alter table emp modify name varchar(64);

需求3 修改列名name为username
alter table emp change name username varchar(32);

需求4 删除sex列
alter table emp drop sex;

需求5 将emp表名修改为person表
rename table emp to person;


需求6 将person的编码修改成utf8
alter table person character set utf8;
```



## 4 表中记录操作

### 4.1 插入表记录

```sql
/*
插入表记录
方式一, 对指定的字段插入值, 格式: insert into 表名(字段1, 字段2, ...) values (值1, 值2, ...);
方式二, 对所有字段插入值, 格式: insert into 表名 values(值1, 值2, ...);
*/

INSERT INTO student(id, NAME, age) VALUES(1, 'tom', 24);
INSERT INTO student(NAME, age) VALUES('lili', 22);
INSERT INTO student(id, NAME, age) VALUES(3, 'jim', NULL);

INSERT INTO student VALUES(4, 'jack', 26);
INSERT INTO student VALUES(5, 'zhangsan', 26),
                          (6,'lisi',27);
```

- 注意
  1. 值与字段必须对应, 个数相同, 类型相同
  2. 值的数据大小必须在字段的指定长度范围内
  3. 除了整数\小数类型外, 其他字段类型的值必须使用引号引起来 (建议单引号)
  4. 如果要插入空值, 可以不写字段, 或者插入null







```http
需求1 给person表中的所有列插入数据
需求2 简化给person表中的所有列插入数据
需求3 给表中不为空的列插入数据
```





```
需求1 给person表中的所有列插入数据
insert into person(username, password, birthday, salary) values('zhangsan', '123', '2019-09-09', 15000);

需求2 简化给person表中的所有列插入数据
insert into person values('lisi', '123', '2016-06-06', 6600);

需求3 给表中不为空的列插入数据
insert into person(username, password) values('wangwu', '123');

insert into person(username, password, birthday) values('wangwu', '123', null);
```



### 4.2 更新表记录

```sql
-- 更新表记录, 格式: update 表名 set 字段1=值, 字段2=值... where 条件;
UPDATE student SET NAME='lili', age=21 WHERE id=1;
UPDATE student SET age=25 WHERE age=27;
```

- 注意
  1. 列名的类型与修改的值要一致
  2. 修改值时不能超过字段的长度范围
  3. 除了整数\小数类型外, 其他字段类型的值必须使用引号扩起来





```http
需求1 修改person表中的所有用户的password 为 abcdef
需求2 修改姓名为zhangsan的这个用户的薪水 88888
需求3 把姓名为 lisi 的用户 的 username和password 修改为 zhaoliu
需求4 把姓名为 zhaoliu 的用户 用户名修改为 中文的 赵六;
```







```
需求1 修改person表中的所有用户的password 为 abcdef
update person set password='abcdef';

需求2 修改姓名为zhangsan的这个用户的薪水 88888
update person set salary=88888 where username='zhangsan';

需求3 把姓名为 lisi 的用户 的 username和password 修改为 zhaoliu
update person set username='zhaoliu', password='zhaoliu' where username='lisi';

需求4 把姓名为 zhaoliu 的用户 用户名修改为 中文的 赵六;
update person set username='赵六' where username='zhaoliu';

```



### 4.3 删除表记录

```sql
-- 删除表记录, 格式: delete from 表名 where 条件;
DELETE FROM student WHERE id=1;
DELETE FROM student WHERE age IS NULL;
```





```http
需求1 删除person表中name为lisi的用户记录
需求2 删除表中所有记录
```





### 4.4 删除表所有记录

```sql
TRUNCATE [TABLE] 表名;
或
delete from 表名;
```



```
两者区别
1 DELETE
　・DML语言
　・可以回退(可以将数据找回来)
　・可以有条件的删除

     DELETE FROM 表名 WHERE 条件

2 TRUNCATE TABLE
　・DDL语言
　・无法回退(不可以将数据找回来)
　・默认所有的表内容都删除
　・删除速度比delete快。
```



## 5 DOS命令行数据乱码解决

我们在dos命令行操作中文时，会报错

```sql
insert into student(id,name,age) values(99,'超人',25);        
ERROR 1366 (HY000): Incorrect string value: '\xB3\xAC\xC8\xCB' for column 'name' at row 1
```

错误原因:因为mysql的客户端设置编码是utf8,而windows系统的cmd窗口编码是gbk

1. 查看MySQL内部设置的编码

```
show variables like 'character%'; 查看所有mysql的编码
```

![1568446720977](mysql01.assets/1568446720977.png)

1. 需要修改client、connection、results的编码一致（改为GBK编码）

解决方案1：在cmd命令窗口中输入命令，此操作当前窗口有效，为临时方案。

```sql
set names gbk;
```

解决方案2：安装目录下修改my.ini文件，重启服务所有地方生效。

![1568446740086](mysql01.assets/1568446740086.png)



# 第4章 SQL约束

- 什么是约束

约束, 其实就是一种限制条件, 让你不能超出这个控制范围.

而在数据库中的约束, 就是指 表中的数据内容 不能胡乱填写, 必须按照要求填写. 好保证数据的完整性与安全性.

```sql
-- 准备数据
CREATE TABLE persons (
  pid int,
  lastname varchar(255),
  firstname varchar(255),
  address varchar(255)
);
insert into persons values(1, '星驰','周','香港');
insert into persons values(1, '德华','刘','香港');
insert into persons values(2, '德华','刘',null);
insert into persons values(null, '润发','周','香港');
```

## 1 主键约束

PRIMARY KEY 约束:

- 主键必须包含唯一的值, 不能重复。
- 主键列不能包含 NULL 值。
- 每个表都应该有一个主键，并且每个表只能有一个主键。

### 添加主键约束

- 方式一：创建表时，在字段描述处，声明指定字段为主键：
  - 格式: `字段名 数据类型[长度] PRIMARY KEY`

```sql
CREATE TABLE persons (
  pid int primary key, -- 添加了主键约束
  lastname varchar(255),
  firstname varchar(255),
  address varchar(255)
);
INSERT INTO persons VALUES(1, '星驰','周','香港');
INSERT INTO persons VALUES(1, '德华','刘','香港'); -- 设置主键后, 插入失败, 值重复
INSERT INTO persons VALUES(2, '德华','刘',NULL);
INSERT INTO persons VALUES(NULL, '润发','周','香港'); -- 设置主键后, 插入失败, 值不能为 NULL
```

- 方式二：创建表时，在constraint约束区域，声明指定字段为主键：
  - 格式：`[constraint 名称] primary key (字段列表)`
  - 关键字constraint可以省略，如果需要为主键命名，constraint不能省略，主键名称一般没用。
  - 字段列表需要使用小括号括住，如果有多字段需要使用逗号分隔。声明两个以上字段为主键，我们称为联合主键。

```sql
CREATE TABLE persons (
  pid int,
  lastname varchar(255),
  firstname varchar(255),
  address varchar(255),
  constraint pk_persons primary key (pid) -- 添加主键约束, 单一字段 
);

CREATE TABLE persons (
  pid INT,
  lastname VARCHAR(255),
  firstname VARCHAR(255),
  address VARCHAR(255),
  CONSTRAINT pk_persons PRIMARY KEY (lastname, firstname) -- 添加主键约束, 多个字段, 我们称为联合主键。
);
INSERT INTO persons VALUES(1, '星驰','周','香港');
INSERT INTO persons VALUES(1, '德华','刘','香港'); 
INSERT INTO persons VALUES(2, '德华','刘',NULL); -- 插入失败
```

- 方式三：创建表之后，通过修改表结构，声明指定字段为主键：
  - 格式：`ALTER TABLE 表名 ADD [CONSTRAINT 名称] PRIMARY KEY (字段列表)`

```sql
CREATE TABLE persons (
  pid int,
  lastname varchar(255),
  firstname varchar(255),
  address varchar(255),
);
alter table persons add constraint pk_persons primary key (lastname, firstname); -- 添加联合主键
```

### 删除主键约束

如需删除 PRIMARY KEY 约束，请使用下面的 SQL：

- 格式: `ALTER TABLE 表名 DROP PRIMARY KEY`

```sql
alter table persons drop primary key;	
```

## 2 自动增长列

我们通常希望在每次插入新记录时，数据库自动生成字段的值。

我们可以在表中使用 auto_increment（自动增长列）关键字，自动增长列类型必须是整形，自动增长列必须为键(通常是用于主键)。

- 下列 SQL 语句把 "persons" 表中的 "pid" 列定义为 auto_increment 主键
- 格式: `字段名 整数类型[长度][约束] auto_increment`

```sql
CREATE TABLE persons (
  pid INT PRIMARY KEY AUTO_INCREMENT,
  lastname VARCHAR(255),
  firstname VARCHAR(255),
  address VARCHAR(255)
);
```

- 向persons添加数据时，可以不为pid字段设置值，也可以设置成null，数据库将自动维护主键值：

```sql
insert into persons(lastname, firstname, address) values('富成','郭','香港');
insert into persons(pid,lastname, firstname, address) values(null,'龙','成','香港');
```

- 扩展：默认AUTO_INCREMENT 的开始值是 1，如果希望修改起始值，请使用下列 SQL 语法：

```sql
alter table persons auto_increment=100;
```

- 面试题

问：针对auto_increment ，删除表中所有记录使用 delete from 表名 或使用 truncate table 表名，二者有什么区别？

```
删除过程:
    delete: 表中记录一条一条删除, auto_increment 计数不会重置为1; 新记录添加时在原有计数基础上＋1
    truncate: 直接将表删除,重新创建新表, auto_increment 计数重置为1; 
```

## 3 非空约束

NOT NULL 约束:

- 列不接受 NULL 值。
- 要求字段始终包含值。这意味着，如果不向字段添加值，就无法插入新记录或者更新记录。

下面的 SQL 语句要求 "lastname" 列和 "firstname" 列不接受 NULL 值：

### 添加非空约束

- 格式: `字段名 数据类型[长度] NOT NULL`

```sql
CREATE TABLE persons (
  pid INT PRIMARY KEY AUTO_INCREMENT,
  lastname VARCHAR(255) not null,
  firstname VARCHAR(255) not null,
  address VARCHAR(255)
);
```

### 删除非空约束

- 格式: `ALTER TABLE 表名 MODIFY 字段名 数据类型[长度]`

```sql
alter table persons modify lastname varchar(255);
alter table persons modify firstname varchar(255);
```

## 4 唯一约束

UNIQUE 约束:

- 指定列的值 不能重复.

注意:

1. UNIQUE 和 PRIMARY KEY 约束均为列提供了唯一性的保证。PRIMARY KEY 是自动定义的 UNIQUE 约束。
2. 每个表可以有多个 UNIQUE 约束，但是每个表只能有一个 PRIMARY KEY 约束。
3. UNIQUE 不限制 null 值 出现的次数

### 添加唯一约束

与主键添加方式相同，共有3种

- 方式一：创建表时，在字段描述处，声明唯一：
  - 格式: `字段名 数据类型[长度] UNIQUE`

```sql
CREATE TABLE persons (
  pid INT,
  lastname VARCHAR(255),
  firstname VARCHAR(255),
  address VARCHAR(255) UNIQUE -- 添加唯一约束
);

INSERT INTO persons(pid,lastname, firstname, address) VALUES(1,'富成','郭','香港');
INSERT INTO persons(pid,lastname, firstname, address) VALUES(2,'润发','周','香港');-- 插入失败,值重复
```

- 方式二：创建表时，在约束区域，声明唯一：
  - 格式：`[constraint 名称] UNIQUE (字段)`

```sql
CREATE TABLE persons (
  pid INT,
  lastname VARCHAR(255),
  firstname VARCHAR(255),
  address VARCHAR(255),
  CONSTRAINT uni_address UNIQUE (address) -- 添加唯一约束
);
```

- 方式三：创建表后，修改表结构，声明字段唯一：
  - 格式: `ALTER TABLE 表名 ADD [CONSTRAINT 名称] UNIQUE (字段)`

```sql
CREATE TABLE persons (
  pid INT,
  lastname VARCHAR(255),
  firstname VARCHAR(255),
  address VARCHAR(255)
);
ALTER TABLE persons ADD CONSTRAINT uni_address UNIQUE (address) -- 添加唯一约束
```

### 删除唯一约束

- 如需删除 UNIQUE 约束，请使用下面的 SQL：
- 如果添加唯一约束时，没有设置约束名称，默认是当前字段的字段名。
  - 格式: `ALTER TABLE 表名 DROP INDEX 名称`

```sql
alter table persons drop index uni_persons_address; -- 有唯一约束名称, 使用约束名称删除
哦
alter table persons drop index address; -- 没有唯一约束名称, 使用字段名删除
```

## 5 默认约束

default 约束:

- 用于指定字段默认值。
- 当向表中插入记录时，如果没有明确的为字段赋值，则自动赋予默认值。

### 添加默认约束

- 添加默认约束，在创建表时候添加
  - 格式: `字段名 数据类型[长度] DEFAULT 默认值`

```sql
CREATE TABLE persons (
  pid INT,
  lastname VARCHAR(255),
  firstname VARCHAR(255),
  address VARCHAR(255) DEFAULT '香港' -- 添加默认约束
);

INSERT INTO persons(pid,lastname, firstname, address) VALUES(1,'富成','郭','北京');
INSERT INTO persons(pid,lastname, firstname) VALUES(2,'龙','成'); -- 使用address的默认值
INSERT INTO persons(pid,lastname, firstname, address) VALUES(3,'润发','周', NULL); 
```

### 删除默认约束

- 格式: `ALTER TABLE 表名 MODIFY 字段名 数据类型[长度]`

```sql
ALTER TABLE persons MODIFY address VARCHAR(255);
```

#  第5章 SQL语句(DQL)

## 1 DQL准备工作和语法

### 准备工作

```sql
#创建商品表：
create table product(
    pid int primary key,
    pname varchar(20),
    price double,
    category_id varchar(32)
);
INSERT INTO product(pid,pname,price,category_id) VALUES(1,'联想',5000,'c001');
INSERT INTO product(pid,pname,price,category_id) VALUES(2,'海尔',3000,'c001');
INSERT INTO product(pid,pname,price,category_id) VALUES(3,'雷神',5000,'c001');
INSERT INTO product(pid,pname,price,category_id) VALUES(4,'JACK JONES',800,'c002');
INSERT INTO product(pid,pname,price,category_id) VALUES(5,'真维斯',200,'c002');
INSERT INTO product(pid,pname,price,category_id) VALUES(6,'花花公子',440,'c002');
INSERT INTO product(pid,pname,price,category_id) VALUES(7,'劲霸',2000,'c002');
INSERT INTO product(pid,pname,price,category_id) VALUES(8,'香奈儿',800,'c003');
INSERT INTO product(pid,pname,price,category_id) VALUES(9,'相宜本草',200,'c003');
INSERT INTO product(pid,pname,price,category_id) VALUES(10,'面霸',5,'c003');
INSERT INTO product(pid,pname,price,category_id) VALUES(11,'好想你枣',56,'c004');
INSERT INTO product(pid,pname,price,category_id) VALUES(12,'香飘飘奶茶',1,'c005');
INSERT INTO product(pid,pname,price,category_id) VALUES(13,'果9',1,NULL);
```

### 语法

```sql
select [distinct] 
* | 列名,列名 
from 表 
where 条件
```



## 2 简单查询

- 练习

  ```
  -- 查询所有的商品. 
  
  -- 查询商品名和商品价格.
  
  -- 查询价格,去掉重复值.
  
  -- 查询结果是表达式（运算查询）：将所有商品的价格+10元进行显示. 
  
  -- 别名查询.使用的关键字是as（as可以省略的）.列别名
  
  -- 别名查询.使用的关键字是as（as可以省略的）.表别名
  
  ```

  

- 答案

  ```sql
  -- 查询所有的商品. 
  SELECT * from product;
  -- 查询商品名和商品价格.
  select pname,price from product;
  -- 查询价格,去掉重复值.
  select DISTINCT price from product;
  -- 查询结果是表达式（运算查询）：将所有商品的价格+10元进行显示. 
  select pname,price+10 from product;
  -- 别名查询.使用的关键字是as（as可以省略的）.列别名
  select pname,price+10 as '价格' from product;
  select pname,price+10 '价格' from product;
  -- 别名查询.使用的关键字是as（as可以省略的）.表别名
  select * from product as p;
  select * from product p;
  ```

## 3 条件查询

| **比较运算符** | < <= > >= = <>    | 大于、小于、大于(小于)等于、不等于                           |
| -------------- | ----------------- | ------------------------------------------------------------ |
|                | BETWEEN ...AND... | 显示在某一区间的值(含头含尾)                                 |
|                | IN(set)           | 显示在in列表中的值，例：in(100,200)                          |
|                | LIKE ‘字符’       | 模糊查询，like语句中，% 代表零个或多个任意字符，_ 代表一个字符， 例如：`first_name like '_a%';` |
|                | IS NULL           | 判断是否为空                                                 |
| **逻辑运行符** | and               | 多个条件同时成立                                             |
|                | or                | 多个条件任一成立                                             |
|                | not               | 不成立，例：`where not(salary>100);`                         |

- 练习

  ```http
  #查询商品名称为“花花公子”的商品所有信息：
  #查询价格为800商品
  #查询价格不是800的所有商品
  #查询商品价格大于60元的所有商品信息
  #查询商品价格在200到1000之间所有商品
  #查询商品价格是200或800的所有商品
  # LIKe 中的 %代表匹配任意长度的任意字符; _代表匹配一个任意字符
  #查询商品名称含有'霸'字的所有商品
  #查询商品名称以'香'开头的所有商品
  #查询商品名称第二个字为'想'的所有商品
  #商品没有分类id的商品
  #查询有分类id的商品
  ```

  

- 答案

  ```sql
  #查询商品名称为“花花公子”的商品所有信息：
  select * from product where pname='花花公子';
  #查询价格为800商品
  select * from product where price=800;
  #查询价格不是800的所有商品
  select * from product where price<>800;
  select * from product where price!=800; -- mysql特有的符号
  #查询商品价格大于60元的所有商品信息
  select * from product where price>60;
  #查询商品价格在200到1000之间所有商品
  select * from product where price>=200 and price<=1000;
  select * from product where price between 200 and 1000;
  #查询商品价格是200或800的所有商品
  select * from product where price=200 or price=800;
  select * from product where price in(200,800);
  # LIKe 中的 %代表匹配任意长度的任意字符; _代表匹配一个任意字符
  #查询商品名称含有'霸'字的所有商品
  select * from product where pname like '%霸%';
  #查询商品名称以'香'开头的所有商品
  select * from product where pname like '香%';
  #查询商品名称第二个字为'想'的所有商品
  select * from product where pname like '_想%';
  #商品没有分类id的商品
  select * from product where category_id is NULL;
  #查询有分类id的商品
  select * from product where category_id is NOT NULL;
  ```

  

## 4 排序查询

通过order by语句，可以将查询出的结果进行排序。暂时放置在select语句的最后。

- 格式:

```sql
SELECT * FROM 表名 ORDER BY 排序字段 ASC|DESC;
#ASC 升序 (默认), 从小到大排序
#DESC 降序, 从大到小排序
```

- 练习

  ```sql
  #使用价格排序(降序)
  #在价格排序(降序)的基础上，以分类排序(降序)
  #显示商品的价格(去重复)，并排序(降序)
  ```

  

- 答案

  ```sql
  #使用价格排序(降序)
  select * from product order by price desc;
  #在价格排序(降序)的基础上，以分类排序(降序)
  select * from product order by price desc,category_id desc;
  #显示商品的价格(去重复)，并排序(降序)
  select DISTINCT price from product order by price desc;
  ```

  

## 5 聚合查询_重点

之前我们做的查询都是横向查询，它们都是根据条件一行一行的进行判断，而使用聚合函数查询是纵向查询，它是对一列的值进行计算，然后返回一个单一的值；另外聚合函数会忽略空值。

今天我们学习如下五个聚合函数：

- count：统计指定列不为NULL的记录行数；

- sum：计算指定列的数值和，如果指定列类型不是数值类型，那么计算结果为0；

- max：计算指定列的最大值，如果指定列是字符串类型，那么使用字符串排序运算；

- min：计算指定列的最小值，如果指定列是字符串类型，那么使用字符串排序运算；

- avg：计算指定列的平均值，如果指定列类型不是数值类型，那么计算结果为0；



* 练习

  ```sql
  #查询商品的总条数
  
  #查询价格大于200商品的总条数
  
  #查询分类为'c001'的所有商品的价格总和
  
  #查询分类为'c002'所有商品的平均价格
  
  #查询商品的最大价格和最小价格
  ```

* 答案：

  ```sql
  #查询商品的总条数
  select count(*) from product; -- 不推荐
  select count(pid) from product;
  select count(category_id) from product;
  
  #查询价格大于200商品的总条数
  select count(*) from product where price>200;
  
  #查询分类为'c001'的所有商品的价格总和
  select sum(price) from product where category_id='c001';
  
  #查询分类为'c002'所有商品的平均价格
  select avg(price) from product where category_id='c002';
  
  #查询商品的最大价格和最小价格
  select max(price),min(price) from product;
  ```

  

## 6 分组查询_重点_难点

分组查询是指使用group by字句对查询信息进行分组。

- 格式：

```sql
SELECT 字段1,字段2… FROM 表名 where 条件 GROUP BY 分组字段 HAVING 分组条件;
```

分组操作中的having子语句，是用于在分组后对数据进行过滤的，作用类似于where条件。

- having与where的区别:

  - having是在分组操作执行后, 对分组后的数据进行过滤.

    where是在分组操作执行前, 对分组前的数据 只能使用表原始列进行条件过滤

  - having后面可以使用 聚合函数

    where后面不可以使用 聚合函数。

  - 当一条SQL语句中, 既有where 又有 group by \ having时, 先执行 where, 再执行 group by, 最后执行having


select 6

from 1

where 2

group by 3

having 4

order by 5

- 练习

  ```sql
  # 统计各个分类商品的个数
  
  # 统计各个分类商品的个数,且只显示个数大于1的信息
  
  # 统计价格>200元的 各个分类商品的个数,且只显示个数大于1的信息
  ```

  

- 答案

  ```sql
  #统计各个分类商品的个数
  select category_id,count(*) from product group by category_id;
  
  #统计各个分类商品的个数,且只显示个数大于1的信息
  SELECT category_id,count(*) from product GROUP BY category_id HAVING count(*)>1;
  
  #统计价格>200元的 各个分类商品的个数,且只显示个数大于1的信息
  -- select * from product where price>200 group by category_id;
  -- select category_id,count(*) from product where price>200 group by category_id ;
  select category_id,count(*) from product where price>200 group by category_id HAVING count(*)>1;
  ```



## 7 条数限制查询-- 重点重点重点

LIMIT是MySQL内置函数，其作用是**用于限制查询结果的条数**。

```sql
格式: select * from 表名 limit m,n
其中: m是指记录开始的index，从0开始，表示第一条记录
     n是指从第m+1条开始，取n条。

例如:
    select * from tablename limit 2,4 -- 即取出第3条至第6条，4条记录    
```

应用场合:分页

```sql
分页查询格式: 
SELECT * FROM 表名 LIMIT startRow,pageSize;

例如：
select * from products limit 0,5;   #第一页，每页显示5条。
select * from products limit 5,5;   #第二页，每页显示5条。
select * from products limit 10,5;  #第三页，每页显示5条。
select * from products limit startRow,5; #第curPage页，每页显示5条, startRow的值如何计算呢?

-- 后台计算出页码、页数(页大小)
-- 分页需要的相关数据结果分析如下,
-- 注意:下面是伪代码不用于执行
int curPage = 2; -- 当前页数
int pageSize = 5; -- 每页显示数量
int startRow = (curPage - 1) * pageSize; -- 当前页, 记录开始的位置(行数)计算
int totalSize = select count(*) from products; -- 记录总数量
int totalPage = Math.ceil(totalSize * 1.0 / pageSize); -- 总页数
```



![1568446878222](mysql01.assets/1568446878222.png)

# 第6章 SQL备份与恢复

## 1 SQL备份

数据库的备份是指将数据库转换成对应的sql文件

### MySQL命令备份

数据库导出sql脚本的格式：

```sql
mysqldump  -u用户名 -p密码 数据库名>生成的脚本文件路径
```

例如:

```sql
mysqldump  -uroot  -proot day04>d:\day03.sql
```

以上备份数据库的命令中需要用户名和密码，即表明该命令要在用户没有登录的情况下使用

### 可视化工具备份

选中数据库，右键 ”备份/导出” ， 指定导出路径，保存成.sql文件即可。

![1568446901050](mysql01.assets/1568446901050.png)

![1568446914500](mysql01.assets/1568446914500.png)

## 2 SQL恢复

数据库的恢复指的是使用备份产生的sql文件恢复数据库，即将sql文件中的sql语句执行就可以恢复数据库内容。

### MySQL命令恢复

使用数据库命令备份的时候只是备份了数据库内容，产生的sql文件中没有创建数据库的sql语句，在恢复数据库之前需要自己动手创建数据库。

- 在数据库外恢复
  - **格式:**`mysql -uroot -p密码 数据库名 < 文件路径`
  - 例如:`mysql -uroot -proot day03<d:\day03.sql`
- 在数据库内恢复
  - **格式:**`source SQL脚本路径`
  - 例如:`source d:\day03.sql`
  - 注意:使用这种方式恢复数据，首先要登录数据库.

### 可视化工具恢复

数据库列表区域右键“从SQL转储文件导入数据库”， 指定要执行的SQL文件，执行即可。

![1568446926522](mysql01.assets/1568446926522.png)

![1568446936757](mysql01.assets/1568446936757.png)

![1568446962902](mysql01.assets/1568446962902.png)



1 安装问题解决

```
1 关闭服务	任务管理器 结束任务

2 卸载mysql	2.1 控制面板	2.2 360卸载	2.3 腾讯电脑管家

3 删除mysql对应的data目录(必须)

4 重启电脑
```

2  有问题

```
1 自己(看笔记 看视频 百度搜索)
2 求身边人
3 求老师
```

