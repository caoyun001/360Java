package com.itheima.mm.service;

import com.itheima.mm.pojo.Industry;

import java.util.List;

/**
 * @author ：seanyang
 * @date ：Created in 2019/11/5
 * @description ：行业方向业务接口
 * @version: 1.0
 */
public interface IndustryService {
	/**
	 * 获取所有数据
	 * @return
	 */
	List<Industry> findListAll();
}
