package com.ruyuan.fulfill.application.command.executor;

import com.alibaba.fastjson.JSONObject;
import com.ruyuan.fulfill.application.command.OrderFulfillCommand;
import com.ruyuan.fulfill.application.converter.FulfillConverter;
import com.ruyuan.fulfill.application.factory.FulfillOrderFactory;
import com.ruyuan.fulfill.domain.event.OrderInterceptedEvent;
import com.ruyuan.fulfill.domain.gateway.*;
import com.ruyuan.fulfill.domain.model.fulfillorder.FulfillOrder;
import com.ruyuan.fulfill.domain.service.FulfillOrderLogDomainService;
import com.ruyuan.fulfill.domain.service.LogisticsDomainService;
import com.ruyuan.fulfill.domain.service.WarehouseDomainService;
import com.ruyuan.fulfill.domain.model.warehouse.Warehouse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 订单履约命令（流程）的执行器
 */
@Component
@Slf4j
public class OrderFulfillCommandExecutor {

    @Autowired
    private FulfillConverter fulfillConverter;
    @Autowired
    private FulfillOrderFactory fulfillOrderFactory;
    @Autowired
    private FulfillOrderGateway fulfillOrderGateway;
    @Autowired
    private WarehouseDomainService warehouseDomainService;
    @Autowired
    private RiskControlApiGateway riskControlApiGateway;
    @Autowired
    private DomainEventGateway domainEventGateway;
    @Autowired
    private LogisticsDomainService logisticsDomainService;
    @Autowired
    private WarehouseApiGateway warehouseApiGateway;
    @Autowired
    private FulfillOrderLogDomainService fulfillOrderLogDomainService;

    // 专门负责订单履约流程的编排，把这个流程按照战术建模的设计，完成落地开发
    @Transactional(rollbackFor = Exception.class)
    public void execute(OrderFulfillCommand orderFulfillCommand) {
        // 第一步，保存订单，需要去使用履约订单仓储/gateway来进行保存
        FulfillOrder fulfillOrder = fulfillOrderFactory.createFulfillOrder(orderFulfillCommand);
        log.info("创建fulfillOrder实体：{}", JSONObject.toJSONString(fulfillOrder));
        fulfillOrderGateway.save(fulfillOrder);
        fulfillOrderLogDomainService.saveOrderCreatedLog(fulfillOrder);


        // 第二步，风控拦截
         Boolean interceptResult = riskControlApiGateway.riskControlIntercept(fulfillOrder);
//        Boolean interceptResult = true;
        log.info("风控拦截：{}", JSONObject.toJSONString(interceptResult));
        if (!interceptResult) {
            fulfillOrder.riskReject();
            // 如果被风控拦截了，此时就需要发布订单被拦截的领域事件，通知人工审核
            domainEventGateway.publishOrderInterceptedEvent(new OrderInterceptedEvent(fulfillOrder.getFulfillId().getFulfillId()));
            return;
        }else {
            fulfillOrder.riskPass();
        }

        // 第三步，预分仓
        Warehouse warehouse = warehouseDomainService.preAllocateWarehouse(fulfillOrder);
        log.info("预分仓：{}", JSONObject.toJSONString(fulfillOrder.getFulfillOrderWarehouse().getWarehouseId()));
        fulfillOrderLogDomainService.saveOrderWarehousedLog(fulfillOrder);

        // 第四步，分物流
        logisticsDomainService.allocateLogistics(fulfillOrder, warehouse);
        fulfillOrderLogDomainService.saveOrderLogisticsLog(fulfillOrder);
        log.info("分物流：{}",fulfillOrder.getLogisticsOrder().getLogisticsId());

        // 第五步，下发库房
        warehouseApiGateway.sendFulfillOrder(fulfillOrder, warehouse);
        fulfillOrderLogDomainService.saveOrderInStoredLog(fulfillOrder);
        log.info("下发库房");
    }


}
