package com.itheima.mm.wx.service;

import com.itheima.mm.pojo.Course;
import com.itheima.mm.pojo.Dict;

import java.util.List;

/**
 * @author ：seanyang
 * @date ：Created in 2019/11/8
 * @description ：公共业务接口
 * @version: 1.0
 */
public interface CommonService {
	/**
	 * 获取学科列表
	 * @return
	 */
	List<Course> findCourseList();

	/**
	 * 根据城市名称，获取城市信息
	 * @param cityName
	 * @return
	 */
	Dict findDictByCityName(String cityName);

	/**
	 * 根据Fs值，获取城市列表
	 * @param fs （0-全部，1-首页推荐）
	 * @return
	 */
	List<Dict> findDictListByFs(Integer fs);
}
