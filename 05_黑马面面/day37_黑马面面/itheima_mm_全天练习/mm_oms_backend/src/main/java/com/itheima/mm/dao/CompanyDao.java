package com.itheima.mm.dao;

import com.itheima.mm.pojo.Company;

import java.util.List;
import java.util.Map;

/**
 * @author ：seanyang
 * @date ：Created in 2019/11/5
 * @description ：公司Dao接口
 * @version: 1.0
 */
public interface CompanyDao {
	/**
	 * 获取全部公司信息
	 * @return
	 */
	List<Company> selectListAll();

	/**
	 * 更新公司信息
	 * @param company
	 */
	void updateCompanyCity(Company company);

	/**
	 * 根据公司ID ,删除公司行业关系
	 * @param id
	 */
	void deleteCompanyIndustryByCompanyId(Integer id);

	/**
	 * 新增公司行业关系
	 * @param map
	 */
	void addCompanyIndustry(Map map);



}
