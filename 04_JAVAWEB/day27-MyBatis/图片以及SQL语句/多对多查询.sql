/*
  角色用户查询
  三个表一起联合查询
  角色表为基准

  中间表作用,关联其他的两个表
  查询的时候,不需要显示
*/

SELECT r.rid,r.rname,r.rdesc,u.id,u.username,u.sex,u.birthday,u.address
 FROM role r LEFT OUTER JOIN user_role ur
ON r.RID = ur.RID LEFT OUTER JOIN USER u ON u.id=ur.UID;






SELECT u.id uid,u.username,u.sex,u.birthday,u.address,o.id,o.user_id,o.number,o.createtime,o.note
 FROM orders o LEFT OUTER JOIN USER u ON u.id = o.user_id; 
 
 
  SELECT o.id,o.user_id,o.number,o.createtime,o.note FROM orders o
  /*
      订单表的列 user_id 和 用户表的id 主外键的关系  
      先查询的是订单,使用订单的一个列 user_id
      
      作为条件,去查询用户表
  */
  
  SELECT * FROM USER WHERE id = 订单表的user_id
  
  SELECT u.id uid,u.username,u.sex,u.birthday,u.address FROM USER u 
  