/*
   MySQL隔离级别设置为最低
   read uncommitted 发生脏读
     一个事务,看到了另一个没有提交事务 
     
     
   隔离级别设置到 read committed  脏读不会出现
   但是会出现 重复读
   
   一个事务,看到了另一个事务已经提交的数据 update
   
   
   隔离级别设置到 repeatable read  脏读,重复读 看不到
   虚读: 一个事务,看到了另一个事务已经提交的数据 insert 语句
   
   
*/
SET SESSION TRANSACTION ISOLATION LEVEL 
