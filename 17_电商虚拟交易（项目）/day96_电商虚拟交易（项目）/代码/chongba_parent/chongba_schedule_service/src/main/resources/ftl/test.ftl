<html>
    <head>
        <meta charset="UTF-8" />
        <title>freemarker入门小demo</title>
    </head>
    <body>
        <!--html的注释-->
        <#--这是freemarker的注释 不会被输出到最终的文件中的-->
        你好!,${name},${message}
    <br>
    <#--变量的定义-->
    <#assign msg="对不起,你是个好人,我不想伤害你!">
    ${msg}
    <br>
    <#assign user={"name":"张三","age":18,"address":"北京市昌平区"} >
    ${user.name}----${user.age}----${user.address}
    
    <br>
    <#assign myList=["西游降魔","我和我的祖国"]>
    ${myList[0]}----${myList[1]}
    
    <#include "head.ftl">
    
    <#if likeyou==true>
       我喜欢你 
    </#if>
    
    <#if likeyou=true>
        我喜欢你
        <#else>
        我不喜欢你
    </#if>
    
    <br>
    <#list 0..10 as item>
        ${item}
    </#list>
    
    
    <br>
    <#list taskList as task>
        ${task_index + 1}----${task.taskType}----${task.priority} <br>
    </#list>
    总共${taskList?size}条记录<br>
    
    <#assign taskStr="{'taskType':1005,'priority':250}">
    <#--${taskStr.taskType}-->
    <#assign task=taskStr?eval>
    ${task.taskType}----${task.priority}
    
    
    <br>
    日期:${today?date}<br>
    时间:${today?time}<br>
    日期+时间:${today?datetime}
        自定义格式:${today?string('yyyy年-MM月-dd日')}
    
    <br>
    
    <#assign aaa="你好呀">
    <#if aaa??>
        变量aaa存在
        <#else>
        变量aaa不存在
    </#if>
    
    ${aaa ! 'hello'}
    </body>
</html>