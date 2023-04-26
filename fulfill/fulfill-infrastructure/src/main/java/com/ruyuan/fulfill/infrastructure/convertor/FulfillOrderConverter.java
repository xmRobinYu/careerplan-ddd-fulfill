package com.ruyuan.fulfill.infrastructure.convertor;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.ruyuan.fulfill.domain.model.fulfillorder.*;
import com.ruyuan.fulfill.infrastructure.gatewayimpl.database.dataobject.FulfillOrderDO;
import com.ruyuan.fulfill.infrastructure.gatewayimpl.database.dataobject.FulfillOrderItemDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zhonghuashishan
 * @version 1.0
 */
@Component
public class FulfillOrderConverter {

    @Autowired
    private FulfillMapStructSupport mapStructSupport;

    public FulfillOrderDO convert(FulfillOrder fulfillOrder) {

        FulfillOrderDO.FulfillOrderDOBuilder builder = FulfillOrderDO.builder()
                .userId(fulfillOrder.getUserId())
                .orderId(fulfillOrder.getOrderId())
                ;

        if (null != fulfillOrder.getFulfillId()) {
            builder.fulfillId(fulfillOrder.getFulfillId().getFulfillId());
        }

        if (null != fulfillOrder.getFulfillOrderStatus()) {
            builder.fulfillStatus(fulfillOrder.getFulfillOrderStatus().getCode());
        }

        if (null != fulfillOrder.getDeliveryAddress()) {
            builder.area(fulfillOrder.getDeliveryAddress().getArea())
                    .city(fulfillOrder.getDeliveryAddress().getCity())
                    .province(fulfillOrder.getDeliveryAddress().getProvince())
                    .street(fulfillOrder.getDeliveryAddress().getStreet())
                    .deliveryMode(fulfillOrder.getDeliveryAddress().getDeliveryMode())
                    .detailAddress(fulfillOrder.getDeliveryAddress().getDetailAddress())
                    .lat(fulfillOrder.getDeliveryAddress().getLat())
                    .lon(fulfillOrder.getDeliveryAddress().getLon())
                    .receiverName(fulfillOrder.getDeliveryAddress().getReceiverName())
                    .receiverPhone(fulfillOrder.getDeliveryAddress().getReceiverPhone());
        }

        if (null != fulfillOrder.getLogisticsOrder()) {
            builder.logisticsId(fulfillOrder.getLogisticsOrder().getLogisticsId());
        }

        if (null != fulfillOrder.getFulfillOrderAudit()) {
            builder.manualReviewStatus(fulfillOrder.getFulfillOrderAudit().getManualReviewStatus())
                    .riskStatus(fulfillOrder.getFulfillOrderAudit().getRiskStatus());
        }

        if (null != fulfillOrder.getPaymentDetail()) {
            builder.originAmount(fulfillOrder.getPaymentDetail().getOriginAmount())
                    .payAmount(fulfillOrder.getPaymentDetail().getPayAmount());
        }

        if (null != fulfillOrder.getPayType()) {
            builder.payType(fulfillOrder.getPayType().getPayType());
        }

        if (null != fulfillOrder.getFulfillOrderWarehouse()){
            builder.warehouseId(fulfillOrder.getFulfillOrderWarehouse().getWarehouseId());
        }

        return builder.build();
    }

    public FulfillOrder convert(FulfillOrderDO fulfillOrderDO, List<FulfillOrderItemDO> fulfillOrderItemDOs) {

        FulfillOrder fulfillOrder = new FulfillOrder();

        fulfillOrder.setOrderId(fulfillOrderDO.getOrderId());
        fulfillOrder.setFulfillId(FulfillId.of(fulfillOrderDO.getFulfillId(), fulfillOrderDO.getId()));

        fulfillOrder.setDeliveryAddress(mapStructSupport.convertToDeliveryAddress(fulfillOrderDO));
        fulfillOrder.setPayType(new PayType(fulfillOrderDO.getPayType()));
        fulfillOrder.setPaymentDetail(mapStructSupport.convertToPaymentDetail(fulfillOrderDO));
        fulfillOrder.setFulfillOrderStatus(FulfillOrderStatus.getByCode(fulfillOrderDO.getFulfillStatus()));
        fulfillOrder.setLogisticsOrder(new LogisticsOrder(fulfillOrderDO.getLogisticsId()));
        fulfillOrder.setFulfillOrderWarehouse(new FulfillOrderWarehouse(fulfillOrderDO.getWarehouseId()));
        fulfillOrder.setFulfillOrderAudit(mapStructSupport.convertToFulfillOrderAudit(fulfillOrderDO));
        fulfillOrder.setUserId(fulfillOrderDO.getUserId());
        if (CollectionUtils.isNotEmpty(fulfillOrderItemDOs)) {
            fulfillOrder.setFulfillOrderItems(mapStructSupport.convertToFulfillOrderItems(fulfillOrderItemDOs));
        }

        return fulfillOrder;
    }


}