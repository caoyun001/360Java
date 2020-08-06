SELECT *FROM USER,orders

/*
     多表查询,不能乘积
     一定有条件,主表主键=从表外键
     查询用户表和定的表
*/
SELECT * FROM USER,orders WHERE user.id=orders.user_id;

/*
  查询数据,显示所有用户,外连接
  左边的表数据必须全部出现,右边的表没有数据,补充null
  用户表为基准, 查询订单,一对多
*/

SELECT u.id uid,u.username,u.sex,u.birthday,u.address,o.id,o.user_id,o.number,o.createtime,o.note
FROM USER u LEFT OUTER JOIN orders o ON u.id = o.user_id;

/*
  查询数据,显示所有订单,外连接
  没有定单用户,不显示
  订单表为基准,一个定单对应一个用户
*/

SELECT u.id uid,u.username,u.sex,u.birthday,u.address,o.id,o.user_id,o.number,o.createtime,o.note
FROM orders o LEFT OUTER JOIN USER u ON u.id = o.user_id;
