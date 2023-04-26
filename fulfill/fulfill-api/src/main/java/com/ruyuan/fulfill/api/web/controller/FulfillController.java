package com.ruyuan.fulfill.api.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.ruyuan.fulfill.api.web.request.AuditInterceptedFulfillOrderRequest;
import com.ruyuan.fulfill.api.web.response.AuditInterceptedFulfillOrderResponse;
import com.ruyuan.fulfill.api.web.response.QueryInterceptedFulfillOrderResponse;
import com.ruyuan.fulfill.application.command.AuditInterceptedFulfillOrderCommand;
import com.ruyuan.fulfill.application.command.dto.InterceptedFulfillOrderAuditResultDTO;
import com.ruyuan.fulfill.application.command.dto.InterceptedFulfillOrdersDTO;
import com.ruyuan.fulfill.application.service.FulfillApplicationService;
import com.ruyuan.fulfill.domain.event.OrderPayedEvent;
import com.ruyuan.fulfill.infrastructure.common.RocketMqConstant;
import com.ruyuan.fulfill.infrastructure.gatewayimpl.mq.RocketMQProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class FulfillController {

    @Autowired
    private FulfillApplicationService fulfillApplicationService;

    @Autowired
    private RocketMQProducer rocketMQProducer;


    /**
     * 查询被风控拦截的履约单
     *
     * @return
     */
    @GetMapping(value = "/fulfill/order/intercepted")
    public QueryInterceptedFulfillOrderResponse queryInterceptedFulfillOrder() {

        // 调用app service
        InterceptedFulfillOrdersDTO interceptedFulfillOrdersDTO =
                fulfillApplicationService.executeInterceptedFulfillOrderQuery();

        // 对app层返回的结果dto，转化为web response，再返回给请求者
        QueryInterceptedFulfillOrderResponse queryInterceptedFulfillOrderResponse =
                new QueryInterceptedFulfillOrderResponse(interceptedFulfillOrdersDTO.getFulfillOrders());
        return queryInterceptedFulfillOrderResponse;
    }

    /**
     * 审核被风控拦截的履约单
     *
     * @param request
     * @return
     */
    @PostMapping(value = "/fulfill/order/intercepted/audit")
    public AuditInterceptedFulfillOrderResponse auditInterceptedFulfillOrder(
            @RequestBody AuditInterceptedFulfillOrderRequest request) {

        log.info("审核被风控拦截的履约单:{}", JSONObject.toJSONString(request));

        // 1、要把web request转换为app层的command
        AuditInterceptedFulfillOrderCommand auditInterceptedFulfillOrderCommand =
                new AuditInterceptedFulfillOrderCommand(new InterceptedFulfillOrderAuditResultDTO(request.getFulfillId(), request.getAuditResult()));

        // 2、调用app层
        fulfillApplicationService.executeAuditInterceptedFulfillOrderCommand(
                auditInterceptedFulfillOrderCommand);

        return new AuditInterceptedFulfillOrderResponse();
    }

    /**
     * 模拟发送订单已支付事件消息
     * @param orderId
     * @return
     */
    @GetMapping(value = "/fulfill/orderPayedEvent/mock")
    public Boolean mockOrderPayedEvent(String orderId) {

        OrderPayedEvent event = OrderPayedEvent.builder()
                .orderId(orderId)
                .orderType(1)
                .userId("110")
                .deliveryMode(1)
                .receiverName("张三")
                .phone("1111111111")
                .province("110000")
                .area("110100")
                .area("110105")
                .street("110101007")
                .detailAddress("北京路10号")
                .lon(new BigDecimal(100.10000))
                .lat(new BigDecimal(1010.201010))
                .payType(10)
                .payAmount(10000)
                .originAmount(10000)
                .orderItems(mockOrderItem())
                .build();

        rocketMQProducer.sendMessage(RocketMqConstant.ORDER_PAID_EVENT_TOPIC, JSONObject.toJSONString(event), "订单已支付消息");

        return true;
    }

    private List<OrderPayedEvent.OrderItem> mockOrderItem() {

        List<OrderPayedEvent.OrderItem> list = new ArrayList<>();

        OrderPayedEvent.OrderItem orderItem = new OrderPayedEvent.OrderItem();
        orderItem.setOriginAmount(10000);
        orderItem.setPayAmount(10000);
        orderItem.setSalePrice(1000);
        orderItem.setSaleQuantity(10);
        orderItem.setSkuCode("skuCode001");
        list.add(orderItem);

        return list;
    }

}
