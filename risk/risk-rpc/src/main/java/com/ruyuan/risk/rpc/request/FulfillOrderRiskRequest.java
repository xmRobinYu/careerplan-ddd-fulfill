package com.ruyuan.risk.rpc.request;

import java.io.Serializable;

/**
 * @author zhonghuashishan
 * @version 1.0
 */
public class FulfillOrderRiskRequest implements Serializable {

    private static final long serialVersionUID = -3698162791103762254L;

    /**
     * 订单ID
     */
    private String orderId;

    /**
     * 履约单ID
     */
    private String fulfillId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getFulfillId() {
        return fulfillId;
    }

    public void setFulfillId(String fulfillId) {
        this.fulfillId = fulfillId;
    }
}