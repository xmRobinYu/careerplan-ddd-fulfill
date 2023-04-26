package com.ruyuan.fulfill.application.converter;

import com.ruyuan.fulfill.application.command.dto.FulfillOrderDTO;
import com.ruyuan.fulfill.domain.model.fulfillorder.FulfillOrder;
import org.springframework.stereotype.Component;

/**
 * @author zhonghuashishan
 * @version 1.0
 */
@Component
public class FulfillConverter {


    public FulfillOrderDTO convertToFulfillOrderDTO(FulfillOrder fulfillOrder) {

        FulfillOrderDTO fulfillOrderDTO = FulfillOrderDTO.builder()
                .orderId(fulfillOrder.getOrderId())
                .fulfillId(fulfillOrder.getFulfillId().getFulfillId())
                .fulfillStatus(fulfillOrder.getFulfillOrderStatus().getCode())
                .area(fulfillOrder.getDeliveryAddress().getArea())
                .city(fulfillOrder.getDeliveryAddress().getCity())
                .province(fulfillOrder.getDeliveryAddress().getProvince())
                .street(fulfillOrder.getDeliveryAddress().getStreet())
                .deliveryMode(fulfillOrder.getDeliveryAddress().getDeliveryMode())
                .detailAddress(fulfillOrder.getDeliveryAddress().getDetailAddress())
                .lat(fulfillOrder.getDeliveryAddress().getLat())
                .lon(fulfillOrder.getDeliveryAddress().getLon())
                .receiverName(fulfillOrder.getDeliveryAddress().getReceiverName())
                .receiverPhone(fulfillOrder.getDeliveryAddress().getReceiverPhone())
                .logisticsId(fulfillOrder.getLogisticsOrder().getLogisticsId())
                .manualReviewStatus(fulfillOrder.getFulfillOrderAudit().getManualReviewStatus())
                .riskStatus(fulfillOrder.getFulfillOrderAudit().getRiskStatus())
                .originAmount(fulfillOrder.getPaymentDetail().getOriginAmount())
                .payAmount(fulfillOrder.getPaymentDetail().getPayAmount())
                .payType(fulfillOrder.getPayType().getPayType())
                .userId(fulfillOrder.getUserId())
                .warehouseId(fulfillOrder.getFulfillOrderWarehouse().getWarehouseId())
                .build();

        return fulfillOrderDTO;

    }

}
