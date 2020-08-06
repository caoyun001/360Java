package com.itheima.mm.wx.controller;

import com.alibaba.fastjson.JSON;
import com.itheima.framework.annotation.HmComponent;
import com.itheima.framework.annotation.HmRequestMapping;
import com.itheima.framework.annotation.HmSetter;
import com.itheima.mm.base.BaseController;
import com.itheima.mm.common.GlobalConst;
import com.itheima.mm.entity.Result;
import com.itheima.mm.pojo.Course;
import com.itheima.mm.pojo.Dict;
import com.itheima.mm.utils.JedisUtils;
import com.itheima.mm.wx.service.CommonService;
import com.itheima.mm.wx.utils.LocationUtil;
import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * @author ：seanyang
 * @date ：Created in 2019/8/17
 * @description ：公共控制器
 * @version: 1.0
 */
@HmComponent
@Slf4j
public class CommonController extends BaseController {
	static {
		JedisUtils.init(ResourceBundle.getBundle("jedis"));
	}

	@HmSetter("commonService")
	private CommonService commonService;

	/**
	 * 根据参数获取数据
	 * fs 0 全部 1 首屏推荐
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@HmRequestMapping("/common/citys")
	public void getCitys (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			HashMap<String,Object> mapData = parseJSON2Object(request,HashMap.class);
			log.info("mapData:{}",mapData);
			String cityName = LocationUtil.parseLocation((String) mapData.get("location"));
			Dict city  = commonService.getCityInfoByName(cityName);
			List<Dict> cityList = commonService.getCityList((Integer)mapData.get("fs"));
			Map result = new HashMap();
			result.put("location",city);
			result.put("citys",cityList);
			// 需要特别注意，这里直接返回了result对象到客户端，是为了与前端代码一致。
			printResult(response,result);
		}catch(RuntimeException e){
			log.error("getCitys",e);
		   printResult(response,new Result(false,"获取失败"));
		}
	}
	/**
	 * 获取学科列表
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@HmRequestMapping("/common/courseList")
	public void getCourseList (HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		try{

			if(JedisUtils.isUsed()){
				Jedis jedis = JedisUtils.getResource();
				// 如果redis可用
				String jsonCourseList = jedis.get(GlobalConst.REDIS_KEY_WX_COURSE_LIST);
				if(jsonCourseList!=null && jsonCourseList.length() >0 ){
					log.debug("redis 获取数据");
					jedis.close();
					printResult(response, JSON.parse(jsonCourseList));
					return;
				}
				List<Course> courseList = commonService.getCourseList();
				log.debug("redis 设置数据");

				jedis.set(GlobalConst.REDIS_KEY_WX_COURSE_LIST,JSON.toJSONString(courseList));
				jedis.close();
				printResult(response,courseList);
			}else{
				List<Course> courseList = commonService.getCourseList();
				printResult(response,courseList);
			}
		}catch(RuntimeException e){
			log.error("getCourseList",e);
			printResult(response,new Result(false,"获取失败"));
		}
	}
}
