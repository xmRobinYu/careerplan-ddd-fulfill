package com.ruyuan.fulfill.application.command.executor;

import com.alibaba.fastjson.JSONObject;
import com.ruyuan.fulfill.application.command.AuditInterceptedFulfillOrderCommand;
import com.ruyuan.fulfill.application.command.dto.InterceptedFulfillOrderAuditResultDTO;
import com.ruyuan.fulfill.domain.event.OrderFulfillDeniedEvent;
import com.ruyuan.fulfill.domain.gateway.DomainEventGateway;
import com.ruyuan.fulfill.domain.gateway.FulfillOrderGateway;
import com.ruyuan.fulfill.domain.gateway.WarehouseApiGateway;
import com.ruyuan.fulfill.domain.model.fulfillorder.FulfillOrder;
import com.ruyuan.fulfill.domain.model.warehouse.Warehouse;
import com.ruyuan.fulfill.domain.service.FulfillOrderLogDomainService;
import com.ruyuan.fulfill.domain.service.LogisticsDomainService;
import com.ruyuan.fulfill.domain.service.WarehouseDomainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Slf4j
public class AuditInterceptedFulfillOrderCommandExecutor {

    @Autowired
    private LogisticsDomainService logisticsDomainService;
    @Autowired
    private FulfillOrderGateway fulfillOrderGateway;
    @Autowired
    private WarehouseApiGateway warehouseApiGateway;
    @Autowired
    private DomainEventGateway domainEventGateway;
    @Autowired
    private WarehouseDomainService warehouseDomainService;
    @Autowired
    private FulfillOrderLogDomainService fulfillOrderLogDomainService;

    @Transactional(rollbackFor = Exception.class)
    public void execute(AuditInterceptedFulfillOrderCommand auditInterceptedFulfillOrderCommand) {
        // 1、先提取审核数据
        InterceptedFulfillOrderAuditResultDTO interceptedFulfillOrderAuditResultDTO =
                auditInterceptedFulfillOrderCommand.getInterceptedFulfillOrderAuditResultDTO();
        String fulfillId = interceptedFulfillOrderAuditResultDTO.getFulfillId();
        Boolean auditResult = interceptedFulfillOrderAuditResultDTO.getAuditResult();

        // 2、查询履约单实体
        FulfillOrder fulfillOrder = fulfillOrderGateway.getByFulfillId(fulfillId);
        fulfillOrder.setFulfillOrderGateway(fulfillOrderGateway);

        // 3、如果审核通过了，则分物流和下库房
        if (auditResult) {
            fulfillOrder.manualReviewPass();
            log.info("查询fulfillOrder实体:{}", JSONObject.toJSONString(fulfillOrder));

            Warehouse warehouse = warehouseDomainService.preAllocateWarehouse(fulfillOrder);
            log.info("预分仓:{}", JSONObject.toJSONString(fulfillOrder.getFulfillOrderWarehouse().getWarehouseId()));
            fulfillOrderLogDomainService.saveOrderWarehousedLog(fulfillOrder);

            logisticsDomainService.allocateLogistics(fulfillOrder, warehouse);
            log.info("分物流:{}", fulfillOrder.getLogisticsOrder().getLogisticsId());
            fulfillOrderLogDomainService.saveOrderLogisticsLog(fulfillOrder);

            warehouseApiGateway.sendFulfillOrder(fulfillOrder, warehouse);
            fulfillOrderLogDomainService.saveOrderInStoredLog(fulfillOrder);
            log.info("下发库房");
        }
        // 4、如果审核没通过，则发布订单履约被拒绝的领域事件
        else {
            fulfillOrder.manualReviewReject();
            OrderFulfillDeniedEvent orderFulfillDeniedEvent = new OrderFulfillDeniedEvent(fulfillId);
            domainEventGateway.publishOrderFulfillDeniedEvent(orderFulfillDeniedEvent);
        }
    }

}
