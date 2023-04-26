package com.ruyuan.fulfill.rpc;

import com.ruyuan.fulfill.application.command.dto.FulfillOrderDTO;

public interface FulfillApi {

    /**
     * 通过订单号查询履约单
     */
    FulfillOrderDTO getFulfillOrderById(String orderId);
}
