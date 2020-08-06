<%--
  Created by IntelliJ IDEA.
  User: 小玉
  Date: 2019/11/19
  Time: 9:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
    <%--导入js文件--%>
    <script src="js/vue.js"></script>
    <script src="js/axios-0.18.0.js"></script>
</head>
<body>
    SpringMVC框架的进行 Ajax 交互

    <fieldset>
        <h4>Ajax 的Json数据</h4>
        <div id="app">
            <input type="button" @click="clickMe()" value="发送Ajax数据">
            <%--使用插值表达式--%>
            {{ userList }}
        </div>
    </fieldset>
</body>
</html>
<script>
    <!-- 创建一个Vue对象 -->
    new Vue({
        el: '#app',
        data:{
            userList: []
        },
        methods:{
            clickMe:function(){

                var params = {id:1, username:'你好', sex:'男'};
                //发起ajax
               axios.post("/ajax/testAjax.do", params)
                   .then(response => {
                       //成功
                       //console.log(response.data);
                       this.userList = response.data
                   }).catch(error =>{
                       //失败
                       console.dir(error);
                   });
            }
        }
    })
</script>
