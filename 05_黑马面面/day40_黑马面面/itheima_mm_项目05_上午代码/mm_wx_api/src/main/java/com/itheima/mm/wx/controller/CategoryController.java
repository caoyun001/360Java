package com.itheima.mm.wx.controller;

import com.itheima.framework.annotation.HmComponent;
import com.itheima.framework.annotation.HmRequestMapping;
import com.itheima.framework.annotation.HmSetter;
import com.itheima.mm.base.BaseController;
import com.itheima.mm.entity.Result;
import com.itheima.mm.pojo.WxMember;
import com.itheima.mm.wx.service.CategoryService;
import com.itheima.mm.wx.service.WxMemberService;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：seanyang
 * @date ：Created in 2019/11/10
 * @description ：题目分类控制器
 * @version: 1.0
 */
@HmComponent
@Slf4j
public class CategoryController extends BaseController {

	@HmSetter("wxMemberService")
	private WxMemberService wxMemberService;

	@HmSetter("categoryService")
	private CategoryService categoryService;

	/**
	 * 题目分类列表
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@HmRequestMapping("/category/list")
	public void getCategoryList (HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		try{
		    // 获取请求数据
			Map<String,Object> mapData = parseJSON2Object(request, HashMap.class);
			log.debug("map:{}",mapData);
			// 从header中获取OpenId，并放入客户端参数容器
			String openId = getHeaderAuthorization(request);
			mapData.put("openId",openId);
			// 根据openId,获取会员，同时获取memberId,cityId,courseId
			WxMember wxMember = wxMemberService.findByOpenId(openId);
			mapData.put("memberId",wxMember.getId());
			mapData.put("courseId",wxMember.getCourseId());
			mapData.put("cityId",wxMember.getCityId());
			log.debug("调用Service-mapData:{}",mapData);
			// 调用Service获取题目分类列表
			List<Map> mapList = categoryService.findCategoryList(mapData);
			// 返回JSON
			printResult(response,new Result(true,"ok",mapList));
		}catch(Exception e){
		    e.printStackTrace();
		    printResult(response,new Result(false,"error"));
		}
	}

	@HmRequestMapping("/category/question/list")
	public void getCategoryQuestionList(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		try{
		    // 获取前端参数数据
			Map<String,Object> mapData = parseJSON2Object(request,HashMap.class);
			// 根据openId,获取会员对象
			String openId = getHeaderAuthorization(request);
			WxMember wxMember = wxMemberService.findByOpenId(openId);
			// 把会员ID、学科ID、城市ID设置参数容器
			mapData.put("memberId",wxMember.getId());
			mapData.put("courseId",wxMember.getCourseId());
			mapData.put("cityId",wxMember.getCityId());
			log.debug("调用Service，获取分类基本信息及分类下的题目列表，参数:{}",mapData);
			Map<String,Object> resultMap = categoryService.findCategoryQuestionList(mapData);
			// 返回JSON
			printResult(response,new Result(true,"ok",resultMap));
		}catch(RuntimeException re){
		    re.printStackTrace();
		    printResult(response,new Result(false,"error"));
		}
	}
}
