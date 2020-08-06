package com.itheima.mm.service;

import com.itheima.mm.pojo.Company;

import java.util.List;

/**
 * @author ：seanyang
 * @date ：Created in 2019/11/5
 * @description ：公司业务接口
 * @version: 1.0
 */
public interface CompanyService {
	/**
	 * 获取所有公司
	 * @return
	 */
	List<Company> findListAll();
}
