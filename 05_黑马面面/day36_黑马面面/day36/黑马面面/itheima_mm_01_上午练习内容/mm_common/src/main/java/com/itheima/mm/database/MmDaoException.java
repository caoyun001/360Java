package com.itheima.mm.database;

/**
 * @author ：seanyang
 * @date ：Created in 2019/8/14
 * @description ：数据库异常父类
 * @version: 1.0
 */
public class MmDaoException extends RuntimeException {
	public MmDaoException(String message){
		super(message);
	}
}
