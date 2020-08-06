package com.itheima.mm.controller;

/**
 * @author ：seanyang
 * @date ：Created in 2019/11/4
 * @description ：学科控制器
 * @version: 1.0
 */

import com.itheima.framework.annotation.HmComponent;
import com.itheima.framework.annotation.HmRequestMapping;
import com.itheima.framework.annotation.HmSetter;
import com.itheima.mm.base.BaseController;
import com.itheima.mm.common.GlobalConst;
import com.itheima.mm.entity.PageResult;
import com.itheima.mm.entity.QueryPageBean;
import com.itheima.mm.entity.Result;
import com.itheima.mm.pojo.Course;
import com.itheima.mm.pojo.User;
import com.itheima.mm.service.CourseService;
import com.itheima.mm.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@HmComponent
@Slf4j
public class CourseController extends BaseController {

	@HmSetter("courseService")
	private CourseService courseService;

	/**
	 * 完成学科添加
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@HmRequestMapping("/course/add")
	public void addCourse (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 调用Service
		try{
			// 封装客户数据到POJO对象
			Course course = parseJSON2Object(request,Course.class);
			log.debug("表单数据:{}",course);
			// 初始化表单数据
			course.setCreateDate(DateUtils.parseDate2String(new Date()));
			// 获取用户ID
			//User user = (User)request.getSession(false).getAttribute(GlobalConst.SESSION_KEY_USER);
			User user = getSessionUser(request,GlobalConst.SESSION_KEY_USER);
			// 为了调试,如果无Session,无用户，默认用户ID为1
			course.setUserId(user!=null?user.getId():1);
			log.debug("调用Service，完成业务 course:{}",course);
			// 调用Service完成业务（假设成功）
			courseService.addCourse(course);
			// 响应JSON
			printResult(response,new Result(true,"新增成功"));
		}catch (RuntimeException e){
			log.error("",e);
			e.printStackTrace();
			printResult(response,new Result(false,"新增学科失败:"+e.getMessage()));
		}
	}

	@HmRequestMapping("/course/findListByPage")
	public void findListByPage (HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		try{
		    // 获取查询参数
			QueryPageBean queryPageBean = parseJSON2Object(request,QueryPageBean.class);
			log.debug("queryPageBean:{}",queryPageBean);
			if(queryPageBean == null){
				queryPageBean = new QueryPageBean();
				queryPageBean.setCurrentPage(1);
				queryPageBean.setPageSize(10);
			}
			// 调用Service，获取PageResult
			//PageResult  pageResult = new PageResult(33L,new ArrayList());
			PageResult pageResult = courseService.findListByPage(queryPageBean);
			// 响应JSON
			printResult(response,new Result(true,"获取成功",pageResult));
		}catch(RuntimeException re){
		    re.printStackTrace();
			log.error("",re);
			re.printStackTrace();
			printResult(response,new Result(false,"获取学科列表失败:"+re.getMessage()));
		}
	}

	@HmRequestMapping("/course/update")
	public void update (HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		try{
		    // 获取表单数据
			// 封装客户数据到POJO对象(id,name,isShow)
			Course course = parseJSON2Object(request,Course.class);
			log.debug("表单数据:{}",course);
			// 调用Service
			courseService.updateCourse(course);
			// 返回JSON
			printResult(response,new Result(true,"更新成功"));
		}catch(RuntimeException re){
		    re.printStackTrace();
		    printResult(response,new Result(false,"更新失败"));
		}
	}

}
