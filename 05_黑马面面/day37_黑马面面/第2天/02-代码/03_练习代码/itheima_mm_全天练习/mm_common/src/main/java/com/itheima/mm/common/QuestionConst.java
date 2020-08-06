package com.itheima.mm.common;

import lombok.Data;
import lombok.Getter;

/**
 * @author ：seanyang
 * @date ：Created in 2019/8/15
 * @description ：题目常量定义
 * @version: 1.0
 */
public class QuestionConst {
	public  enum Status{
		PRE_PUBLISH,		// 待发布 0
		PUBLISHED,		    // 已发布 1
		PUBLISHED_OFFLINE   // 已下架 2
	}
	public enum ReviewStatus{
		PRE_REVIEW,			// 待审核 0
		REVIEWED,			// 已审核 1
		REJECT_REVIEW		// 已拒绝 2
	}
	public enum ClassicStatus{
		CLASSIC_STATUS_NO,  // 0
		CLASSIC_STATUS_YES  // 1
	}
	// 题目标签状态
	public enum TagStatus{
		ENABLE, // 0 启用
		DISABLE // 1 禁用
	}
	public enum CatalogStatus{
		ENABLE, // 0 启用
		DISABLE // 1 禁用
	}
	// 题目分类的种类
	public enum CategoryKind{
		CATALOG(1,"按技术"),
		COMPANY(2,"按企业"),
		INDUSTRY(3,"按方向");
		@Getter
		private int id;
		private String remark;
		private CategoryKind(Integer id,String remark){
				this.id = id;
				this.remark = remark;
		}
	}
	// 题目分类的类型
	public enum CategoryType{
		EXERCISE(101,"刷题"),
		USER_WRONG(201,"错题本"),
		USER_EXERCISE(202,"我的练习"),
		USER_COLLECT(203,"收藏题库");
		@Getter
		private int id;
		private String remark;
		private CategoryType(Integer id,String remark){
			this.id = id;
			this.remark = remark;
		}
	}
	//做题标记 0 正确 1 错误 2 理想 3 不理想
	public enum AnswerTag{
		PERFECT,
		WRONG,
		GOOD,
		BAD
	}
	public enum Type{
		SINGLE(1,"单选题"),
		MULTIPLE(2,"多选题"),
		SIMPLE(5,"简单题"),
		JUDGMENT(3,"判断题");
		@Getter
		private int id;
		private String remark;
		private Type(int id,String remark){
			this.id = id;
			this.remark = remark;
		}
	}

}
