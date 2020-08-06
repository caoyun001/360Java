package com.itheima.mm.controller;

import com.itheima.framework.annotation.HmComponent;
import com.itheima.framework.annotation.HmRequestMapping;
import com.itheima.framework.annotation.HmSetter;
import com.itheima.mm.base.BaseController;
import com.itheima.mm.common.GlobalConst;
import com.itheima.mm.entity.Result;
import com.itheima.mm.pojo.ReviewLog;
import com.itheima.mm.pojo.User;
import com.itheima.mm.security.Hmthority;
import com.itheima.mm.service.ReviewLogService;
import com.itheima.mm.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @author ：seanyang
 * @date ：Created in 2019/11/7
 * @description ：审核日志控制器
 * @version: 1.0
 */
@HmComponent
@Slf4j
public class ReviewLogController extends BaseController {

	@HmSetter("reviewLogService")
	private ReviewLogService reviewLogService;

	@Hmthority("QUESTION_REVIEW_UPDATE")
	@HmRequestMapping("/review/add")
	public void addReview (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
		    // 获取数据
			ReviewLog reviewLog = parseJSON2Object(request,ReviewLog.class);
			log.debug("reviewLog:{}",reviewLog);
			// 获取用户
			User user = getSessionUser(request, GlobalConst.SESSION_KEY_USER);
			// 初始化数据
			reviewLog.setUserId(user!=null?user.getId():1);
			reviewLog.setCreateDate(DateUtils.parseDate2String(new Date()));
			// 调用Service
			log.debug("调用Service:reviewLog:{}",reviewLog);
			reviewLogService.addReviewLog(reviewLog);
			// 成功
			printResult(response,new Result(true,"ok"));
		}catch(RuntimeException re){
		    re.printStackTrace();
		    printResult(response,new Result(false,"error"));
		}
	}
}
