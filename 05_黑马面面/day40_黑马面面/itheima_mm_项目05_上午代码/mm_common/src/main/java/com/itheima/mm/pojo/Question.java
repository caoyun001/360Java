package com.itheima.mm.pojo;

import com.itheima.mm.common.QuestionConst;
import lombok.Data;

import java.util.List;

/**
 * @author ：seanyang
 * @date ：Created in 2019/8/12
 * @description : 题目POJO类
 * 扩展字段为非数据库表对应字段，用于前端页面显示使用
 * @version: 1.0
 */
@Data
public class Question {
	  private Integer id;
	  private String number;
	  private String subject;
	  private Integer type;
	  private Integer difficulty;
	  private String analysis;
	  private String analysisVideo;
	  private String remark;
	  private Integer isClassic;
	  private Integer status;
	  private Integer reviewStatus;
	  private String createDate;
	  private Integer userId;
	  private Integer companyId;
	  private Integer catalogId;
	  private Integer courseId;             // 学科ID

	  // 扩展字段
	  private String courseName;            // 学科名称
	  private String usedQty;               // 使用次数
	  private String creator;               // 录入人员

	  private ReviewLog reviewLog;        // 最后一条审核日志

	  private List<String> tagNameList;      // 所属标签名称列表
	  private List<Tag> tagList;            // 所属标签列表
	  private Company company;              // 所属公司
	  private Catalog catalog;              // 所属学科目录
	  private List<QuestionItem> questionItemList; // 题目选项集合

	  // 扩展字段(小程序)
	  private String title;   // 题目标题
	  private Integer grade;  // 难易度
	  private String content; // 内容
	  private String video;    // 视频
	  private String videoPoster; // 视频封面
	  private Integer isFamous;      // 是否名企
	  private Integer answerTag;	// 答案标记
	  private String  answerResult;  // 用户答案
	  private boolean answerIsRight; // 回答是否正确
	  private Integer isFinished;    // 是否完成
	  private Integer isFavorite;    // 是否收藏
	  private List<Tag> tags;              // 标签(考点)
	  private Integer memberId;		 // 会员Id
	  private List<QuestionItem> selection; // 选项

	/**
	 * 为选项按字母编号
 	 * @return
	 */
	public List<QuestionItem> getSelection(){
		Character code = 'A';
		if(selection == null) return null;
		for (QuestionItem questionItem:selection){
		  questionItem.setCode(code.toString());
		  code++;
		}
		return selection;
	  }

	/**
	 * 页面需要boolean类型返回
	 * @return
	 */
	public boolean getIsFamous() {
		return isFamous !=null && isFamous==1;
	  }

	/**
	 * 页面需要boolean类型返回
	 * 回答为正确或理想，返回true
	 * 其他情况为false
	 * @return
	 */
	  public boolean isAnswerIsRight() {
		if(answerTag!=null &&
			(answerTag == QuestionConst.AnswerTag.GOOD.ordinal() || answerTag == QuestionConst.AnswerTag.PERFECT.ordinal())){
			return true;
		}
		return false;
	  }
	/**
	 * 页面需要boolean类型返回
	 * @return
	 */
	  public boolean getIsFinished() {
		return isFinished !=null && isFinished==1;
	  }
	 /**
	 * 页面需要boolean类型返回
	 * @return
	 */
	  public boolean getIsFavorite() {
		return isFavorite!=null && isFavorite==1;
	  }
}
