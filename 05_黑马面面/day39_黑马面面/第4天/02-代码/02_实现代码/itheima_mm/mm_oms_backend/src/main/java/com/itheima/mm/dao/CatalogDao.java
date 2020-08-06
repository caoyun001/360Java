package com.itheima.mm.dao;

import com.itheima.mm.entity.QueryPageBean;
import com.itheima.mm.pojo.Catalog;

import java.util.List;

/**
 * @author ：seanyang
 * @date ：Created in 2019/8/13
 * @description ：学科目录Dao接口
 * @version: 1.0
 */
public interface CatalogDao {

	/**
	 * 添加学科目录
	 * @param catalog
	 * @return
	 */
	Integer addCatalog(Catalog catalog);

	/**
	 * 统计学科目录记录总数
	 * @param queryPageBean
	 * @return
	 */
	Long selectTotalCount(QueryPageBean queryPageBean);

	/**
	 * 分页获取学科目录
	 * @param queryPageBean
	 * @return
	 */
	List<Catalog> selectListByPage(QueryPageBean queryPageBean);

	/**
	 * 删除学科目录
	 * @param id
	 * @return
	 */
	Integer deleteCatalog(Integer id);

	/**
	 * 根据目录ID，获取目录信息
	 * @param catalogId
	 * @return
	 */
	Catalog selectByIdForQuestion(Integer catalogId);


}
