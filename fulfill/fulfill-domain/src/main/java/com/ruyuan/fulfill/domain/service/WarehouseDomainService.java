package com.ruyuan.fulfill.domain.service;

import com.ruyuan.fulfill.domain.gateway.WarehouseApiGateway;
import com.ruyuan.fulfill.domain.model.fulfillorder.FulfillOrder;
import com.ruyuan.fulfill.domain.model.warehouse.Warehouse;
import com.ruyuan.fulfill.domain.model.warehouse.Warehouses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 仓储领域模型服务
 */
@Component
public class WarehouseDomainService {

    @Autowired
    private WarehouseApiGateway warehouseApiGateway;

    @Autowired
    private CalculateDistanceService calculateDistanceService;

    public Warehouse preAllocateWarehouse(FulfillOrder fulfillOrder) {

        // 查询所有的仓库信息
        Warehouses warehouses = warehouseApiGateway.getAll(fulfillOrder.getSkuCodes());

        // 从所有的仓库里选择一个距离订单收货地址，距离最近的一个仓库
        Warehouse warehouse = warehouses.selectNearest(fulfillOrder.getDeliveryAddress(), calculateDistanceService);

        // 检查选择的仓库对订单订购的商品的数量，库存是否充足
        if (warehouse.isInventoryEnough(fulfillOrder.getFulfillOrderItems())) {
            // 对选择的仓库，将订单订购的商品的库存进行锁定
            warehouse.lockInventory(fulfillOrder, warehouseApiGateway);
            // 将履约订单分配给选择的仓库
            fulfillOrder.allocateToWarehouse(warehouse);
            return warehouse;
        }

        return null;
    }

}
