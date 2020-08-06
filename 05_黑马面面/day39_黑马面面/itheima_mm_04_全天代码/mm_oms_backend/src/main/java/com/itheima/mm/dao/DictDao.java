package com.itheima.mm.dao;

import com.itheima.mm.pojo.Dict;

import java.util.List;

/**
 * @author ：seanyang
 * @date ：Created in 2019/8/15
 * @description ：数据字典Dao
 * @version: 1.0
 */
public interface DictDao {
	/**
	 * 根据数据标签，提前数据
	 * 0 省份
	 * 1 城市
	 * @return
	 */
	List<Dict> selectListByType(Integer typeId);
}
