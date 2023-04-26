package com.ruyuan.fulfill.api.rpc.service;

import com.ruyuan.fulfill.application.command.GetFulfillOrderCommand;
import com.ruyuan.fulfill.application.command.dto.FulfillOrderDTO;
import com.ruyuan.fulfill.application.service.FulfillApplicationService;
import com.ruyuan.fulfill.converter.FulFillConverter;
import com.ruyuan.fulfill.rpc.FulfillApi;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zhonghuashishan
 * @version 1.0
 */
@Slf4j
@DubboService(version = "1.0.0", interfaceClass = FulfillApi.class, retries = 0)
public class FulfillApiImpl implements FulfillApi {

    @Autowired
    private FulfillApplicationService fulfillApplicationService;

    @Autowired
    private FulFillConverter fulFillConverter;

    @Override
    public FulfillOrderDTO getFulfillOrderById(String orderId) {
        GetFulfillOrderCommand getFulfillOrderCommand = new GetFulfillOrderCommand(orderId);
        FulfillOrderDTO fulfillOrderDTO = fulfillApplicationService.executeGetFulfillOrderCommand(getFulfillOrderCommand);
        return fulfillOrderDTO;
    }
}
