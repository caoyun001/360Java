package com.itheima.mm.wx.service;

import com.itheima.mm.pojo.WxMember;

import java.util.Map;

/**
 * @author ：seanyang
 * @date ：Created in 2019/8/17
 * @description ：会员业务接口
 * @version: 1.0
 */
public interface WxMemberService {
	/**
	 * 根据openId,获取会员信息
	 * @param openId
	 * @return
	 */
	WxMember findByOpenId(String openId);

	/**
	 * 添加会员
	 * @param wxMember
	 * @return
	 */
	void add(WxMember wxMember);

	/**
	 * 更新城市及学科方向
	 * @param updateData
	 */
	void updateCityCourse(Map updateData);

}
