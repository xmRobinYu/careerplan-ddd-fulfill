package com.ruyuan.fulfill.application.factory;

import com.ruyuan.fulfill.application.command.OrderFulfillCommand;
import com.ruyuan.fulfill.application.command.dto.OrderDTO;
import com.ruyuan.fulfill.application.converter.FulfillOrderMapStructSupport;
import com.ruyuan.fulfill.domain.gateway.FulfillOrderGateway;
import com.ruyuan.fulfill.domain.model.fulfillorder.FulfillId;
import com.ruyuan.fulfill.domain.model.fulfillorder.FulfillOrder;
import com.ruyuan.fulfill.domain.model.fulfillorder.FulfillOrderStatus;
import com.ruyuan.fulfill.domain.model.fulfillorder.PayType;
import com.ruyuan.fulfill.infrastructure.common.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 履约单工厂
 * @author zhonghuashishan
 * @version 1.0
 */
@Component
public class FulfillOrderFactory {

    @Autowired
    private FulfillOrderGateway fulfillOrderGateway;

    @Autowired
    private FulfillOrderMapStructSupport fulfillOrderMapStructSupport;

    /**
     * 创建履约单实体
     * @param command
     * @return
     */
    public FulfillOrder createFulfillOrder(OrderFulfillCommand command) {
        OrderDTO order = command.getOrder();
        FulfillOrder fulfillOrder = new FulfillOrder();

        fulfillOrder.setOrderId(order.getOrderId());
        // 生成订单ID
        fulfillOrder.setFulfillId(FulfillId.of(genFulfillId()));

        // 设置履约单条目
        fulfillOrder.setFulfillOrderItems(fulfillOrderMapStructSupport.convertToFulfillOrderItems(command.getOrderItems()));
        fulfillOrder.getFulfillOrderItems().forEach(item->{
            item.setOrderId(order.getOrderId());
            item.setFulfillId(fulfillOrder.getFulfillId().getFulfillId());
        });

        // 设置配送地址
        fulfillOrder.setDeliveryAddress(fulfillOrderMapStructSupport.convertToDeliveryAddress(order));

        // 设置支付类型
        fulfillOrder.setPayType(new PayType(order.getPayType()));

        // 设置支付信息
        fulfillOrder.setPaymentDetail(fulfillOrderMapStructSupport.convertToPaymentDetail(order));

        // 设置履约单状态
        fulfillOrder.setFulfillOrderStatus(FulfillOrderStatus.FULFILL);

        fulfillOrder.setFulfillOrderGateway(fulfillOrderGateway);

        return fulfillOrder;
    }


    /**
     * 生成履约单id
     *
     * @return
     */
    private String genFulfillId() {
        return RandomUtil.genRandomNumber(10);
    }

}
