package com.itheima.mm.controller;

import com.itheima.framework.annotation.HmComponent;
import com.itheima.framework.annotation.HmRequestMapping;
import com.itheima.framework.annotation.HmSetter;
import com.itheima.mm.base.BaseController;
import com.itheima.mm.base.BaseService;
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
import java.util.Date;
import java.util.List;

/**
 * @author ：seanyang
 * @date ：Created in 2019/8/11
 * @description ：学科控制器
 * @version: 1.0
 */
@HmComponent
@Slf4j
public class CourseController extends BaseController {
	@HmSetter("courseService")
	private CourseService courseService;
	/**
	 * 添加学科
	 * 获取表单数据
	 * 初始化表单数据
	 * 调用Service完成业务
	 * 返回JSON到前端
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@HmRequestMapping("/course/add")
	public void addCourse (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			Course course = parseJSON2Object(request,Course.class);
			log.info("addCourse,{}",course);
			// 设置创建日期
			course.setCreateDate(DateUtils.parseDate2String(new Date()));
			// 获取当前用户的用户信息
			User user = getSessionUser(request,  GlobalConst.SESSION_KEY_USER);
			if (user != null) {
				course.setUserId(user.getId());
			} else {
				// 调试时，默认是管理员
				course.setUserId(1);
			}
			courseService.addCourse(course);
			printResult(response,new Result(true,"添加学科成功"));
		}catch(RuntimeException e){
			log.error("addCourse",e);
			printResult(response,new Result(false,"添加学科失败,"+e.getMessage()));
		}
	}

	/**
	 * 分页获取学科列表
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@HmRequestMapping("/course/findListByPage")
	public void findListByPage (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QueryPageBean pageBean = parseJSON2Object(request,QueryPageBean.class);
		if (pageBean == null){
			pageBean = new QueryPageBean();
			pageBean.setCurrentPage(1);
			pageBean.setPageSize(10);
		}

		log.info("questionList pageBean:{}",pageBean);
		PageResult pageResult = courseService.findListByPage(pageBean);
		printResult(response,new Result(true,"获取学科列表成功",pageResult));
	}

	@HmRequestMapping("/course/update")
	public void updateCourse(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		try{
			Course course = parseJSON2Object(request,Course.class);
			courseService.updateCourse(course);
			printResult(response,new Result(true,"更新学科成功"));
		}catch(RuntimeException e){
			log.error("updateCourse",e);
			printResult(response,new Result(false,e.getMessage()));
		}
	}
	@HmRequestMapping("/course/delete")
	public void deleteCourse(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		try{
			String courseId = request.getParameter("courseId");
			courseService.deleteCourse(Integer.parseInt(courseId));
			printResult(response,new Result(true,"删除学科成功"));
		}catch(RuntimeException e){
			log.error("deleteCourse",e);
			printResult(response,new Result(false,e.getMessage()));
		}
	}

	@HmRequestMapping("/course/findListAll")
	public void findListForQuestion (HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		try{
		    // 无需处理前端数据
			// 调用Service
			List<Course> courseList = courseService.findListAll();
			// 响应JSON
			printResult(response,new Result(true,"查询成功",courseList));
		}catch(RuntimeException re){
		    re.printStackTrace();
		    printResult(response,new Result(false,"查询失败"));
		}
	}
}
