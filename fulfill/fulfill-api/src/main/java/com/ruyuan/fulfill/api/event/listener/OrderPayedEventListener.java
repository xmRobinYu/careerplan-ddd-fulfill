package com.ruyuan.fulfill.api.event.listener;

import com.alibaba.fastjson.JSONObject;
import com.ruyuan.fulfill.application.command.OrderFulfillCommand;
import com.ruyuan.fulfill.application.command.dto.OrderDTO;
import com.ruyuan.fulfill.application.command.dto.OrderItemDTO;
import com.ruyuan.fulfill.application.converter.FulfillOrderMapStructSupport;
import com.ruyuan.fulfill.application.service.FulfillApplicationService;
import com.ruyuan.fulfill.domain.event.OrderPayedEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 订单已支付领域事件的消费者
 */
@Component
@Slf4j
public class OrderPayedEventListener implements MessageListenerConcurrently {

    // 具体的消费逻辑，就应该依赖你具体的MQ的技术来做一个实现就可以了
    // 正常他会自己有一个启动，启动了之后，在这里应该会去启动一个consumer，监听指定的mq里的topic
    // 在这里可以开发具体的mq消费监听的处理逻辑
    // 拿到了对应的消息之后，此时就可以交给我们对应的event handler来做一个处理就可以了

    @Autowired
    private FulfillApplicationService fulfillApplicationService;

    @Autowired
    private FulfillOrderMapStructSupport fulFillMapStructSupport;


    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
        try {
            for (MessageExt messageExt : list) {
                String message = new String(messageExt.getBody());
                log.info("OrderPayedEventListener message:{}", message);

                // 1、将message转化为OrderPayedEvent领域事件
                OrderPayedEvent orderPayedEvent = JSONObject.parseObject(message, OrderPayedEvent.class);

                // 2、把领域事件，转换为一个command
                OrderFulfillCommand orderFulfillCommand = buildCommand(orderPayedEvent);

                // 3、交给app层的应用服务逻辑，去推动命令的流程编排和执行
                fulfillApplicationService.executeOrderFulfill(orderFulfillCommand);
            }
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        } catch (Exception e) {
            log.error("consumer error", e);
            return ConsumeConcurrentlyStatus.RECONSUME_LATER;
        }
    }

    private OrderFulfillCommand buildCommand(OrderPayedEvent orderPayedEvent) {
        OrderDTO order = fulFillMapStructSupport.convertToOrderDTO(orderPayedEvent);
        List<OrderItemDTO> orderItems = fulFillMapStructSupport.convertToOrderItemDTOs(orderPayedEvent.getOrderItems());
        return new OrderFulfillCommand(order, orderItems);
    }


}
