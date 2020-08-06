package com.itheima.mm.wx.dao;

import com.itheima.mm.pojo.WxMember;

import java.util.Map;

/**
 * @author ：seanyang
 * @date ：Created in 2019/8/17
 * @description ：微信用户Dao
 * @version: 1.0
 */
public interface WxMemberDao {
	/**
	 * 根据openId，获取用户信息
	 * @param openId
	 * @return
	 */
	WxMember selectByOpenId(String openId);
	/**
	 * 添加会员
	 * @param wxMember
	 */
	Integer addWxMemeber(WxMember wxMember);

	/**
	 * 更新城市和学科方向
	 * @param updateData
	 */
	Integer updateCityAndCourse(Map updateData);

	/**
	 * 更新成员最后做题信息
	 * @param dataParams
	 */
	void updateMemberLastAnswer(Map<String,Object> dataParams);

	/**
	 * 获取会员中心数据
	 * @param openId
	 * @return
	 */
	Map<String,Object> selectCenter(String openId);

	/**
	 * 根据参数，获取名称
	 * @param queryParams
	 * @return
	 */
	String selectCategoryNameByQueryParams(Map<String,Object> queryParams);

}
