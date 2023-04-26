package com.ruyuan.fulfill.application.command.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 订单条目
 * @author zhonghuashishan
 * @version 1.0
 */
@Data
public class OrderItemDTO implements Serializable {

    /**
     * 商品id
     */
    private String skuCode;

    /**
     * 销售单价
     */
    private Integer salePrice;

    /**
     * 销售数量
     */
    private Integer saleQuantity;

    /**
     * 付款金额
     */
    private Integer payAmount;

    /**
     * 当前商品支付原总价
     */
    private Integer originAmount;

}
