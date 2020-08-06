package com.itheima.dbutils;

import com.itheima.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

/**
 *  使用DBUtils工具类,实现数据的 insert,update,delete
 *  核心类 QueryRunner执行SQL语句
 *  1: 创建对象
 *    无参数构造,直接new
 *    QueryRunner(DataSource ds) 传递DataSource接口实现类的对象
 *    c3p0,druid  自己从连接池中取连接
 *
 *  2: 调用方法update
 *   int  update(Connection conn, String sql, Object... params)
 *      conn连接对象
 *      sql SQL语句
 *      params SQL语句中的问号占位符
 *
       Execute an SQL INSERT, UPDATE, or DELETE query.
 */
public class DBUtilsDemo {
    public static void main(String[] args) throws SQLException {
        delete();
    }
    /**
     * 实现删除数据
     */
    public static void delete()throws SQLException{
        //创建QueryRunner的对象
        QueryRunner qr = new QueryRunner();
        //删除的SQL
        String sql = "delete from product where pid = ?";
        //参数,直接传递主键
        int row = qr.update(DruidUtils.getConnection(), sql, 14);
        System.out.println(row);
    }

    /**
     *  实现更新数据
     */
    public static void update()throws SQLException{
        //创建QueryRunner的对象
        QueryRunner qr = new QueryRunner();
        //拼写update语句
        String sql = "update product set pname = ? , price = ? ,category_id = ? where pid = ?";
        //问号中参数,定义在数组中
        Object[] params = {"老年机",199,"c001",15};
        //update方法执行SQL
        int row = qr.update(DruidUtils.getConnection(), sql, params);
        System.out.println(row);
    }


    /**
     *  实现数据的添加
     */
    public static void insert()throws SQLException{
        //创建QueryRunner的对象
        QueryRunner qr = new QueryRunner();
        //拼写添加数据的SQL
        String sql = "insert into product values(?,?,?,?)";
        //执行update方法
        //传递数据库连接对象,c3p0,druid
        //SQL语句中参数,存储在数组,代码可读性,维护性提高
        Object[] params = {null,"8848手机",1898,"c001"};
        int row = qr.update(DruidUtils.getConnection(),sql,params);
        System.out.println(row);
    }
}
