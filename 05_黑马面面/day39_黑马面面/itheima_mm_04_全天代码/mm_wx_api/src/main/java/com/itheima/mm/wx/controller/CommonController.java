package com.itheima.mm.wx.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
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
import java.util.*;

/**
 * @author ：seanyang
 * @date ：Created in 2019/11/8
 * @description ：公共接口
 * @version: 1.0
 */
@HmComponent
@Slf4j
public class CommonController extends BaseController {

	static {
		// 初始化Jedis连接池
		JedisUtils.init(ResourceBundle.getBundle("jedis"));
	}

	@HmSetter("commonService")
	private CommonService commonService;

	@HmRequestMapping("/common/citys")
	public void getCitys (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
		    // 接收客户数据
			Map data = parseJSON2Object(request, HashMap.class);
			log.debug("data:{}",data);
			// 通过地址信息，解析出城市名称
			String cityName = LocationUtil.parseLocation((String)data.get("location"));
			// 调用Service，根据城市名称，获取城市信息（id,title）
			Dict city= commonService.findDictByCityName(cityName);
			// 调用Service, 根据fs的值，获取城市列表
			List<Dict> cityList = commonService.findDictListByFs((Integer) data.get("fs"));
			// 返回数据 location:{} citys:[]
			//　模拟实现
			Map map = new HashMap();
			map.put("location",city);
			map.put("citys",cityList);
			printResult(response,new Result(true,"获取成功",map));
		}catch(Exception e){
		    e.printStackTrace();
		    printResult(response,new Result(false,"获取失败"));
		}
	}

	@HmRequestMapping("/common/courseList")
	public void getCourseList (HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		try{
		    if(JedisUtils.isUsed()){
		    	log.debug("redis可用....");
		    	// 当redis可用时，获取Jedis对象
				Jedis jedis = JedisUtils.getResource();
				// 判断redis中是否有存储过学科列表数据
				String jsonString = jedis.get(GlobalConst.REDIS_KEY_WX_COURSE_LIST);
				if(jsonString == null || jsonString.length() == 0){
					log.debug("redis可用....Redis中无数据...");
					// 调用Service，获取数据，存入redis(以JSON字符串存入)
					List<Course> courseList = commonService.findCourseList();
					// [{},{},{}]
					jedis.set(GlobalConst.REDIS_KEY_WX_COURSE_LIST,JSON.toJSON(courseList).toString());
					// 返回JSON到客户端
					printResult(response,new Result(true,"获取成功",courseList));
				}else{
					log.debug("redis可用....Redis中有数据...(JSON String)");
					printResult(response,new Result(true,"获取成功",JSON.parse(jsonString)));
				}
				jedis.close();
			}else{
				// 调用Service
				List<Course> courseList = commonService.findCourseList();
				// 返回JSON
				printResult(response,new Result(true,"获取成功",courseList));
			}

		}catch(RuntimeException re){
		    re.printStackTrace();
		    printResult(response,new Result(false,"获取失败"));
		}
	}
}
