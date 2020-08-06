package com.itheima.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * SPring框架的核心配置文件(注解配置)
 */
@Configuration
//开启SpringIOC容器的注解扫描
@ComponentScan({"com.itheima"})
public class SpringConfig {
    //配置数据源
    @Bean("druidDataSource")
    public DataSource createDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        //配置相关信息(驱动, url, 用户名, 密码)
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/ssm_lx");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("root");

        return druidDataSource;
    }
    //配置SqlSessionFactory对象
    //参数DataSource dataSource , 会自动从 SpringIOC容器中找 配置的Bean对象
    @Bean
    public SqlSessionFactoryBean createSqlSessionFactoryBean(@Qualifier("druidDataSource") DataSource dataSource){
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        //配置相关信息(数据源, pojo的别名)
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage("com.itheima.pojo");

        return sqlSessionFactoryBean;
    }

    //dao 扫描器
    @Bean
    public MapperScannerConfigurer createMapperScannerConfigurer(){
        MapperScannerConfigurer scannerConfigurer = new MapperScannerConfigurer();
        //配置相关信息(指定扫描的dao层的路径)
        scannerConfigurer.setBasePackage("com.itheima.dao");

        return scannerConfigurer;
    }
}
