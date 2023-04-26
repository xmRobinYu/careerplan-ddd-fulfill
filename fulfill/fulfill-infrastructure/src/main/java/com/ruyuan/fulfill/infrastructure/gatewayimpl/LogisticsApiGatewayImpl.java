package com.ruyuan.fulfill.infrastructure.gatewayimpl;

import com.ruyuan.fulfill.domain.gateway.LogisticsApiGateway;
import com.ruyuan.fulfill.domain.model.fulfillorder.FulfillOrder;
import com.ruyuan.fulfill.domain.model.fulfillorder.LogisticsOrder;
import com.ruyuan.fulfill.domain.model.logistics.LogisticsCompanies;
import com.ruyuan.fulfill.domain.model.warehouse.Warehouse;
import com.ruyuan.fulfill.infrastructure.convertor.LogisticsCompaniesConverter;
import com.ruyuan.fulfill.infrastructure.convertor.LogisticsOrderConverter;
import com.ruyuan.logistics.rpc.LogisticsApi;
import com.ruyuan.logistics.rpc.dto.LogisticsCompaniesDTO;
import com.ruyuan.logistics.rpc.dto.LogisticsOrderDTO;
import com.ruyuan.logistics.rpc.request.ApplyLogisticsOrderRequest;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LogisticsApiGatewayImpl implements LogisticsApiGateway {

    @DubboReference(version = "1.0.0", retries = 0)
    private LogisticsApi logisticsApi;

    @Autowired
    private LogisticsCompaniesConverter logisticsCompaniesConverter;

    @Autowired
    private LogisticsOrderConverter logisticsOrderConverter;

    @Override
    public LogisticsCompanies getAll() {
        LogisticsCompaniesDTO logisticsCompaniesDTO = logisticsApi.getAll();
        return logisticsCompaniesConverter.convert(logisticsCompaniesDTO);
    }

    @Override
    public LogisticsOrder applyLogisticsOrder(String logisticsCompanyId, FulfillOrder fulfillOrder, Warehouse warehouse) {
        ApplyLogisticsOrderRequest applyLogisticsOrderRequest = new ApplyLogisticsOrderRequest();
        applyLogisticsOrderRequest.setLogisticsCompanyId(logisticsCompanyId);
        applyLogisticsOrderRequest.setFulfillOrderId(fulfillOrder.getFulfillId().getFulfillId());
        applyLogisticsOrderRequest.setWarehouseId(warehouse.getWarehouseId());
        LogisticsOrderDTO logisticsOrderDTO = logisticsApi.applyLogisticsOrder(applyLogisticsOrderRequest);
        return logisticsOrderConverter.convert(logisticsOrderDTO);
    }

}
