package com.ruyuan.fulfill.infrastructure.convertor;

import com.ruyuan.fulfill.domain.model.fulfillorder.*;
import com.ruyuan.fulfill.infrastructure.gatewayimpl.database.dataobject.FulfillOrderDO;
import com.ruyuan.fulfill.infrastructure.gatewayimpl.database.dataobject.FulfillOrderItemDO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zhonghuashishan
 * @version 1.0
 */
@Mapper(componentModel = "spring")
@Component
public interface FulfillMapStructSupport {


    /**
     * 转换对象
     *
     * @param fulfillOrderDO 对象
     * @return 对象
     */
    DeliveryAddress convertToDeliveryAddress(FulfillOrderDO fulfillOrderDO);

    /**
     * 转换对象
     *
     * @param fulfillOrderDO 对象
     * @return 对象
     */
    PaymentDetail convertToPaymentDetail(FulfillOrderDO fulfillOrderDO);

    /**
     * 转换对象
     *
     * @param fulfillOrderDO 对象
     * @return 对象
     */
    FulfillOrderAudit convertToFulfillOrderAudit(FulfillOrderDO fulfillOrderDO);


    /**
     * 转换对象
     *
     * @param fulfillOrderItem 对象
     * @return 对象
     */
    FulfillOrderItem convertToFulfillOrderItem(FulfillOrderItemDO fulfillOrderItem);

    /**
     * 转换对象
     *
     * @param fulfillOrderItems 对象
     * @return 对象
     */
    List<FulfillOrderItem> convertToFulfillOrderItems(List<FulfillOrderItemDO> fulfillOrderItems);


    List<FulfillOrderItemDO> convertToFulfillOrderItemDOs(List<FulfillOrderItem> fulfillOrderItems);

}
