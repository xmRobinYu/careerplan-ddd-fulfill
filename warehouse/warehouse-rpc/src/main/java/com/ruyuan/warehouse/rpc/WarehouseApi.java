package com.ruyuan.warehouse.rpc;

import com.ruyuan.warehouse.rpc.dto.WarehouseDTO;
import com.ruyuan.warehouse.rpc.request.FulfillOrderWarehouseRequest;
import com.ruyuan.warehouse.rpc.request.LockWarehouseInventoryRequest;
import com.ruyuan.warehouse.rpc.request.WarehouseRequest;

import java.util.List;

/**
 * @author zhonghuashishan
 * @version 1.0
 */
public interface WarehouseApi {

    /**
     * 获取所有的仓库信息
     * @return
     */
    List<WarehouseDTO> getAll(List<String> skuCodes);

    /**
     * 锁定仓库商品库存
     * @param lockWarehouseInventoryRequest
     * @return
     */
    Boolean lockInventory(LockWarehouseInventoryRequest lockWarehouseInventoryRequest);

    /**
     * 将履约单下发至库房
     * @param fulfillOrderWarehouseRequest
     * @param warehouseRequest
     */
    void sendFulfillOrder(FulfillOrderWarehouseRequest fulfillOrderWarehouseRequest, WarehouseRequest warehouseRequest);

}