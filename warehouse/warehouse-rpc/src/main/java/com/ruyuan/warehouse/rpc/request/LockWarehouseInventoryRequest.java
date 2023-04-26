package com.ruyuan.warehouse.rpc.request;

import java.io.Serializable;
import java.util.List;

/**
 * @author zhonghuashishan
 * @version 1.0
 */
public class LockWarehouseInventoryRequest implements Serializable {

    private static final long serialVersionUID = -5057664862219377632L;

    private String warehouseId;
    private String orderId;
    private List<String> skuCodes;
    private List<Integer> inventoryCount;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public List<String> getSkuCodes() {
        return skuCodes;
    }

    public void setSkuCodes(List<String> skuCodes) {
        this.skuCodes = skuCodes;
    }

    public List<Integer> getInventoryCount() {
        return inventoryCount;
    }

    public void setInventoryCount(List<Integer> inventoryCount) {
        this.inventoryCount = inventoryCount;
    }
}