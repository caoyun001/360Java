package com.itheima.mm.controller;

import com.itheima.framework.annotation.HmComponent;
import com.itheima.framework.annotation.HmRequestMapping;
import com.itheima.framework.annotation.HmSetter;
import com.itheima.mm.base.BaseController;
import com.itheima.mm.common.GlobalConst;
import com.itheima.mm.entity.Result;
import com.itheima.mm.pojo.ReviewLog;
import com.itheima.mm.pojo.User;
import com.itheima.mm.security.HmAuthority;
import com.itheima.mm.service.ReviewLogService;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ：seanyang
 * @date ：Created in 2019/8/16
 * @description ：题目审核控制器
 * @version: 1.0
 */
@HmComponent
@Slf4j
public class ReviewLogController extends BaseController {

	@HmSetter("reviewLogService")
	private ReviewLogService reviewLogService;

	/**
	 * 增加审核
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@HmAuthority("QUESTION_REVIEW_UPDATE")
	@HmRequestMapping("/review/add")
	public void addReview (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			ReviewLog reviewLog = parseJSON2Object(request, ReviewLog.class);
			log.info("addReview reviewLog:{}",reviewLog);
			// 获取用户信息
			User user = getSessionUser(request, GlobalConst.SESSION_KEY_USER);
			// 从上下文获取用户ID，调试默认为1
			reviewLog.setUserId(user!=null?user.getId():1);
			reviewLogService.addReviewLog(reviewLog);
			printResult(response,new Result(true,"操作成功"));
		}catch(	RuntimeException e){
		    log.error("addReview",e);
		    printResult(response,new Result(false,"操作失败"));
		}
	}
}
