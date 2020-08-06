package com.chongba.recharge.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 追踪订单
 *
 */
@Data
@TableName("order_trade")
public class OrderTrade implements Serializable {

    private static final long serialVersionUID = 1L;

	@TableId
    private Long id;

    private String brandId; //品牌

    private String categoryId; //品类

    private Integer orderStatus;

    private double salesPrice;

    private double facePrice;

    private String mobile;

    private Long tradeNo;

    private String orderNo;

    private Date orderTime;


}
