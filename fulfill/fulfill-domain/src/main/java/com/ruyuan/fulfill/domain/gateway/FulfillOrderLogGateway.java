package com.ruyuan.fulfill.domain.gateway;

import com.ruyuan.fulfill.domain.model.fulfillorder.FulfillOrderStatus;
import com.ruyuan.fulfill.domain.model.fulfillorder.FulfillId;


/**
 *
 * 履约订单操作日志Gateway接口
 *
 * @author zhonghuashishan
 * @version 1.0
 */
public interface FulfillOrderLogGateway {

    /**
     * 保存操作日志
     * @param fulfillID
     * @param fromStatus
     * @param toStatus
     */
    void saveOperateLog(FulfillId fulfillID, FulfillOrderStatus fromStatus, FulfillOrderStatus toStatus);
}
