package com.itheima.mm.controller;

import com.itheima.framework.annotation.HmComponent;
import com.itheima.framework.annotation.HmRequestMapping;
import com.itheima.framework.annotation.HmSetter;
import com.itheima.mm.base.BaseController;
import com.itheima.mm.entity.Result;
import com.itheima.mm.pojo.Dict;
import com.itheima.mm.service.DictService;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author ：seanyang
 * @date ：Created in 2019/8/15
 * @description ：数据字典控制器
 * @version: 1.0
 */
@HmComponent
@Slf4j
public class DictController extends BaseController {

	@HmSetter("dictService")
	private DictService dictService;

	@HmRequestMapping("/dict/findListByType")
	public void findListByType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String typeId = request.getParameter("typeId");
			log.info("Dict findListByType typeId:{}",typeId);
			List<Dict> dictList = dictService.selectListByType(Integer.parseInt(typeId));
			printResult(response,new Result(true,"获取成功",dictList));
		}catch(RuntimeException e){
		    log.error("Dict findListByType",e);
		    printResult(response,new Result(false,"获取失败"));
		}
	}
}
