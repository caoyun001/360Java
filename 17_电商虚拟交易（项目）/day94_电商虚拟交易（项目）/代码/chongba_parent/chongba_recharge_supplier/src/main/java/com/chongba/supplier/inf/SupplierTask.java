package com.chongba.supplier.inf;

import com.chongba.recharge.RechargeRequest;

/**
 * Created by 传智播客*黑马程序员.
 */
public interface SupplierTask {

    /**
     * 添加重试任务
     * @param rechargeRequest
     */
    public void addRetryTask(RechargeRequest rechargeRequest);
    /**
     * 重试 拉取/消费重试任务
     */
    public void retryRecharge();

    /**
     * 供应商轮转
     */
    public void roundRecharge();

    /**
     * 远程调用异常重试
     */
    public void rechargeException();
}
