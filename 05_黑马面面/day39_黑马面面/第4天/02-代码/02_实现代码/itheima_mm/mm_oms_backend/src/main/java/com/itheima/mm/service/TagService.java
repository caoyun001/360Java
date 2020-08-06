package com.itheima.mm.service;

import com.itheima.mm.entity.PageResult;
import com.itheima.mm.entity.QueryPageBean;
import com.itheima.mm.pojo.Tag;

/**
 * @author ：seanyang
 * @date ：Created in 2019/8/13
 * @description ：学科标签业务接口
 * @version: 1.0
 */
public interface TagService {
	/**
	 * 添加标签
	 * @param tag
	 */
	void addTag(Tag tag);

	/**
	 * 分页获取学科标签列表
	 * @param queryPageBean
	 * @return
	 */
	PageResult findListByPage(QueryPageBean queryPageBean);

	/**
	 * 删除标签
	 * @param id
	 */
	void deleteTag(Integer id);
}
