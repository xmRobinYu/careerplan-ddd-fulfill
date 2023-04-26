package com.ruyuan.fulfill.application.service;

import com.ruyuan.fulfill.application.command.AuditInterceptedFulfillOrderCommand;
import com.ruyuan.fulfill.application.command.GetFulfillOrderCommand;
import com.ruyuan.fulfill.application.command.OrderFulfillCommand;
import com.ruyuan.fulfill.application.command.dto.FulfillOrderDTO;
import com.ruyuan.fulfill.application.command.dto.InterceptedFulfillOrdersDTO;
import com.ruyuan.fulfill.application.command.executor.AuditInterceptedFulfillOrderCommandExecutor;
import com.ruyuan.fulfill.application.command.executor.GetFulfillOrderCommandExecutor;
import com.ruyuan.fulfill.application.command.executor.InterceptedFulfillOrderQueryExecutor;
import com.ruyuan.fulfill.application.command.executor.OrderFulfillCommandExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 履约应用服务
 *
 * @author zhonghuashishan
 * @version 1.0
 */
@Component
public class FulfillApplicationService {

    @Autowired
    private OrderFulfillCommandExecutor orderFulfillCommandExecutor;
    @Autowired
    private InterceptedFulfillOrderQueryExecutor interceptedFulfillOrderQueryExecutor;
    @Autowired
    private AuditInterceptedFulfillOrderCommandExecutor auditInterceptedFulfillOrderCommandExecutor;
    @Autowired
    private GetFulfillOrderCommandExecutor getFulfillOrderCommandExecutor;

    public void executeOrderFulfill(OrderFulfillCommand orderFulfillCommand) {
        orderFulfillCommandExecutor.execute(orderFulfillCommand);
    }

    public InterceptedFulfillOrdersDTO executeInterceptedFulfillOrderQuery() {
        return interceptedFulfillOrderQueryExecutor.execute();
    }

    public void executeAuditInterceptedFulfillOrderCommand(
            AuditInterceptedFulfillOrderCommand auditInterceptedFulfillOrderCommand) {
        auditInterceptedFulfillOrderCommandExecutor.execute(
                auditInterceptedFulfillOrderCommand);
    }

    public FulfillOrderDTO executeGetFulfillOrderCommand(GetFulfillOrderCommand getFulfillOrderCommand) {
        return getFulfillOrderCommandExecutor.execute(getFulfillOrderCommand);
    }
}
