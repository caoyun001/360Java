package com.itheima.mm.wx.dao;

import com.itheima.mm.pojo.Dict;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ：seanyang
 * @date ：Created in 2019/11/8
 * @description ：数据字典Dao接口
 * @version: 1.0
 */
public interface DictDao {
	/**
	 * 根据城市名称获取城市对象
	 * @param cityName 城市名称
	 * @return
	 */
	Dict selectByCityName(String cityName);

	/**
	 * 根据Fs值获取城市列表
	 * @param fs
	 * @return
	 */
	List<Dict> selectCityListByFs(@Param("fs") Integer fs);
}
