package com.itheima.mm.wx.dao;

import com.itheima.mm.pojo.Dict;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ：seanyang
 * @date ：Created in 2019/8/17
 * @description ：
 * @version: 1.0
 */
public interface DictDao {
	/**
	 * 根据标志获取城市列表
	 * 1 推荐列表
	 * 0 全部列表
	 * @param tag
	 * @return
	 */
	List<Dict> selectCityListByTag(@Param("tag") Integer tag);

	/**
	 * 根据城市名称，获取城市信息
	 * @param cityName
	 * @return
	 */
	Dict selectByCityName(String cityName);
}
