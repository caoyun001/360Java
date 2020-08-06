package com.itheima.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

public class MybatisConfig {

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
