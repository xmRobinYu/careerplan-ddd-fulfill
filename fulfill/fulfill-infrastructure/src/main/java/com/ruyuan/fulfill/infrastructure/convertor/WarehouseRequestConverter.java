package com.ruyuan.fulfill.infrastructure.convertor;

import com.ruyuan.fulfill.domain.model.warehouse.Warehouse;
import com.ruyuan.warehouse.rpc.request.WarehouseRequest;
import org.springframework.stereotype.Component;

/**
 * @author zhonghuashishan
 * @version 1.0
 */
@Component
public class WarehouseRequestConverter {

    public WarehouseRequest convert(Warehouse warehouse) {
        WarehouseRequest request = new WarehouseRequest();
        request.setWarehouseId(warehouse.getWarehouseId());
        return request;
    }

}