/*
  外连接查询:
    左外: left outer join
    右外: right outer join
*/


/*
  左外连接:参照点就是左边的表!!左表的数据必须都显示.
  右边的表,没有数据,必须显示null!!
*/
SELECT * FROM category c LEFT OUTER JOIN products p
ON c.cid = p.category_id;

/*
 右外连接:参照点就是右边的表!!右边表的数据都要显示
 左边的表多余数据,不能显示
*/
SELECT * FROM category c RIGHT OUTER JOIN products p
ON c.cid = p.category_id;