package com.itheima.mm.service;

import com.itheima.mm.pojo.Industry;

import java.util.List;

/**
 * @author ：seanyang
 * @date ：Created in 2019/8/15
 * @description ：企业行业方向业务接口
 * @version: 1.0
 */
public interface IndustryService {
	/**
	 * 获取所有的行业方向数据
	 * @return
	 */
	List<Industry> findListAll();
}
