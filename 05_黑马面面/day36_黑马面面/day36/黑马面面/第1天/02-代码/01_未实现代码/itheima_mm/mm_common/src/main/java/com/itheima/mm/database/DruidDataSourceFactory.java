package com.itheima.mm.database;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.datasource.pooled.PooledDataSourceFactory;

/**
 * @author ：seanyang
 * @date ：Created in 2019/8/11
 * @description ：Druid数据源工厂
 * @version: 1.0
 */
public class DruidDataSourceFactory extends PooledDataSourceFactory {
	public DruidDataSourceFactory(){
		this.dataSource = new DruidDataSource();
	}
}
