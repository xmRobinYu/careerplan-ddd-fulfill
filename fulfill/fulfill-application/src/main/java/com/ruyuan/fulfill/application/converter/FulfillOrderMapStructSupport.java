package com.ruyuan.fulfill.application.converter;

import com.ruyuan.fulfill.application.command.dto.OrderDTO;
import com.ruyuan.fulfill.application.command.dto.OrderItemDTO;
import com.ruyuan.fulfill.domain.event.OrderPayedEvent;
import com.ruyuan.fulfill.domain.model.fulfillorder.DeliveryAddress;
import com.ruyuan.fulfill.domain.model.fulfillorder.FulfillOrderItem;
import com.ruyuan.fulfill.domain.model.fulfillorder.PaymentDetail;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zhonghuashishan
 * @version 1.0
 */
@Mapper(componentModel = "spring")
@Component
public interface FulfillOrderMapStructSupport {

    /**
     * 转换对象
     *
     * @param event 对象
     * @return 对象
     */
    OrderDTO convertToOrderDTO(OrderPayedEvent event);

    /**
     * 转换对象
     *
     * @param orderItems 对象
     * @return 对象
     */
    List<OrderItemDTO> convertToOrderItemDTOs(List<OrderPayedEvent.OrderItem> orderItems);

    /**
     * 转换对象
     *
     * @param orderItems 对象
     * @return 对象
     */
    List<FulfillOrderItem> convertToFulfillOrderItems(List<OrderItemDTO> orderItems);
    /**
     * 转换对象
     *
     * @param orderDTO 对象
     * @return 对象
     */
    DeliveryAddress convertToDeliveryAddress(OrderDTO orderDTO);

    /**
     * 转换对象
     *
     * @param orderDTO 对象
     * @return 对象
     */
    PaymentDetail convertToPaymentDetail(OrderDTO orderDTO);

}
