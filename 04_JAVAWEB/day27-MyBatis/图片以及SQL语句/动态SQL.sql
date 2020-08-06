SELECT * FROM USER
/*
   动态SQL语句
   查询用户数据
   姓名，性别，地址
   
   根据用户输入的条件， 动态生成SQL
   
   Java实现：
   String sql = " SELECT * FROM USER WHERE 1=1 ";
     if(姓名 != null && 姓名 != "")
         sql+= and username LIKE '%%' 
     
     if(地址 != null && 地址 != "")
       sql += and address LIKE'%%'

*/

SELECT * FROM USER WHERE username LIKE '%%'c

SELECT * FROM USER WHERE username LIKE '%%' AND address LIKE'%%'

SELECT * FROM USER WHERE 1=1 AND username LIKE '%%'  AND address LIKE'%%'

/*
    delete from user  where in(1,2,5,6,7)
    批量删除的SQL语句
    
    String[] str = {1,2,5,6,7}
    
    
    String sql = " delete from user  where in( 1, 2,";
    for(int i = 0; i < str.length;i++){
	if(i != str.length-1)
	  sql += str[i]+","
	else
	  sql += str[i]+")"
    }
    
    
*/



