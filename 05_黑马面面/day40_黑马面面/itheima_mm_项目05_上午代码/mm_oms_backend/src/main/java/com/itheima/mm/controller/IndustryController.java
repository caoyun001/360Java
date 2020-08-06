package com.itheima.mm.controller;

import com.itheima.framework.annotation.HmComponent;
import com.itheima.framework.annotation.HmRequestMapping;
import com.itheima.framework.annotation.HmSetter;
import com.itheima.mm.base.BaseController;
import com.itheima.mm.entity.Result;
import com.itheima.mm.pojo.Industry;
import com.itheima.mm.service.IndustryService;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author ：seanyang
 * @date ：Created in 2019/8/15
 * @description ：企业行业行业方向控制器
 * @version: 1.0
 */
@HmComponent
@Slf4j
public class IndustryController extends BaseController {

	@HmSetter("industryService")
	private IndustryService industryService;

	@HmRequestMapping("/industry/findListAll")
	public void findListAll (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			List<Industry> industryList = industryService.findListAll();
			printResult(response,new Result(true,"获取成功",industryList));
		}catch(RuntimeException e){
		    log.error("IndustryController findListAll",e);
		    printResult(response,new Result(false,"获取失败"));
		}
	}
}
