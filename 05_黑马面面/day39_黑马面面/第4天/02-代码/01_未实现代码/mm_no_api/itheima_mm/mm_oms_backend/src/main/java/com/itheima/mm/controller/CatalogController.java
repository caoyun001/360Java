package com.itheima.mm.controller;

import com.itheima.framework.annotation.HmComponent;
import com.itheima.framework.annotation.HmRequestMapping;
import com.itheima.framework.annotation.HmSetter;
import com.itheima.mm.base.BaseController;
import com.itheima.mm.common.GlobalConst;
import com.itheima.mm.entity.PageResult;
import com.itheima.mm.entity.QueryPageBean;
import com.itheima.mm.entity.Result;
import com.itheima.mm.pojo.Catalog;
import com.itheima.mm.pojo.User;
import com.itheima.mm.service.CatalogService;
import com.itheima.mm.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @author ：seanyang
 * @date ：Created in 2019/8/13
 * @description ：学科目录控制器
 * @version: 1.0
 */
@HmComponent
@Slf4j
public class CatalogController extends BaseController {

	@HmSetter("catalogService")
	private CatalogService catalogService;

	/**
	 * 添加学科目录
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@HmRequestMapping("/catalog/add")
	public void addCatalog (HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		try{
			Catalog catalog  = parseJSON2Object(request, Catalog.class);
			// 初始化用户ID，状态和创建时间
			User user = getSessionUser(request, GlobalConst.SESSION_KEY_USER);
			if(user != null){
				catalog.setUserId(user.getId());
			}else{
				catalog.setUserId(1);
			}
			catalog.setStatus(0);
			catalog.setCreateDate(DateUtils.parseDate2String(new Date()));
			catalogService.addCatalog(catalog);
			printResult(response,new Result(true,"添加学科目录成功"));
		}catch(RuntimeException e){
			log.error("addCatalog",e);
			printResult(response,new Result(false,e.getMessage()));
		}
	}

	/**
	 * 分页获取学科目录列表
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@HmRequestMapping("/catalog/findListByPage")
	public void findListByPage (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QueryPageBean pageBean = parseJSON2Object(request, QueryPageBean.class);
		if (pageBean == null){
			pageBean = new QueryPageBean();
			pageBean.setCurrentPage(1);
			pageBean.setPageSize(10);
		}
		log.info("findListByPage questionList pageBean:{}",pageBean);
		PageResult pageResult = catalogService.findListByPage(pageBean);
		printResult(response,new Result(true,"获取学科目录列表成功",pageResult));
	}

	/**
	 * 删除学科目录
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@HmRequestMapping("/catalog/delete")
	public void deleteCatalog (HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		try{
			String catalogId = request.getParameter("catalogId");
			log.info("deleteCatalog id:",catalogId);
			catalogService.deleteCatalog(Integer.parseInt(catalogId));
			printResult(response,new Result(true,"删除学科目录成功"));
		}catch(RuntimeException e){
			log.error("deleteCatalog",e);
			printResult(response,new Result(false,e.getMessage()));
		}
	}
}
