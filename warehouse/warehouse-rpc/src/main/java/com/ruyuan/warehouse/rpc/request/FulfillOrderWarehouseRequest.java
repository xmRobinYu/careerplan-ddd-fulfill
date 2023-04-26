package com.ruyuan.warehouse.rpc.request;

import java.io.Serializable;

/**
 * @author zhonghuashishan
 * @version 1.0
 */
public class FulfillOrderWarehouseRequest implements Serializable {

    private static final long serialVersionUID = 1873369553540147961L;

    private String fulfillOrderId;

    public String getFulfillOrderId() {
        return fulfillOrderId;
    }

    public void setFulfillOrderId(String fulfillOrderId) {
        this.fulfillOrderId = fulfillOrderId;
    }
}