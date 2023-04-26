package com.ruyuan.fulfill.domain.gateway;

import com.ruyuan.fulfill.domain.model.fulfillorder.FulfillOrder;
import com.ruyuan.fulfill.domain.model.fulfillorder.LogisticsOrder;
import com.ruyuan.fulfill.domain.model.logistics.LogisticsCompanies;
import com.ruyuan.fulfill.domain.model.warehouse.Warehouse;

/**
 * 物流api网关
 *
 * @author zhonghuashishan
 * @version 1.0
 */
public interface LogisticsApiGateway {

    /**
     * 查询所有的物流公司
     * @return
     */
    LogisticsCompanies getAll();

    /**
     * 申请物流单
     * @param logisticsCompanyId
     * @param fulfillOrder
     * @param warehouse
     * @return
     */
    LogisticsOrder applyLogisticsOrder(String logisticsCompanyId, FulfillOrder fulfillOrder, Warehouse warehouse);

}
