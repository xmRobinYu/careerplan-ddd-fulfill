package com.ruyuan.fulfill.domain.gateway;

import com.ruyuan.fulfill.domain.model.fulfillorder.*;
import com.ruyuan.fulfill.domain.model.warehouse.Warehouse;

import java.util.List;


/**
 *
 * 履约订单Gateway接口
 *
 * @author zhonghuashishan
 * @version 1.0
 */
public interface FulfillOrderGateway {

    void save(FulfillOrder fulfillOrder);

    void saveAllocatedWarehouse(FulfillOrder fulfillOrder,
                                       Warehouse warehouse);

    void saveAllocatedLogisticsOrder(FulfillOrder fulfillOrder,
                                     LogisticsOrder logisticsOrder);

    List<FulfillOrder> queryInterceptedFulfillOrders();

    FulfillOrder getByFulfillId(String fulfillId);

    void updateRiskStatus(FulfillId fulfillId, Integer status);

    void updateManualReviewStatus(FulfillId fulfillId, Integer status);
}
