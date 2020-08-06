package com.itheima.mm.wx.service.impl;

import com.itheima.framework.annotation.HmComponent;
import com.itheima.mm.database.MmDaoException;
import com.itheima.mm.database.SqlSessionUtils;
import com.itheima.mm.pojo.WxMember;
import com.itheima.mm.wx.dao.WxMemberDao;
import com.itheima.mm.wx.service.WxMemberService;
import org.apache.ibatis.session.SqlSession;

import java.util.Map;

/**
 * @author ：seanyang
 * @date ：Created in 2019/8/17
 * @description ：会员业务实现类
 * @version: 1.0
 */
@HmComponent("wxMemberService")
public class WxMemberServiceImpl implements WxMemberService {

	@Override
	public WxMember findByOpenId(String openId) {
		SqlSession sqlSession = SqlSessionUtils.openSession();
		WxMemberDao wxMemberDao = sqlSession.getMapper(WxMemberDao.class);
		WxMember wxMember = wxMemberDao.selectByOpenId(openId);
		sqlSession.close();
		return wxMember;
	}

	@Override
	public void add(WxMember wxMember) {
		SqlSession sqlSession = SqlSessionUtils.openSession();
		WxMemberDao wxMemberDao = sqlSession.getMapper(WxMemberDao.class);
		Integer result = wxMemberDao.addWxMemeber(wxMember);
		sqlSession.commit();
		sqlSession.close();
		if (result == 0){
			throw new MmDaoException("添加会员失败");
		}
	}

	@Override
	public void updateCityCourse(Map updateData) {
		SqlSession sqlSession = SqlSessionUtils.openSession();
		WxMemberDao wxMemberDao = sqlSession.getMapper(WxMemberDao.class);
		Integer result = wxMemberDao.updateCityAndCourse(updateData);
		sqlSession.commit();
		sqlSession.close();
		if (result == 0){
			throw new MmDaoException("更新数据失败");
		}
	}
	@Override
	public Map<String, Object> findMemberCenter(String openId) {
		SqlSession sqlSession = SqlSessionUtils.openSession();
		WxMemberDao wxMemberDao = sqlSession.getMapper(WxMemberDao.class);
		// 获取个人中心数据
		Map<String,Object> mapData = wxMemberDao.selectCenter(openId);
		String categoryTitle = "";
		// 获取查询类型名称
		if(mapData !=null && mapData.containsKey("categoryID")) {
			categoryTitle = wxMemberDao.selectCategoryNameByQueryParams(mapData);
		}
		mapData.put("categoryTitle",categoryTitle);
		sqlSession.close();
		return mapData;
	}

}
