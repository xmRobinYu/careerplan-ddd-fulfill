package com.ruyuan.fulfill.infrastructure.gatewayimpl;

import com.alibaba.fastjson.JSONObject;
import com.ruyuan.fulfill.domain.event.OrderFulfillDeniedEvent;
import com.ruyuan.fulfill.domain.event.OrderInterceptedEvent;
import com.ruyuan.fulfill.domain.gateway.DomainEventGateway;
import com.ruyuan.fulfill.infrastructure.gatewayimpl.mq.RocketMQProducer;
import com.ruyuan.fulfill.infrastructure.common.RocketMqConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DomainEventGatewayImpl implements DomainEventGateway {

    @Autowired
    private RocketMQProducer rocketMQProducer;

    @Override
    public void publishOrderInterceptedEvent(OrderInterceptedEvent orderInterceptedEvent) {
        // 把订单被拦截的事件，转换为对应的mq message消息
        String message = JSONObject.toJSONString(orderInterceptedEvent);
        rocketMQProducer.sendMessage(RocketMqConstant.ORDER_INTERCEPTED_EVENT_TOPIC, message, "订单被风控拦截的领域事件");
    }

    @Override
    public void publishOrderFulfillDeniedEvent(OrderFulfillDeniedEvent orderFulfillDeniedEvent) {
        // 把订单被拦截的事件，转换为对应的mq message消息
        String message = JSONObject.toJSONString(orderFulfillDeniedEvent);
        rocketMQProducer.sendMessage(RocketMqConstant.ORDER_FULFILL_DENIED_EVENT_TOPIC, message, "订单履约被拒绝的领域事件");
    }

}
