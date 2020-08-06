package com.chongba.entity;

public class StatusCode {
    public static final int OK=200;//成功
    public static final int ERROR =500;//失败

    public static final int LOGINERROR = 20002;//用户名或密码错误
    public static final int ACCESSERROR = 20003;//权限不足
    public static final int REMOTEERROR = 20004;//远程调用失败
    public static final int REPERROR = 20005;//重复操作
    public static final int BALANCE_NOT_ENOUGH = 20006;//余额不足
    public static final int STATECHECK = 20008;//状态检查
    public static final int ORDER_REQ_FAILED = 208508;//订单请求失败，重试
	
}