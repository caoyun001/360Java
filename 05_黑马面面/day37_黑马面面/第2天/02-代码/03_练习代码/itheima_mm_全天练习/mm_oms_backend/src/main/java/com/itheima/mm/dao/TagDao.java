package com.itheima.mm.dao;

import com.itheima.mm.entity.QueryPageBean;
import com.itheima.mm.pojo.Tag;

import java.util.List;
import java.util.Map;

/**
 * @author ：seanyang
 * @date ：Created in 2019/8/13
 * @description ：学科标签Dao接口
 * @version: 1.0
 */
public interface TagDao {
	/**
	 * 添加标签
	 * @param tag
	 * @return
	 */
	public Integer addTag(Tag tag);

	/**
	 * 分页获取标签列表
	 * @param queryPage
	 * @return
	 */
	List<Tag> selectListByPage(QueryPageBean queryPage);

	/**
	 * 统计标签记录总数
	 * @param queryPageBean
	 * @return
	 */
	Long selectTotalCount(QueryPageBean queryPageBean);

	/**
	 * 删除标签
	 * @param id
	 * @return
	 */
	public Integer deleteTag(Integer id);

	/**
	 * 根据学科ID，获取标签列表
	 * @param id
	 * @return
	 */
	List<Tag> selectTagListByCourseId(Integer id);

	/**
	 * 根据题目ID，删除题目标签关系
	 * @param questionId
	 */
	void deleteTagListByQuestionId(Integer questionId);

	/**
	 * 新增题目标签关系
	 * @param map（questionId,tagId）
	 */
	void addQuestionTag(Map map);

}
