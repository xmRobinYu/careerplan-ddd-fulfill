package com.ruyuan.fulfill.domain.gateway;

import com.ruyuan.fulfill.domain.model.fulfillorder.FulfillOrder;
import com.ruyuan.fulfill.domain.model.warehouse.Warehouse;
import com.ruyuan.fulfill.domain.model.warehouse.Warehouses;

import java.util.List;

/**
 * 仓储域的路由接口
 */
public interface WarehouseApiGateway {

    /**
     * 根据skuCode查询满足条件所有仓库
     * @param skuCodes
     * @return
     */
    Warehouses getAll(List<String> skuCodes);

    /**
     * 在指定仓库锁定sku的库存
     * @param warehouseId
     * @param orderId
     * @param skuCodes
     * @param inventoryCount
     * @return
     */
    Boolean lockInventory(String warehouseId,
                          String orderId,
                          List<String> skuCodes,
                          List<Integer> inventoryCount);

    /**
     * 将履约单下发至库房
     * @param fulfillOrder
     * @param warehouse
     */
    void sendFulfillOrder(FulfillOrder fulfillOrder,
                                Warehouse warehouse);

}
