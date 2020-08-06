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
 * @date ：Created in 2019/8/18
 * @description ：分类控制器
 * 获取题库类型，对应首页列表分类显示
 * @version: 1.0
 */
@HmComponent
@Slf4j
public class CategoryController extends BaseController {

	@HmSetter("categoryService")
	private CategoryService categoryService;

	@HmSetter("wxMemberService")
	private WxMemberService wxMemberService;

	/**
	 * 获取题目不同分类列表
	 * 按技术-1(按当前学科目录)、按企业-2、按方向（企业方向）-3
	 * 刷题-101,、错题本-201、我的练习202、收藏题目-203都是获取同类型列表
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@HmRequestMapping("/category/list")
	public void getCategoryList (HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		try{
		    Map<String,Object> paramData = parseJSON2Object(request, HashMap.class);
		    String openId = getHeaderAuthorization(request);
			// 根据openID,获取用户ID
			paramData.put("openId",openId);
			WxMember wxMember = wxMemberService.findByOpenId(openId);
			paramData.put("memberId",wxMember.getId());
			// 根据用户属性，获取用户选定的行业方向及城市
			paramData.put("courseId",wxMember.getCourseId());
			paramData.put("cityId",wxMember.getCityId());
		    log.info("paramData:{}",paramData);
			List<Map> mapList = categoryService.findCategory(paramData);
			printResult(response,new Result(true,"获取成功",mapList));
		}catch(RuntimeException e){
		    log.error("getCategoryList",e);
		    printResult(response,new Result(false,"获取失败"));
		}
	}
	/**
	 * 获取题目分类某一分类下的题目列表
	 * 按技术-1(按当前学科目录)、按企业-2、按方向（企业方向）-3
	 * 刷题-101,、错题本-201、我的练习202、收藏题目-203都是获取同类型列表
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@HmRequestMapping("/category/question/list")
	public void getCategoryQuestionList (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			Map<String,Object> paramData = parseJSON2Object(request, HashMap.class);
			String openId = getHeaderAuthorization(request);
			paramData.put("openId",openId);
			// 根据openID,获取用户ID
			WxMember wxMember = wxMemberService.findByOpenId(openId);
			paramData.put("memberId",wxMember.getId());
			// 根据用户属性，获取用户选定的行业方向及城市
			paramData.put("courseId",wxMember.getCourseId());
			paramData.put("cityId",wxMember.getCityId());
			log.info("paramData:{}",paramData);
			Map resultMap = categoryService.findCategoryQuestion(paramData);
			printResult(response,new Result(true,"获取成功",resultMap));
		}catch(RuntimeException e){
			log.error("getCategoryQuestionList",e);
			printResult(response,new Result(false,"获取失败"));
		}
	}

	/**
	 * 提交题目
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@HmRequestMapping("/category/question/commit")
	public void commitQuestion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{

			Map<String,Object> paramData = parseJSON2Object(request, HashMap.class);
			log.info("commitQuestion paramData:{}",paramData);
			String openId = getHeaderAuthorization(request);
			paramData.put("openId",openId);
			// 根据openID,获取用户ID
			WxMember wxMember = wxMemberService.findByOpenId(openId);
			paramData.put("memberId",wxMember.getId());
			log.debug("paramData:{}",paramData);
			// 调用Service保存答案
			categoryService.commitQuestion(paramData);
			printResult(response,new Result(true,"提交成功"));
		}catch(RuntimeException e){
			log.error("commitQuestion",e);
			printResult(response,new Result(false,e.getMessage()));
		}
	}

	/**
	 * 收藏题目
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@HmRequestMapping("/category/question/favorite")
	public void favoriteQuestion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			Map<String,Object> paramData = parseJSON2Object(request, HashMap.class);
			log.debug("favoriteQuestion paramData:{}",paramData);
			String openId = getHeaderAuthorization(request);
			paramData.put("openId",openId);
			// 根据openID,获取用户ID
			WxMember wxMember = wxMemberService.findByOpenId(openId);
			paramData.put("memberId",wxMember.getId());
			log.info("paramData:{}",paramData);
			categoryService.favoriteQuestion(paramData);
			printResult(response,new Result(true,"收藏成功"));
		}catch(RuntimeException e){
			log.error("favoriteQuestion",e);
			printResult(response,new Result(false,e.getMessage()));
		}
	}


}
