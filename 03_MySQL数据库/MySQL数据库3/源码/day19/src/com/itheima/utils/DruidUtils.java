package com.itheima.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 *  阿里巴巴的连接池 Druid 德鲁伊连接池
 *  目的: 从连接池中取出连接
 *  实现步骤:
 *    1: 导入jar包
 *    2: 数据库连接4大信息
 *      配置文件  properties
 *        名字任意,存储位置任意
 *
 *    3: 创建DataSource接口实现类
 *      实现类的方法 getConnection()获取连接
 *
 *
 */
public class DruidUtils {

    //创建DataSource接口变量
    private static DataSource dataSource ;

    static {
        try {
            //自己读取配置文件
            InputStream inputStream = DruidUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            //流中的数据,存储在集合中
            Properties properties = new Properties();
            properties.load(inputStream);
            //3: 创建DataSource接口实现类
            //设计模式,工厂设计模式,通过工厂类获取对象
            //工厂类获取 接口 DataSource对象
            //DruidDataSourceFactory方法.createDataSource()
            //日历类; Calendar c = Calendar.getInstance();
             dataSource = DruidDataSourceFactory.createDataSource(properties);
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
        //定义方法,获取连接对象
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    //定义方法,获取DataSource接口实现类
    public static DataSource getDataSource(){
        return dataSource;
    }
}
