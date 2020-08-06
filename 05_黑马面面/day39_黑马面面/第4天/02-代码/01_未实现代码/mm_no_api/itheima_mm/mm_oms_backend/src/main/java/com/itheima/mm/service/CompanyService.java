package com.itheima.mm.service;

import com.itheima.mm.pojo.Company;

import java.util.List;

/**
 * @author ：seanyang
 * @date ：Created in 2019/8/15
 * @description ：公司业务接口
 * @version: 1.0
 */
public interface CompanyService {
	/**
	 * 获取全部公司列表
	 * 包含城市、方向列表
	 * @return
	 */
	List<Company> findListAll();
}
