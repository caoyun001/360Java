package com.chongba.supplier.inf;

import com.chongba.recharge.CheckStatusRequest;
import com.chongba.recharge.RechargeRequest;

/**
 * Created by 传智播客*黑马程序员.
 */
public interface SupplierService {

    /**
     * 对接充值平台进行充值下单
     * @param rechargeRequest
     */
    public void recharge(RechargeRequest rechargeRequest);


    /**
     * 对接下单成功后检查充值状态
     * @param checkStatusRequest
     */
    public void checkStatus(CheckStatusRequest checkStatusRequest);
}
