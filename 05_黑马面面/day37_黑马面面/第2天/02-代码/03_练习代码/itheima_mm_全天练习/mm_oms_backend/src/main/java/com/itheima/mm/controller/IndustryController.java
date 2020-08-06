package com.itheima.mm.controller;

import com.itheima.framework.annotation.HmComponent;
import com.itheima.framework.annotation.HmRequestMapping;
import com.itheima.framework.annotation.HmSetter;
import com.itheima.mm.base.BaseController;
import com.itheima.mm.entity.Result;
import com.itheima.mm.pojo.Industry;
import com.itheima.mm.service.IndustryService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author ：seanyang
 * @date ：Created in 2019/11/5
 * @description ：行业方向控制器
 * @version: 1.0
 */
@HmComponent
public class IndustryController extends BaseController {

	@HmSetter("industryService")
	private IndustryService industryService;
	/**
	 * 获取全部行业方向
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@HmRequestMapping("/industry/findListAll")
	public void findListAll (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
		    // 调用Service,获取列表
			List<Industry> industryList = industryService.findListAll();
			// 响应JSON
			printResult(response,new Result(true,"获取成功",industryList));
		}catch(RuntimeException re){
		    re.printStackTrace();
		    printResult(response,new Result(false,"获取失败"));
		}
	}
}
