package com.ruyuan.fulfill.application.command.executor;

import com.ruyuan.fulfill.application.command.dto.FulfillOrderDTO;
import com.ruyuan.fulfill.application.command.dto.InterceptedFulfillOrdersDTO;
import com.ruyuan.fulfill.application.command.query.InterceptedFulfillOrderQuery;
import com.ruyuan.fulfill.application.converter.FulfillConverter;
import com.ruyuan.fulfill.domain.model.fulfillorder.FulfillOrder;
import com.ruyuan.fulfill.domain.gateway.FulfillOrderGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 查询被风控拦截的履约单executor
 * @author zhonghuashishan
 * @version 1.0
 */
@Component
public class InterceptedFulfillOrderQueryExecutor {

    @Autowired
    private FulfillOrderGateway fulfillOrderGateway;

    @Autowired
    private FulfillConverter fulfillConverter;

    public InterceptedFulfillOrdersDTO execute() {
        List<FulfillOrder> fulfillOrders = fulfillOrderGateway.queryInterceptedFulfillOrders();

        List<FulfillOrderDTO> result = new ArrayList<>();
        fulfillOrders.forEach(fulfillOrder -> {
            result.add(fulfillConverter.convertToFulfillOrderDTO(fulfillOrder));
        });

        return new InterceptedFulfillOrdersDTO(result);
    }

}
