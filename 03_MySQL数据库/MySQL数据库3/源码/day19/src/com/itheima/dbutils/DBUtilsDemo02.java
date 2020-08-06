package com.itheima.dbutils;

import com.itheima.domain.Product;
import com.itheima.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 *  实现查询
 *  1: QueryRunner构造方法
 *    QueryRunner(DataSource ds) 传递接口实现类
 *    接口的实现类,数据源,连接池
 *    QueryRunner自动从连接池取出连接使用
 *
 *  2: JavaBean对象
 *    一个类包含私有成员变量,包含get/set方法,包含无参数构造
 *    称为JavaBean对象
 *
 *   QueryRunner类的方法 query执行查询 Select语句
 *   query(String sql, ResultSetHandler<T> rsh, Object... params)
 *   参数 sql :传递执行的select语句
 *   参数 rsh: 是接口ResultSetHandler的实现类对象
 *      ResultSetHandler:表示的是查询后的结果集
 *      接口实现类:
 *        BeanHandler :  查询数据表的第一行数据,存储到JavaBean对象
 *        BeanListHandler : 查询数据表,数据的每一行存储到JavaBean对象,多个JavaBean对象,存储到List集合
 *        ColumnListHandler : 查询数据表中的一个列的数据,存储到List集合
 *        ScalarHandler : 适合单值查询,结果集只有一个值 count(*)
 *
 *
 *   参数params: SQL语句中问号占位符参数
 *
 */
public class DBUtilsDemo02 {
    public static void main(String[] args) throws SQLException {
        scalarHandler();
    }
    /**
     * ScalarHandler : 适合单值查询,结果集只有一个值 count(*)
     * 查询的结果集只有一个值,例如聚合函数  avg max min  sum
     * select pname from product where pid = 1;
     */
    public static void scalarHandler()throws SQLException{
        //创建QueryRunner对象,构造方法,传递DataSource接口实现类
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        //查询表中共有多少条数据
        String sql = "select count(pid) from product";
        Long object = qr.query(sql,new ScalarHandler<Long>());
        System.out.println(object);
    }

    /**
     * ColumnListHandler : 查询数据表中的一个列的数据,存储到List集合
     */
    public static void columnListHandler()throws SQLException{
        //创建QueryRunner对象,构造方法,传递DataSource接口实现类
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        //拼写查询语句
        String sql = "select * from product ";
        //执行查询语句,传递的对象是ColumnListHandler,要一个列的数据
        //ColumnListHandler(String columnName)传递参数,是列名
        List<Object> list = qr.query(sql,new ColumnListHandler<Object>("pname"));
        for(Object o : list){
            System.out.println(o);
        }

    }

    /**
     * BeanListHandler : 查询数据表,数据的每一行存储到JavaBean对象,
     * 多个JavaBean对象,存储到List集合
     * 查询不到数据,集合是存在的,长度=0
     */
    public static void  beanListHandler()throws SQLException{
        //创建QueryRunner对象,构造方法,传递DataSource接口实现类
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        //拼写查询语句
        String sql = "select * from product ";
        // 方法query执行SQL语句,传递结果集处理对象 BeanListHandler(传递JavaBean类的class对象)
        List<Product> list = qr.query(sql,new BeanListHandler<Product>(Product.class));
        for(Product product :list){
            System.out.println(product);
        }
    }

    /**
     *  BeanHandler :  查询数据表的第一行数据,存储到JavaBean对象
     *  JavaBean对象是 Product
     */
    public static void  beanHandler()throws SQLException{
        //创建QueryRunner类对象,有参数构造方法,传递DataSource接口实现类
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        //拼写查询语句
        String sql = "select * from product ";
        //方法query执行SQL语句
        //传递结果集BeanHandler(Class<T> type) 传递JavaBean类的class文件对象
        Product product =  qr.query(sql,new BeanHandler<Product>(Product.class));
        System.out.println(product);
    }
}
