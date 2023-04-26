package com.ruyuan.warehouse.rpc.request;

import java.io.Serializable;

/**
 * @author zhonghuashishan
 * @version 1.0
 */
public class WarehouseRequest implements Serializable {

    private static final long serialVersionUID = 5500023781244634658L;

    /**
     * 仓库id
     */
    private String warehouseId;

    public String getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
    }
}