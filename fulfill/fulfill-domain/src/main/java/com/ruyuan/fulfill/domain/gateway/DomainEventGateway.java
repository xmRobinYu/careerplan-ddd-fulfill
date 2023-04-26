package com.ruyuan.fulfill.domain.gateway;

import com.ruyuan.fulfill.domain.event.OrderFulfillDeniedEvent;
import com.ruyuan.fulfill.domain.event.OrderInterceptedEvent;

/**
 * 领域事件网关
 * @author zhonghuashishan
 * @version 1.0
 */
public interface DomainEventGateway {

    /**
     * 发送订单风控被拦截事件
     * @param orderInterceptedEvent
     */
    void publishOrderInterceptedEvent(
            OrderInterceptedEvent orderInterceptedEvent);

    /**
     * 发送订单履约被拒绝领域事件
     * @param orderFulfillDeniedEvent
     */
    void publishOrderFulfillDeniedEvent(
            OrderFulfillDeniedEvent orderFulfillDeniedEvent);

}
