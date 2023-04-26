package com.ruyuan.fulfill.infrastructure.convertor;

import com.ruyuan.fulfill.domain.model.fulfillorder.FulfillOrder;
import com.ruyuan.risk.rpc.request.FulfillOrderRiskRequest;
import org.springframework.stereotype.Component;

/**
 * @author zhonghuashishan
 * @version 1.0
 */
@Component
public class FulfillOrderRiskRequestConverter {

    public FulfillOrderRiskRequest convert(FulfillOrder fulfillOrder) {
        FulfillOrderRiskRequest request = new FulfillOrderRiskRequest();
        request.setOrderId(fulfillOrder.getOrderId());
        request.setFulfillId(fulfillOrder.getFulfillId().getFulfillId());
        return request;
    }

}