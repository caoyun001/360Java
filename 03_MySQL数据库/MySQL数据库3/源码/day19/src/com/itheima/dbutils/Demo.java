package com.itheima.dbutils;

/**
 *  Apache开发工具类 dbutils
 *  JDBC开发模版形式的代码,6步骤固定,代码量重复
 *  dbutils简化JDBC而来,SQL语句还要自己来
 *
 *  常用的类:
 *    DBUtils类:
 *      释放资源的方法,处理异常
 *            closeQuietly()
 *
 *     commitAndCloseQuietly() 提交事务,并关闭
 *     rollbackAndCloseQuietly() 回滚,并关闭
 *
 *     QueryRunner类: 执行SQL语句的核心类
 *       update() 执行 insert,update,delete,返回操作成功的行数
 *       query() 执行  select
 */
public class Demo {
}
