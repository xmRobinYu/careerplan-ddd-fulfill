package com.ruyuan.fulfill.domain.model.fulfillorder;

import lombok.Data;

/**
 * 支付信息
 * @author zhonghuashishan
 * @version 1.0
 */
@Data
public class PaymentDetail {

    /**
     * 付款总金额
     */
    private Integer payAmount;

    /**
     * 商品原价金额
     */
    private Integer originAmount;

}
