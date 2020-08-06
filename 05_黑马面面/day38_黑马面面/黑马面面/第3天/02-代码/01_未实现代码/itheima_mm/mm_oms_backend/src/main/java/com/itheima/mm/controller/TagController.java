package com.itheima.mm.controller;

import com.itheima.framework.annotation.HmComponent;
import com.itheima.framework.annotation.HmRequestMapping;
import com.itheima.framework.annotation.HmSetter;
import com.itheima.mm.base.BaseController;
import com.itheima.mm.common.GlobalConst;
import com.itheima.mm.common.QuestionConst;
import com.itheima.mm.entity.PageResult;
import com.itheima.mm.entity.QueryPageBean;
import com.itheima.mm.entity.Result;
import com.itheima.mm.pojo.Tag;
import com.itheima.mm.pojo.User;
import com.itheima.mm.service.TagService;
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
 * @description ：学科标签控制器
 * @version: 1.0
 */
@HmComponent
@Slf4j
public class TagController extends BaseController {

	@HmSetter("tagService")
	private TagService tagService;

	/**
	 * 添加学科标签
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@HmRequestMapping("/tag/add")
	public void addTag (HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		try{
			Tag tag  = parseJSON2Object(request, Tag.class);
			// 初始化用户ID，状态和创建时间
			User user = getSessionUser(request, GlobalConst.SESSION_KEY_USER);
			// catalog.setUserId( user.getId());
			if (user != null) {
				tag.setUserId(user.getId());
			} else {
				// 调试时，默认是管理员
				tag.setUserId(1);
			}
			tag.setStatus(QuestionConst.TagStatus.ENABLE.ordinal());
			tag.setCreateDate(DateUtils.parseDate2String(new Date()));
			tagService.addTag(tag);
			printResult(response,new Result(true,"添加学科标签成功"));
		}catch(RuntimeException e){
			log.error("addTag",e);
			printResult(response,new Result(false,"添加学科标签失败，"+e.getMessage()));
		}
	}

	/**
	 * 分页获取学科标签列表
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@HmRequestMapping("/tag/findListByPage")
	public void findListByPage (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QueryPageBean pageBean = parseJSON2Object(request, QueryPageBean.class);
		if (pageBean == null){
			pageBean = new QueryPageBean();
			pageBean.setCurrentPage(1);
			pageBean.setPageSize(10);
		}
		// 获取当前用户的学科方向
		//pageBean.getQueryParams().put("courseId",request.getParameter("courseId"));
		log.info("questionList pageBean:{}",pageBean);
		PageResult pageResult = tagService.findListByPage(pageBean);
		printResult(response,new Result(true,"获取学科标签列表成功",pageResult));
	}

	/**
	 * 删除学科标签
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@HmRequestMapping("/tag/delete")
	public void deleteTag (HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		try{
			String tagId = request.getParameter("tagId");
			log.info("deleteTag id:{}",tagId);
			tagService.deleteTag(Integer.parseInt(tagId));
			printResult(response,new Result(true,"删除学科标签成功"));
		}catch(RuntimeException e){
			log.error("deleteTag",e);
			printResult(response,new Result(false,"删除学科标签失败,"+e.getMessage()));
		}
	}
}
