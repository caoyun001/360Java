/**
 * 使用Vue实现数据的CRUD操作
 */
new Vue({
    el:"#app",
    data:{
        //定义对象,存储单个用户数据
        userInfo:{},
        //定义数组,存储多个用户数据
        userList:[]
    },
    methods:{
        //定义函数,实现删除
        deleteUser:function(id){
            //提示用户
            if(confirm("确定要删除吗")){
                //发生请求
                axios.get("/user?operator=delete&id="+id).
                then(response=>{
                    //展示全部数据
                    this.findAll();
                }).
                catch(error=>{

                });
            }
        },

        //定义函数,实现修改数据
        update:function(){
          //获取修改后的数据,提交服务器
            axios.post("/user?operator=update",this.userInfo).
            then(response=>{
                //展示全部数据
                this.findAll();
            }).
            catch(error=>{

            });
        },

        //定义函数,修改之前的数据回显
        findById:function(id){
          //发生请求,服务器提交要查询的主键
          axios.get("/user?operator=findById&id="+id).
          then( response=>{
              //response响应回来结果 键data json数据
              //json数据,赋值Vue对象中的键 userInfo
              this.userInfo = response.data;
              //弹出修改对话框
              $("#update_modal").modal("show");
          } ).
          catch(error=>{

          });
        },

        //定义函数,发生异步请求,获取所有的用户数据 ,响应json数据
        findAll:function(){
            //发生get请求
            axios.get("/user?operator=findAll").
            then( response=>{
                console.log(response);
                //响应回来json(数组)赋值给 userList键
                this.userList = response.data;
            }).
            catch(error=>{
                console.log("服务器响应失败"+error);
            });
        },

        //定义注册函数,添加用户的数据
        register:function(){
            //获取对象userInfo的数据
            //console.log( this.userInfo );
            //服务器发生请求,提交参数 填写用户名和余额
            //数据封装到了userInfo
            axios.post("/user?operator=register",this.userInfo).
            then(response=>{
                //调用findAll()
                this.findAll();
            }).
            catch(error=>{

            })
        },

        //定义函数添加事件
        add:function () {
            //打开窗口即可
            //jQuery获取div,调用bootstrap前端框架方法 model()
            $("#add_modal").modal("show");
        }
    },
    //生命周期的钩子函数
    //对象挂载完成,调用函数,发生请求
    mounted:function(){
       this.findAll();
    }
});