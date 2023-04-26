package com.ruyuan.logistics.rpc.request;

import java.io.Serializable;

/**
 * @author zhonghuashishan
 * @version 1.0
 */
public class ApplyLogisticsOrderRequest implements Serializable {

    private static final long serialVersionUID = 838296423225003548L;

    private String logisticsCompanyId;

    private String fulfillOrderId;

    private String warehouseId;

    public String getLogisticsCompanyId() {
        return logisticsCompanyId;
    }

    public void setLogisticsCompanyId(String logisticsCompanyId) {
        this.logisticsCompanyId = logisticsCompanyId;
    }

    public String getFulfillOrderId() {
        return fulfillOrderId;
    }

    public void setFulfillOrderId(String fulfillOrderId) {
        this.fulfillOrderId = fulfillOrderId;
    }

    public String getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
    }
}