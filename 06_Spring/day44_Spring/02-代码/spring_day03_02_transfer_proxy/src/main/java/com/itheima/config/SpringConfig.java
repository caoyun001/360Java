package com.itheima.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

/**
 * SPring框架的核心配置文件(注解配置)
 */
@Configuration
//开启SpringIOC容器的注解扫描
@ComponentScan({"com.itheima"})
@Import({JDBCConfig.class, MybatisConfig.class})
public class SpringConfig {


}
