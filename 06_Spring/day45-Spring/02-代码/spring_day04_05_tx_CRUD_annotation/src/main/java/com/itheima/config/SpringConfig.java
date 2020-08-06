package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Spring框架的核心配置文件(注解版)
 */
@Configuration
@Import({JDBCConfig.class, MybatisConfig.class, TransactionConfig.class})
//开启SpringIOC的注解扫描
@ComponentScan("com.itheima")
//开启SpringAOP的注解扫描
@EnableAspectJAutoProxy
//开启Spring事务的注解扫描
@EnableTransactionManagement
public class SpringConfig {
}
