#第1天学科列展示
select * from t_course;
select id,name,create_date as createDate,is_show as isShow,
	(select username from t_user where id = c.user_id ) as creator,
   (SELECT count(*) from t_tag where course_id = c.id) as tagQty,
   (select count(*) from t_question where course_id = c.id) as questionQty,
   (select count(*) from t_catalog where course_id = c.id) as catalogQty
from t_course c
where is_show = 0
limit 0,3

select id,name,create_date as createDate,is_show as isShow,
                'admin' as creator,
               0 as tagQty,
               0 as questionQty,
               0 as catalogQty
            from t_course

SELECT count(*) from t_tag where course_id = 1;
select count(*) from t_question where course_id = 1

select * from t_course;

select count(*) from t_catalog where course_id = 1;
select * from t_tag;
 # 分页查询简单实现
SELECT tc.id,name,tc.create_date as createDate,tc.is_show as isShow,
    0 as catalogQty,
    0 as tagQty,
    0 as questionQty ,
    tu.username as creator
FROM t_course tc join t_user tu on  tc.user_id = tu.id
limit 0,3;
# 分页查询带条件实现
SELECT tc.id,name,tc.create_date as createDate,tc.is_show as isShow,
    0 as catalogQty,
    0 as tagQty,
    0 as questionQty ,
    tu.username as creator
FROM t_course tc join t_user tu on  tc.user_id = tu.id
WHERE  is_show = 0 and name like '%java%'
limit 0,3;

# 第2天题目列表展示
# 
#内查询方案
 SELECT   tq.id,(1000+tq.id) as number,
 					tc.name as courseName,
 				  type,
 				  `subject`,
 					tq.create_date as createDate,
 					difficulty, 
 				(SELECT  count(*) FROM tr_member_question tmq WHERE tmq.question_id = tq.id ) as usedQty, 
 				tu.username as creator,
 				tq.`status`
 FROM t_question tq
 JOIN t_course tc ON tq.course_id = tc.id
 JOIN t_user tu ON tc.user_id = tu.id
 where tq.course_id = 1 and tq.is_classic = 0
 limit 0,5


select * 
from t_question 
where is_classic = 0

SELECT count(*) 
from t_question 
where is_classic = 0


# 子查询方案
 SELECT   tq.id,(1000+tq.id) as number,
 					(select c.name from t_course c where c.id = tq.course_id ) as courseName,
 				  type,
 				  `subject`,
 					tq.create_date as createDate,
 					difficulty, 
 				  (SELECT  count(*) FROM tr_member_question tmq WHERE tmq.question_id = tq.id ) as usedQty, 
 				  (select u.username from t_user u where u.id = tq.user_id) as creator,
 				tq.`status`
 FROM t_question tq
 where tq.course_id = 1 and tq.is_classic = 0
 limit 0,5

# 第2天初始化学科列表
   

#查询学科
SELECT id,name FROM t_course;
#根据学科ID 查询学科目录列表
SELECT id,name FROM t_catalog WHERE course_id = 1;
#根据学科ID 查询标签列表
select * from t_tag;
SELECT id,name FROM t_tag WHERE course_id  = 1;

# 查询行业数据
select id,name from t_industry;
#查询公司列表
select * from t_company;
SELECT id,short_name as shortName,city_id as cityId
FROM t_company

SELECT id,city_id as cityId,short_name as shortName
        FROM  t_company

 SELECT id,name FROM t_industry 
 WHERE id in (select industry_id from tr_company_industry where company_id = 1)


select id,name from t_industry where id in ( select industry_id from tr_company_industry where company_id = 1 )

#获取公司所属的行业信息
SELECT id,name
from tr_company_industry ci ,t_industry i
where ci.industry_id = i.id and ci.company_id  = 1
# 保存题目，查询题目信息
select * from t_question order by id desc;
# 保存题目选项，查询选项表
SELECT *  from t_question_item order by id desc;
# 保存题目标签
select * from t_question order by id desc;
select * from t_tag;
select * from tr_question_tag order by question_id desc;
# 公司及行业信息
select * from t_company;
select * from t_industry;
select * from tr_company_industry order by company_id ;


# 插入数据
INSERT INTO t_question (subject, type, difficulty, analysis, analysis_video, remark, is_classic, review_status, status, create_date, user_id, company_id, catalog_id,course_id)
VALUES (#{subject},#{type},#{difficulty},#{analysis}, #{analysisVideo}, #{remark}, #{isClassic}, #{reviewStatus},#{status}, #{createDate}, #{userId}, #{companyId}, #{catalogId},#{courseId})
# 更新数据    
UPDATE t_question
set number=#{number},subject=#{subject},type=#{type},difficulty=#{difficulty},analysis=#{analysis},analysis_video=#{analysisVideo},remark=#{remark},company_id=#{companyId},catalog_id=#{catalogId}
WHERE id = #{id}

# 第3天
# 根据用户ID，获取角色信息
 SELECT * FROM t_user;
select * from t_role  WHERE id in (SELECT role_id from tr_user_role WHERE user_id = 2);
SELECT * FROM t_role
WHERE id in (SELECT role_id FROM tr_user_role WHERE user_id = 2)
# 根据角色ID，获取权限信息
SELECT * FROM t_permission
WHERE id in(SELECT permission_id from tr_role_permission where role_id = 2)


SELECT * FROM t_permission
WHERE id IN (SELECT permission_id FROM tr_role_permission WHERE role_id = 2)

select * from tr_user_role order by role_id ;

select * from tr_role_permission order by role_id ;
# 审核日志表
SELECT * from t_review_log order by question_id desc;
select * from t_question where id = 691;

#第4天
select id,data_value as title from t_dict WHERE data_value = '北京' and data_type = 1 ;
fs = 1
select id,data_value as title from t_dict where data_tag = 1 
fs = 0
select id,data_value as title from t_dict where  data_type = 1

select id,name as title,if(icon is null,"",icon) as icon from t_course where is_show = 0

select * from t_wx_member;
UPDATE t_wx_member
set city_id = 9,course_id = 1
where open_id = 'oDQVX48njUTb-4iQbel3hRpyoRIs-1'

# 第5天
select * from t_wx_member;

# 获取学科目录列表
select id,name as title ,
	(select count(*) from t_question where catalog_id = c.id) as allCount,
	(select count(*) from tr_member_question mq 
		where mq.member_id = 6 and question_id in (select id FROM t_question where catalog_id = c.id)) as finishedCount
from t_catalog c
WHERE course_id = 1 and status = 0 and c.id = 2;


select c.id,name as title,
	 (select count(q.id) from t_question q where q.catalog_id = c.id) as allCount,
	 (select count(DISTINCT(mq.question_id)) FROM tr_member_question mq  JOIN t_question q
			on mq.question_id =  q.id
			where q.catalog_id = c.id and mq.member_id = 6
			) as finishedCount
from t_catalog c
WHERE course_id = 1 and status = 0 

select * from t_question;
select * from tr_member_question;
SELECT q.id,q.`subject` as title,difficulty as grade,analysis as content,analysis_video as video,'' as videoPoster,
		if(mq.tag is null,0,1) as isFinished,if(mq.is_favorite=1,1,0) as isFavorite,q.type,mq.tag as answerTag
from t_question q,tr_member_question mq
where q.id = mq.question_id and q.catalog_id = 1

# 提前标签列表

select id,name as title from t_tag where id in (select tag_id from tr_question_tag where question_id = 1)

# 提前选项列表
select id,'' as code ,is_right as isRight,content as title 
from t_question_item where question_id = 6


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


# 个人中心展示
 SELECT * from t_wx_member;
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
		where id = 7
select * from tr_member_question where member_id = 7

select id,(SELECT count(*) from tr_member_question where member_id = w.id ) as answerCount  from t_wx_member w where id = 7
select * from t_question where id = 7;