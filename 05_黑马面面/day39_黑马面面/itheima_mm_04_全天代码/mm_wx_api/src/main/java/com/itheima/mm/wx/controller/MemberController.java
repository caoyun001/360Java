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

import static com.itheima.mm.common.GlobalConst.HEADER_AUTHORIZATION;

/**
 * @author ：seanyang
 * @date ：Created in 2019/11/8
 * @description ：会员控制器
 * @version: 1.0
 */
@HmComponent
@Slf4j
public class MemberController extends BaseController {

	@HmSetter("wxMemberService")
	private WxMemberService wxMemberService;

	@HmRequestMapping("/member/login")
	public void login (HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		try{
		    // 接收客户数据
			Map<String,String> data = parseJSON2Object(request, HashMap.class);
			log.debug("data:{}",data);
			String code = data.get("code");  // 登录凭证
			String jmData = data.get("encryptedData");  // 加密数据
			String iv = data.get("iv"); // 解密参数
			// 根据微信工具类获取openId和SessionKey
			JSONObject jsonObject = WxUtil.get(code);
			log.debug("微信工具类获取openId和SessionKey jsonObject:{}",jsonObject);
			String openId = jsonObject.getString("openid");  // openId在后续作为类似web-jessionid来使用
			String sessionKey = jsonObject.getString("session_key");
			// 根据Service提供的方法完成登录与注册
			WxMember wxMember = wxMemberService.findWxMemberByOpenId(openId);
			if(wxMember == null){
				// 如果数据库中有没有该用户数据（登录），需要解密数据，并添加到数据库（注册）
				// sessionkey解密用户数据，利用微信工具类
				JSONObject userInfo = WxUtil.getUserInfo(jmData, sessionKey, iv);
				log.debug("微信工具类解密用户数据 userInfo:{}",userInfo);
				wxMember = new WxMember();
				wxMember.setCountry(userInfo.getString("country"));
				wxMember.setNickName(userInfo.getString("nickName"));
				wxMember.setAvatarUrl(userInfo.getString("avatarUrl"));
				wxMember.setGender(userInfo.getString("gender"));
				wxMember.setCity(userInfo.getString("city"));
				wxMember.setProvince(userInfo.getString("province"));
				wxMember.setCountry(userInfo.getString("country"));
				wxMember.setLanguage(userInfo.getString("language"));
				wxMember.setOpenId(userInfo.getString("openId"));
				wxMember.setUnionId(userInfo.getString("unionId"));
				wxMember.setCreateTime(DateUtils.parseDate2String(new Date()));
				log.debug("调用Service,保存会员数据 wxMember:{}",wxMember);
				wxMemberService.regWxMember(wxMember);
			}
			// ....
			Map map = new HashMap();
			map.put("token",openId);
			map.put("userInfo",wxMember);
			printResult(response,new Result(true,"登录成功",map));
		}catch(Exception e){
		    e.printStackTrace();
		    printResult(response,new Result(false,"登录失败"));
		}
	}

	@HmRequestMapping("/member/updateCityCourse")
	public void updateCityCourse (HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		try{
		    // 获取客户数据
			Map data = parseJSON2Object(request,HashMap.class);
			log.debug("data:{}",data);
			// 从请求头中获取Token值
			String openId = request.getHeader(HEADER_AUTHORIZATION);
			data.put("openId",openId);
			// 调用Service,传递Map(openId,cityID,subjectID),完成学科及城市ID的更新
			wxMemberService.updateCityCourse(data);
			printResult(response,new Result(true,"设置成功"));
		}catch(RuntimeException re){
		    re.printStackTrace();
		    printResult(response,new Result(false,"设置失败"));
		}
	}
}
