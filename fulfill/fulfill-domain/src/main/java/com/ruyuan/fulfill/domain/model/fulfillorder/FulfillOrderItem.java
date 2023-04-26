package com.ruyuan.fulfill.domain.model.fulfillorder;


import lombok.Data;

/**
 * 履约单条目
 * @author zhonghuashishan
 * @version 1.0
 */
@Data
public class FulfillOrderItem {

    /**
     * 订单id
     */
    private String orderId;

    /**
     * 履约单ID
     */
    private String fulfillId;

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
