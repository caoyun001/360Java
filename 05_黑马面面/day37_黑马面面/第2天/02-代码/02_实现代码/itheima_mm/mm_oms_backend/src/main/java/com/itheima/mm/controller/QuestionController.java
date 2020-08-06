package com.itheima.mm.controller;

import com.itheima.framework.annotation.HmComponent;
import com.itheima.framework.annotation.HmRequestMapping;
import com.itheima.framework.annotation.HmSetter;
import com.itheima.mm.base.BaseController;
import com.itheima.mm.common.GlobalConst;
import com.itheima.mm.entity.QueryPageBean;
import com.itheima.mm.entity.Result;
import com.itheima.mm.pojo.Question;
import com.itheima.mm.pojo.User;
import com.itheima.mm.service.QuestionService;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ：seanyang
 * @date ：Created in 2019/8/12
 * @description ：题目控制器
 * @version: 1.0
 */
@HmComponent
@Slf4j
public class QuestionController extends BaseController {

	@HmSetter("questionService")
	private QuestionService questionService;

	/**
	 * 获取题目列表
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@HmRequestMapping("/question/findListByPage")
	public void questionList (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QueryPageBean pageBean = parseJSON2Object(request, QueryPageBean.class);
		if (pageBean == null){
			pageBean = new QueryPageBean();
			pageBean.setCurrentPage(1);
			pageBean.setPageSize(10);
		}
		log.info("questionList pageBean:{}",pageBean);
		printResult(response,new Result(true,"获取题目列表成功",questionService.findByPage(pageBean)));
	}

	/**
	 * 添加基础题目
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@HmRequestMapping("/question/addOrUpdate")
	public void addOrUpdate(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		// 获取表单数据
		try{
			Question question = parseJSON2Object(request,Question.class);
			User user = getSessionUser(request, GlobalConst.SESSION_KEY_USER);
			// 从上下文获取用户ID，调试默认为1
			question.setUserId(user!=null?user.getId():1);
			// 保存数据
			questionService.addOrUpdate(question);
			printResult(response,new Result(true,"更新成功"));
		}catch(RuntimeException e){
			log.error("addOrUpdate",e);
			printResult(response,new Result(false,e.getMessage()));
		}
	}
}