package com.ruyuan.fulfill.infrastructure.gatewayimpl;

import com.ruyuan.fulfill.domain.gateway.FulfillOrderGateway;
import com.ruyuan.fulfill.domain.model.fulfillorder.FulfillId;
import com.ruyuan.fulfill.domain.model.fulfillorder.FulfillOrder;
import com.ruyuan.fulfill.domain.model.fulfillorder.FulfillOrderWarehouse;
import com.ruyuan.fulfill.domain.model.fulfillorder.LogisticsOrder;
import com.ruyuan.fulfill.domain.model.warehouse.Warehouse;
import com.ruyuan.fulfill.infrastructure.convertor.FulfillMapStructSupport;
import com.ruyuan.fulfill.infrastructure.convertor.FulfillOrderConverter;
import com.ruyuan.fulfill.infrastructure.gatewayimpl.database.dao.FulfillOrderDAO;
import com.ruyuan.fulfill.infrastructure.gatewayimpl.database.dao.FulfillOrderItemDAO;
import com.ruyuan.fulfill.infrastructure.gatewayimpl.database.dataobject.FulfillOrderDO;
import com.ruyuan.fulfill.infrastructure.gatewayimpl.database.dataobject.FulfillOrderItemDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
public class FulfillOrderGatewayImpl implements FulfillOrderGateway {

    @Autowired
    private FulfillOrderConverter fulfillOrderDOConverter;

    @Autowired
    private FulfillMapStructSupport mapStructSupport;

    @Resource
    private FulfillOrderDAO fulfillOrderDAO;

    @Autowired
    private FulfillOrderItemDAO fulfillOrderItemDAO;

    @Autowired
    private FulfillOrderConverter fulfillOrderConverter;

    @Override
    public void save(FulfillOrder fulfillOrder) {
        FulfillOrderDO fulfillOrderDO = fulfillOrderDOConverter.convert(fulfillOrder);
        List<FulfillOrderItemDO> fulfillOrderItemDOs = mapStructSupport.convertToFulfillOrderItemDOs(fulfillOrder.getFulfillOrderItems());

        fulfillOrderDAO.save(fulfillOrderDO);
        fulfillOrderItemDAO.saveBatch(fulfillOrderItemDOs);
    }

    @Override
    public void saveAllocatedWarehouse(FulfillOrder fulfillOrder, Warehouse warehouse) {
        fulfillOrderDAO.saveAllocatedWarehouse(fulfillOrder.getFulfillId().getFulfillId(),warehouse.getWarehouseId());
        fulfillOrder.setFulfillOrderWarehouse(new FulfillOrderWarehouse(warehouse.getWarehouseId()));
    }

    @Override
    public void saveAllocatedLogisticsOrder(FulfillOrder fulfillOrder, LogisticsOrder logisticsOrder) {
        fulfillOrderDAO.saveLogisticsOrder(fulfillOrder.getFulfillId().getFulfillId(),logisticsOrder.getLogisticsId());
        fulfillOrder.setLogisticsOrder(new LogisticsOrder(logisticsOrder.getLogisticsId()));
    }

    @Override
    public List<FulfillOrder> queryInterceptedFulfillOrders() {
        List<FulfillOrderDO> list = fulfillOrderDAO.queryInterceptedFulfillOrders();
        List<FulfillOrder> result = new ArrayList<>();

        list.forEach(order->{
            result.add(fulfillOrderConverter.convert(order,null));
        });

        return result;
    }

    @Override
    public FulfillOrder getByFulfillId(String fulfillId) {
        FulfillOrderDO fulfillOrderDO = fulfillOrderDAO.getByFulfillId(fulfillId);
        if(fulfillOrderDO == null) {
            return null;
        }
        List<FulfillOrderItemDO> fulfillOrderItems = fulfillOrderItemDAO.listByFulfillId(fulfillId);
        return fulfillOrderConverter.convert(fulfillOrderDO,fulfillOrderItems);
    }

    @Override
    public void updateRiskStatus(FulfillId fulfillId, Integer status) {
        fulfillOrderDAO.updateRiskStatus(fulfillId.getFulfillId(),status);
    }

    @Override
    public void updateManualReviewStatus(FulfillId fulfillId, Integer status) {
        fulfillOrderDAO.updateManualReviewStatus(fulfillId.getFulfillId(),status);
    }
}
