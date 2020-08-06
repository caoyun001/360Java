# 第5天
select * from t_wx_member;
select * from tr_member_question;
select * from t_catalog;
select id,name as title,
			(select count(*) from t_question where catalog_id = c.id) as allCount,
		  (select count(*) from t_question
					where catalog_id = c.id  
						and id in (select question_id from tr_member_question where member_id=6) ) as finishedCount
from t_catalog c
where status = 0 and course_id = 1

select count(*) from t_question
 where catalog_id = 1 and id in (select question_id from tr_member_question where member_id=6)


## fs 0 全部
select id,data_value as title 
from t_dict where data_type = 1
## fs 1 首页推荐
select id,data_value as title 
from t_dict 
where data_type = 1 and data_tag =10;

SELECT * from t_wx_member;

# 获取学科目录列表
# 查询每个学科目录的总题目及会员已完成的题目数量
select id,name as title ,
	(select count(*) from t_question where catalog_id = c.id) as allCount,
	(select count(*) from t_question where catalog_id = c.id 
      and id in (select question_id FROM tr_member_question where member_id=6)) as finishedCount
from t_catalog c
WHERE course_id = 1 and status = 0 
  and c.id = 1 ;

select count(*) from t_question where catalog_id = 1;

select count(*) from t_question where catalog_id = 1 and id in (select question_id FROM tr_member_question where member_id=6);



select * from t_question;
select * from tr_member_question;
select * from t_question_item;
# 等值连接（内联接）
SELECT q.id,
       q.`subject` as title,
       difficulty as grade,
       analysis as content,
       analysis_video as video,
       '' as videoPoster,
	   	if(mq.tag is null,0,1) as isFinished,
      if(mq.is_favorite=1,1,0) as isFavorite,
      q.type,
      mq.tag as answerTag
from t_question q,tr_member_question mq
where q.id = mq.question_id and status = 1 and q.catalog_id = 1
# 左或右联接
select * from (
	SELECT q.id,
				 q.`subject` as title,
				 difficulty as grade,
				 analysis as content,
				 analysis_video as video,
				 '' as videoPoster,
				if(mq.tag is null,0,1) as isFinished,
				if(mq.is_favorite=1,1,0) as isFavorite,
				q.type,
				mq.tag as answerTag,
				q.catalog_id
	from t_question q LEFT JOIN tr_member_question mq 
	on q.id = mq.question_id and mq.member_id = 6 and status = 1  
) SubQuestion
where catalog_id = 1

SELECT * from (
	SELECT q.id,
				 q.`subject` as title,
				 difficulty as grade,
				 analysis as content,
				 analysis_video as video,
				 '' as videoPoster,
				if(mq.tag is null,0,1) as isFinished,
				if(mq.is_favorite=1,1,0) as isFavorite,
				q.type,
				mq.tag as answerTag,
				q.catalog_id
	from t_question q LEFT JOIN tr_member_question mq 
	on q.id = mq.question_id and mq.member_id = 6 and status = 1  
)  SubQuestion 
where catalog_id = 1

# 提取标签列表

SELECT id,name as title from t_tag where id in (SELECT tag_id from tr_question_tag where question_id = 639);


select id,name as title from t_tag where id in (select tag_id from tr_question_tag where question_id = 1)

# 提取选项列表

SELECT id, '' as code,content as title,is_right as isRight 
 FROM t_question_item where question_id = 639

select id,'' as code ,is_right as isRight,content as title 
from t_question_item where question_id = 7


# 获取某一学科目录题目列表，左连接显示全部题目
SELECT q.id,q.`subject` as title,difficulty as grade,analysis as content,analysis_video as video,'' as videoPoster,
		if(mq.tag is null,0,1) as isFinished,if(mq.is_favorite=1,1,0) as isFavorite,q.type,mq.tag as answerTag
from t_question q left join tr_member_question mq on ( q.id = mq.question_id and  mq.member_id=6)
where q.catalog_id = 1
# 获取题目的选项列表
SELECT qi.id,'' as code ,qi.is_right as isRight,qi.content as title
       FROM t_question_item qi
       where qi.question_id = 7
# 获取题目的标签列表
select t.id,t.name as title
            from t_tag t
where t.id in (select qt.tag_id from tr_question_tag qt where qt.question_id = 7)

# 查询完成的题目

select * from tr_member_question WHERE member_id = 8;
select * from t_catalog
select * from t_company;

# 个人中心展示
 SELECT m.last_category_type as categoryType,
        m.last_category_kind as categoryKind,
		    (SELECT count(*) FROM tr_member_question where member_id = 8) as answerCount,
	      (select data_value from t_dict where id = m.city_id) as cityName,
        'Java基础' as categoryTitle,
			  m.city_id as cityID,
	      m.last_category_id as categoryID,
        m.last_question_id as lastQuestionId,
	      m.course_id as subjectID
from t_wx_member m
where id = 8
select * from t_wx_member;
select data_value from t_dict where id = 9

# kind -1
SELECT name as categoryTitle from t_catalog where id = 1
# kine -2 按企业
SELECT short_name as categoryTitle from t_company where id = 22

select name as categoryTitle from t_industry where id = 13;


select * from t_wx_member;
where id = 8
 select 
    (select count(*) from tr_member_question mq WHERE mq.member_id = m.id) as answerCount,
    last_category_kind as categoryKind ,
    last_category_type as categoryType ,
    last_category_id as categoryID,
    last_question_id as lastQuestionId,
    city_id as cityID,
    (select data_value from t_dict where id = m.city_id) as cityName,
    course_id as subjectID
    from t_wx_member m
		where id = 6
select * from tr_member_question where member_id = 7

select id,(SELECT count(*) from tr_member_question where member_id = w.id ) as answerCount  from t_wx_member w where id = 7
select * from t_question where id = 7;