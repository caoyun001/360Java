package com.itheima.mm.base;

import com.itheima.mm.database.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

/**
 * @author ：seanyang
 * @date ：Created in 2019/8/11
 * @description ：业务基类
 * 提供所有业务类公共方法
 * @version: 1.0
 */
public class BaseService {
	public SqlSession getSession(){
		return SqlSessionUtils.openSession();
	}
	protected <T> T getDao(SqlSession sqlSession,Class<T> tClass){
		if(sqlSession == null){
			return null;
		}
		return sqlSession.getMapper(tClass);
	}

	protected void commitAndCloseSession(SqlSession sqlSession){
		if(sqlSession!=null) {
			sqlSession.commit();
			sqlSession.close();
		}
	}
	protected void rollbackAndCloseSession(SqlSession sqlSession){
		if(sqlSession!=null) {
			sqlSession.rollback();
			sqlSession.close();
		}
	}
	protected void closeSession(SqlSession sqlSession){
		if(sqlSession!=null) sqlSession.close();
	}
}
