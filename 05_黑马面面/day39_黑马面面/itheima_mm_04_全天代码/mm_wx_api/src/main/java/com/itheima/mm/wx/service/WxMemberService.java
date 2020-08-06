package com.itheima.mm.wx.service;

import com.itheima.mm.pojo.WxMember;

import java.util.Map;

/**
 * @author ：seanyang
 * @date ：Created in 2019/11/8
 * @description ：微信会员业务接口
 * @version: 1.0
 */
public interface WxMemberService {
	/**
	 * 根据OpenId,获取会员信息
	 * @param openId
	 * @return
	 */
	WxMember findWxMemberByOpenId(String openId);

	/**
	 * 注册会员
	 * @param wxMember
	 */
	void regWxMember(WxMember wxMember);

	/**
	 * 根据openId,更新城市及学科ID
	 * @param data
	 */
	void updateCityCourse(Map data);
}
