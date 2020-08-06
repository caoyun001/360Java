package com.itheima.mm.wx.service.impl;

import com.itheima.framework.annotation.HmComponent;
import com.itheima.mm.database.MmDaoException;
import com.itheima.mm.database.SqlSessionUtils;
import com.itheima.mm.pojo.WxMember;
import com.itheima.mm.wx.dao.WxMemberDao;
import com.itheima.mm.wx.service.WxMemberService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

import java.util.Map;

/**
 * @author ：seanyang
 * @date ：Created in 2019/11/8
 * @description ：
 * @version: 1.0
 */
@HmComponent("wxMemberService")
@Slf4j
public class WxMemberServiceImpl implements WxMemberService {
	@Override
	public WxMember findWxMemberByOpenId(String openId) {
		SqlSession sqlSession = SqlSessionUtils.openSession();
		WxMemberDao wxMemberDao = sqlSession.getMapper(WxMemberDao.class);
		WxMember wxMember = wxMemberDao.selectWxMemberByOpenId(openId);
		sqlSession.close();
		return wxMember;
	}

	@Override
	public void regWxMember(WxMember wxMember) {
		SqlSession sqlSession = SqlSessionUtils.openSession();
		try{
			WxMemberDao wxMemberDao = sqlSession.getMapper(WxMemberDao.class);
			wxMemberDao.insertWxMember(wxMember);
			sqlSession.commit();
			sqlSession.close();
		}catch(MmDaoException e){
			sqlSession.rollback();
			sqlSession.close();
			e.printStackTrace();
		    log.error(e.getMessage());
		    throw  new MmDaoException(e.getMessage());
		}
	}

	@Override
	public void updateCityCourse(Map data) {
		log.debug("data:{}",data);
		// 调用Dao
		SqlSession sqlSession = SqlSessionUtils.openSession();
		WxMemberDao wxMemberDao = sqlSession.getMapper(WxMemberDao.class);
		wxMemberDao.updateCityCourse(data);
		sqlSession.commit();
		sqlSession.close();
	}
}
