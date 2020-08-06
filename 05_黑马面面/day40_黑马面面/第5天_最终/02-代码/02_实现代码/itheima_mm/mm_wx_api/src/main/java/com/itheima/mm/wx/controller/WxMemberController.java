package com.itheima.mm.wx.controller;

import com.alibaba.fastjson.JSONObject;
import com.itheima.framework.annotation.HmComponent;
import com.itheima.framework.annotation.HmRequestMapping;
import com.itheima.framework.annotation.HmSetter;
import com.itheima.mm.base.BaseController;
import com.itheima.mm.entity.Result;
import com.itheima.mm.pojo.WxMember;
import com.itheima.mm.utils.DateUtils;
import com.itheima.mm.wx.service.WxMemberService;
import com.itheima.mm.wx.utils.WxUtil;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：seanyang
 * @date ：Created in 2019/8/17
 * @description ：会员控制器
 * @version: 1.0
 */
@HmComponent
@Slf4j
public class WxMemberController extends BaseController {

	@HmSetter("wxMemberService")
	private WxMemberService wxMemberService;

	/**
	 * 用户授权登录，未查询到添加用户信息到数据库
	 * @param req
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@HmRequestMapping("/member/login")
	public void login (HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		try {
			HashMap<String,String> mapData = parseJSON2Object(req,HashMap.class);
			//获取参数
			String encryptedData = mapData.get("encryptedData");
			String iv = mapData.get("iv");
			String code = mapData.get("code");
			//获取微信用户信息
			JSONObject wx = WxUtil.get(code);
			String sessionKey = wx.getString("session_key");
			String openId = wx.getString("openid");
			//查询微信用户表，看看是否已经存在，存在就直接返回微信用户信息，不存在就新增后再返回微信用户信息
			//Object o = wus.dtl(openId);
			log.debug("openId:{},mapData:{}",openId,mapData);
			// 模拟实现
			//openId = "oiu565SzoTCXctUD0y6Ll-RQOkFg";
			WxMember wxUser = wxMemberService.findByOpenId(openId);
			if (wxUser == null) {
				log.debug("注册会员......");
				//解析微信用户信息
				JSONObject userJson = WxUtil.getUserInfo(encryptedData, sessionKey, iv);
				wxUser = new WxMember();
				wxUser.setNickName(userJson.getString("nickName"));
				wxUser.setAvatarUrl(userJson.getString("avatarUrl"));
				wxUser.setGender(userJson.getString("gender"));
				wxUser.setCity(userJson.getString("city"));
				wxUser.setProvince(userJson.getString("province"));
				wxUser.setCountry(userJson.getString("country"));
				wxUser.setLanguage(userJson.getString("language"));
				wxUser.setOpenId(userJson.getString("openId"));
				wxUser.setUnionId(userJson.getString("unionId"));
				wxUser.setCreateTime(DateUtils.parseDate2String(new Date()));
				//调用微信用户服务，执行新增操作
				wxMemberService.add(wxUser);
			}
			//返回微信用户信息
			String wxUid = wxUser.getOpenId();
			Map map = new HashMap();
			map.put("token", wxUid);
			map.put("userInfo", wxUser);
			printResult(response,map);
		} catch (RuntimeException e) {
			//访问失败返回{}
			log.error("login",e);
			printResult(response,new Result(false,"登录失败"));
		}
	}

	/**
	 * 更新用户城市及科学方向
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@HmRequestMapping("/member/setCityCourse")
	public void updateCityCourse (HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		try{
			HashMap<String,String> mapData = parseJSON2Object(request,HashMap.class);
			String openId = getHeaderAuthorization(request);
			mapData.put("openId",openId);
			log.debug("updateCityCourse mapData:{}",mapData);
			wxMemberService.updateCityCourse(mapData);
			printResult(response,new Result(true,"更新成功"));
		}catch(RuntimeException e){
			log.error("updateCityCourse",e);
			printResult(response,new Result(false,"更新失败"));
		}
	}

	@HmRequestMapping("/member/center")
	public void getUserCenter (HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		try{
			String openId = getHeaderAuthorization(request);
			log.info("getUserCenter openId:{}",openId);
			Map resultMap = wxMemberService.findMemberCenter(openId);
			printResult(response,new Result(true,"获取成功",resultMap));
		}catch(RuntimeException e){
			log.error("getUserCenter",e);
			printResult(response,new Result(false,"获取失败"));
		}
	}
}
