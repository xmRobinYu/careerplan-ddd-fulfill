package com.ruyuan.fulfill.infrastructure.gatewayimpl;

import com.ruyuan.fulfill.domain.model.fulfillorder.FulfillOrder;
import com.ruyuan.fulfill.domain.gateway.WarehouseApiGateway;
import com.ruyuan.fulfill.domain.model.warehouse.Warehouse;
import com.ruyuan.fulfill.domain.model.warehouse.Warehouses;
import com.ruyuan.fulfill.infrastructure.convertor.FulfillOrderWarehouseRequestConverter;
import com.ruyuan.fulfill.infrastructure.convertor.WarehouseConverter;
import com.ruyuan.fulfill.infrastructure.convertor.WarehouseRequestConverter;
import com.ruyuan.warehouse.rpc.WarehouseApi;
import com.ruyuan.warehouse.rpc.dto.WarehouseDTO;
import com.ruyuan.warehouse.rpc.request.FulfillOrderWarehouseRequest;
import com.ruyuan.warehouse.rpc.request.LockWarehouseInventoryRequest;
import com.ruyuan.warehouse.rpc.request.WarehouseRequest;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WarehouseApiGatewayImpl implements WarehouseApiGateway {

    @DubboReference(version = "1.0.0", retries = 0)
    private WarehouseApi warehouseApi;

    @Autowired
    private WarehouseConverter warehouseConverter;

    @Autowired
    private FulfillOrderWarehouseRequestConverter fulfillOrderWarehouseRequestConverter;

    @Autowired
    private WarehouseRequestConverter warehouseRequestConverter;

    @Override
    public Warehouses getAll(List<String> skuCodes) {
        List<WarehouseDTO> warehouseDTOList = warehouseApi.getAll(skuCodes);
        Warehouses warehouses = new Warehouses();
        List<Warehouse> warehouseList = warehouseConverter.convert(warehouseDTOList);
        warehouses.setWarehouses(warehouseList);
        return warehouses;
    }

    @Override
    public Boolean lockInventory(String warehouseId,
                                 String orderId,
                                 List<String> skuCodes,
                                 List<Integer> inventoryCount) {
        LockWarehouseInventoryRequest request = new LockWarehouseInventoryRequest();
        request.setWarehouseId(warehouseId);
        request.setOrderId(orderId);
        request.setSkuCodes(skuCodes);
        request.setInventoryCount(inventoryCount);
        return warehouseApi.lockInventory(request);
    }

    @Override
    public void sendFulfillOrder(FulfillOrder fulfillOrder, Warehouse warehouse) {
        FulfillOrderWarehouseRequest fulfillOrderRequest = fulfillOrderWarehouseRequestConverter.convert(fulfillOrder);
        WarehouseRequest warehouseRequest = warehouseRequestConverter.convert(warehouse);
        warehouseApi.sendFulfillOrder(fulfillOrderRequest, warehouseRequest);
    }

}
