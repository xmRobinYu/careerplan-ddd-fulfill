package com.ruyuan.fulfill.application.command.executor;

import com.ruyuan.fulfill.application.command.GetFulfillOrderCommand;
import com.ruyuan.fulfill.application.command.dto.FulfillOrderDTO;
import com.ruyuan.fulfill.application.converter.FulfillConverter;
import com.ruyuan.fulfill.domain.model.fulfillorder.FulfillOrder;
import com.ruyuan.fulfill.domain.gateway.FulfillOrderGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zhonghuashishan
 * @version 1.0
 */
@Component
public class GetFulfillOrderCommandExecutor {

    @Autowired
    private FulfillOrderGateway fulfillOrderGateway;

    @Autowired
    private FulfillConverter fulfillConverter;

    public FulfillOrderDTO execute(GetFulfillOrderCommand getFulfillOrderCommand) {
        String orderId = getFulfillOrderCommand.getOrderId();
        FulfillOrder fulfillOrder = fulfillOrderGateway.getByFulfillId(orderId);
        // 再把领域模型层fulfill order转换为DTO对象
        return fulfillConverter.convertToFulfillOrderDTO(fulfillOrder);
    }

}
