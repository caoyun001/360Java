package com.chongba.recharge;

import com.chongba.enums.OrderStatusEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class RechargeResponse implements Serializable {

	private static final long serialVersionUID = 5524019846483682009L;

	private String moblie;

	private String orderNo;

	private String tradeNo;
	
	private double pamt;
	
	private int status = OrderStatusEnum.WARTING.getCode();

}
