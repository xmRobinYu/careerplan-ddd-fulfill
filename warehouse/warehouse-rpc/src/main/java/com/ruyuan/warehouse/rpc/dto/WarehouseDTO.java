package com.ruyuan.warehouse.rpc.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Map;

/**
 * @author zhonghuashishan
 * @version 1.0
 */
public class WarehouseDTO implements Serializable {

    private static final long serialVersionUID = -5556639267989370201L;

    /**
     * 仓库id
     */
    private String warehouseId;

    /**
     * 经度 六位小数点
     */
    private BigDecimal lon;

    /**
     * 纬度 六位小数点
     */
    private BigDecimal lat;

    /**
     * sku库存map
     */
    private Map<String, Integer> skuStockMap;

    public String getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
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

    public Map<String, Integer> getSkuStockMap() {
        return skuStockMap;
    }

    public void setSkuStockMap(Map<String, Integer> skuStockMap) {
        this.skuStockMap = skuStockMap;
    }
}