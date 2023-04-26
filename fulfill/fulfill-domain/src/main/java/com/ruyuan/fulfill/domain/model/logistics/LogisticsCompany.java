package com.ruyuan.fulfill.domain.model.logistics;

import com.ruyuan.fulfill.domain.gateway.LogisticsApiGateway;
import com.ruyuan.fulfill.domain.model.fulfillorder.FulfillOrder;
import com.ruyuan.fulfill.domain.model.fulfillorder.LogisticsOrder;
import com.ruyuan.fulfill.domain.model.warehouse.Warehouse;

import java.math.BigDecimal;

/**
 * @author zhonghuashishan
 * @version 1.0
 */
public class LogisticsCompany {

    /**
     * 物流公司ID
     */
    private String logisticsCompanyId;

    /**
     * 物流api网关
     */
    private LogisticsApiGateway logisticsApiGateway;

    /**
     * 经度 六位小数点
     */
    private BigDecimal lon;

    /**
     * 纬度 六位小数点
     */
    private BigDecimal lat;


    /**
     * 申请物流单
     * @param fulfillOrder
     * @param warehouse
     * @return
     */
    public LogisticsOrder applyLogisticsOrder(FulfillOrder fulfillOrder,
                                              Warehouse warehouse) {
        return logisticsApiGateway.applyLogisticsOrder(logisticsCompanyId,fulfillOrder, warehouse);
    }

    public void setLogisticsApiGateway(LogisticsApiGateway logisticsApiGateway) {
        this.logisticsApiGateway = logisticsApiGateway;
    }

    public String getLogisticsCompanyId() {
        return logisticsCompanyId;
    }

    public void setLogisticsCompanyId(String logisticsCompanyId) {
        this.logisticsCompanyId = logisticsCompanyId;
    }

    public BigDecimal getLon() {
        return lon;
    }

    public void setLon(BigDecimal lon) {
        this.lon = lon;
    }

    public BigDecimal getLat() {
        return lat;
    }

    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }
}
