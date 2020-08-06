package com.itheima.mm.wx.dao;

import com.itheima.mm.pojo.WxMember;

import java.util.Map;

/**
 * @author ：seanyang
 * @date ：Created in 2019/11/8
 * @description ：微信会员Dao接口
 * @version: 1.0
 */
public interface WxMemberDao {

	/**
	 * 添加会员
	 * @param wxMember
	 */
	void insertWxMember(WxMember wxMember);

	/**
	 * 根据OpenId获取微信会员
	 * @param openId
	 * @return
	 */
	WxMember selectWxMemberByOpenId(String openId);

	/**
	 * 更新城市及学科ID
	 * @param data
	 */
	void updateCityCourse(Map data);
}
