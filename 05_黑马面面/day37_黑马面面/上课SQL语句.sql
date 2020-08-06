#��1��ѧ����չʾ
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
 # ��ҳ��ѯ��ʵ��
SELECT tc.id,name,tc.create_date as createDate,tc.is_show as isShow,
    0 as catalogQty,
    0 as tagQty,
    0 as questionQty ,
    tu.username as creator
FROM t_course tc join t_user tu on  tc.user_id = tu.id
limit 0,3;
# ��ҳ��ѯ������ʵ��
SELECT tc.id,name,tc.create_date as createDate,tc.is_show as isShow,
    0 as catalogQty,
    0 as tagQty,
    0 as questionQty ,
    tu.username as creator
FROM t_course tc join t_user tu on  tc.user_id = tu.id
WHERE  is_show = 0 and name like '%java%'
limit 0,3;

# ��2����Ŀ�б�չʾ
# 
#�ڲ�ѯ����
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


# �Ӳ�ѯ����
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

# ��2���ʼ��ѧ���б�
   

#��ѯѧ��
SELECT id,name FROM t_course;
#����ѧ��ID ��ѯѧ��Ŀ¼�б�
SELECT id,name FROM t_catalog WHERE course_id = 1;
#����ѧ��ID ��ѯ��ǩ�б�
select * from t_tag;
SELECT id,name FROM t_tag WHERE course_id  = 1;

# ��ѯ��ҵ����
select id,name from t_industry;
#��ѯ��˾�б�
select * from t_company;
SELECT id,short_name as shortName,city_id as cityId
FROM t_company

SELECT id,city_id as cityId,short_name as shortName
        FROM  t_company

 SELECT id,name FROM t_industry 
 WHERE id in (select industry_id from tr_company_industry where company_id = 1)


select id,name from t_industry where id in ( select industry_id from tr_company_industry where company_id = 1 )

#��ȡ��˾��������ҵ��Ϣ
SELECT id,name
from tr_company_industry ci ,t_industry i
where ci.industry_id = i.id and ci.company_id  = 1
# ������Ŀ����ѯ��Ŀ��Ϣ
select * from t_question order by id desc;
# ������Ŀѡ���ѯѡ���
SELECT *  from t_question_item order by id desc;
# ������Ŀ��ǩ
select * from t_question order by id desc;
select * from t_tag;
select * from tr_question_tag order by question_id desc;
# ��˾����ҵ��Ϣ
select * from t_company;
select * from t_industry;
select * from tr_company_industry order by company_id ;


# ��������
INSERT INTO t_question (subject, type, difficulty, analysis, analysis_video, remark, is_classic, review_status, status, create_date, user_id, company_id, catalog_id,course_id)
VALUES (#{subject},#{type},#{difficulty},#{analysis}, #{analysisVideo}, #{remark}, #{isClassic}, #{reviewStatus},#{status}, #{createDate}, #{userId}, #{companyId}, #{catalogId},#{courseId})
# ��������    
UPDATE t_question
set number=#{number},subject=#{subject},type=#{type},difficulty=#{difficulty},analysis=#{analysis},analysis_video=#{analysisVideo},remark=#{remark},company_id=#{companyId},catalog_id=#{catalogId}
WHERE id = #{id}

# ��3��
# �����û�ID����ȡ��ɫ��Ϣ
 SELECT * FROM t_user;
select * from t_role  WHERE id in (SELECT role_id from tr_user_role WHERE user_id = 2);
SELECT * FROM t_role
WHERE id in (SELECT role_id FROM tr_user_role WHERE user_id = 2)
# ���ݽ�ɫID����ȡȨ����Ϣ
SELECT * FROM t_permission
WHERE id in(SELECT permission_id from tr_role_permission where role_id = 2)


SELECT * FROM t_permission
WHERE id IN (SELECT permission_id FROM tr_role_permission WHERE role_id = 2)

select * from tr_user_role order by role_id ;

select * from tr_role_permission order by role_id ;
# �����־��
SELECT * from t_review_log order by question_id desc;
select * from t_question where id = 691;

#��4��
select id,data_value as title from t_dict WHERE data_value = '����' and data_type = 1 ;
fs = 1
select id,data_value as title from t_dict where data_tag = 1 
fs = 0
select id,data_value as title from t_dict where  data_type = 1

select id,name as title,if(icon is null,"",icon) as icon from t_course where is_show = 0

select * from t_wx_member;
UPDATE t_wx_member
set city_id = 9,course_id = 1
where open_id = 'oDQVX48njUTb-4iQbel3hRpyoRIs-1'

# ��5��
select * from t_wx_member;

# ��ȡѧ��Ŀ¼�б�
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

# ��ǰ��ǩ�б�

select id,name as title from t_tag where id in (select tag_id from tr_question_tag where question_id = 1)

# ��ǰѡ���б�
select id,'' as code ,is_right as isRight,content as title 
from t_question_item where question_id = 6


# ��ȡĳһѧ��Ŀ¼��Ŀ�б���������ʾȫ����Ŀ
SELECT q.id,q.`subject` as title,difficulty as grade,analysis as content,analysis_video as video,'' as videoPoster,
		if(mq.tag is null,0,1) as isFinished,if(mq.is_favorite=1,1,0) as isFavorite,q.type,mq.tag as answerTag
from t_question q left join tr_member_question mq on ( q.id = mq.question_id and  mq.member_id=6)
where q.catalog_id = 1
# ��ȡ��Ŀ��ѡ���б�
SELECT qi.id,'' as code ,qi.is_right as isRight,qi.content as title
       FROM t_question_item qi
       where qi.question_id = 7
# ��ȡ��Ŀ�ı�ǩ�б�
select t.id,t.name as title
            from t_tag t
where t.id in (select qt.tag_id from tr_question_tag qt where qt.question_id = 7)

# ��ѯ��ɵ���Ŀ


# ��������չʾ
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