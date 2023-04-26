package com.ruyuan.fulfill.domain.service;

import com.ruyuan.fulfill.domain.gateway.FulfillOrderLogGateway;
import com.ruyuan.fulfill.domain.model.fulfillorder.FulfillOrder;
import com.ruyuan.fulfill.domain.model.fulfillorder.FulfillOrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 履约单操作日志领域服务
 *
 * @author zhonghuashishan
 * @version 1.0
 */
@Component
public class FulfillOrderLogDomainService {

    @Autowired
    private FulfillOrderLogGateway fulfillOrderLogGateway;

    /**
     * 插入履约单已创建记录
     *
     * @param fulfillOrder
     */
    public void saveOrderCreatedLog(FulfillOrder fulfillOrder) {
        fulfillOrderLogGateway.saveOperateLog(fulfillOrder.getFulfillId(), FulfillOrderStatus.NULL, FulfillOrderStatus.FULFILL);
    }

    /**
     * 插入履约单已分仓记录
     *
     * @param fulfillOrder
     */
    public void saveOrderWarehousedLog(FulfillOrder fulfillOrder) {
        fulfillOrderLogGateway.saveOperateLog(fulfillOrder.getFulfillId(), FulfillOrderStatus.FULFILL, FulfillOrderStatus.WAREHOUSED);
    }

    /**
     * 插入履约单分物流记录
     *
     * @param fulfillOrder
     */
    public void saveOrderLogisticsLog(FulfillOrder fulfillOrder) {
        fulfillOrderLogGateway.saveOperateLog(fulfillOrder.getFulfillId(), FulfillOrderStatus.WAREHOUSED, FulfillOrderStatus.LOGISTICS);
    }

    /**
     * 插入履约单下库房记录
     *
     * @param fulfillOrder
     */
    public void saveOrderInStoredLog(FulfillOrder fulfillOrder) {
        fulfillOrderLogGateway.saveOperateLog(fulfillOrder.getFulfillId(), FulfillOrderStatus.LOGISTICS, FulfillOrderStatus.IN_STORED);
    }

}
