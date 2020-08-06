package com.itheima.mm.wx.service;

import com.itheima.mm.pojo.Course;
import com.itheima.mm.pojo.Dict;

import java.util.List;

/**
 * @author ：seanyang
 * @date ：Created in 2019/8/17
 * @description ：公共业务接口
 * @version: 1.0
 */
public interface CommonService {
	/**
	 * 获取城市列表
	 * @param tag
	 * @return
	 */
	public List<Dict> getCityList(Integer tag);

	/**
	 * 根据地理信息，获取某一具体城市
	 * @param cityName
	 * @return
	 */
	public Dict getCityInfoByName(String cityName);

	/**
	 * 获取学科列表
	 * @return
	 */
	public List<Course> getCourseList();

}
