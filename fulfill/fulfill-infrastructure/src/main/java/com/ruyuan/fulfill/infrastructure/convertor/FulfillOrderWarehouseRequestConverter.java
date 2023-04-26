package com.ruyuan.fulfill.infrastructure.convertor;

import com.ruyuan.fulfill.domain.model.fulfillorder.FulfillOrder;
import com.ruyuan.warehouse.rpc.request.FulfillOrderWarehouseRequest;
import org.springframework.stereotype.Component;

/**
 * @author zhonghuashishan
 * @version 1.0
 */
@Component
public class FulfillOrderWarehouseRequestConverter {

    public FulfillOrderWarehouseRequest convert(FulfillOrder fulfillOrder) {
        FulfillOrderWarehouseRequest request = new FulfillOrderWarehouseRequest();
        request.setFulfillOrderId(fulfillOrder.getFulfillId().getFulfillId());
        return request;
    }

}