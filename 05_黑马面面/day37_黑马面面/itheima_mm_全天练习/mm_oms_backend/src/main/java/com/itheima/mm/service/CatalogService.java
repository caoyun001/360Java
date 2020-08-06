package com.itheima.mm.service;

import com.itheima.mm.entity.PageResult;
import com.itheima.mm.entity.QueryPageBean;
import com.itheima.mm.pojo.Catalog;

/**
 * @author ：seanyang
 * @date ：Created in 2019/8/13
 * @description ：学科标签业务接口
 * @version: 1.0
 */
public interface CatalogService {

	/**
	 * 添加学科目录
	 * @param catalog
	 * @return
	 */
	void addCatalog(Catalog catalog);

	/**
	 * 分页获取学科列表
	 * @param queryPageBean
	 * @return
	 */
	PageResult findListByPage(QueryPageBean queryPageBean);

	/**
	 * 删除学科目录
	 * @param id
	 * @return
	 */
	void deleteCatalog(Integer id);

}
