package com.ruyuan.fulfill.domain.model.warehouse;

import com.ruyuan.fulfill.domain.gateway.WarehouseApiGateway;
import com.ruyuan.fulfill.domain.model.fulfillorder.FulfillOrder;
import com.ruyuan.fulfill.domain.model.fulfillorder.FulfillOrderItem;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 代表了一个仓库的领域模型
 */
public class Warehouse {

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

    /**
     * 判断库存是否充足
     * @param fulfillOrderItems
     * @return
     */
    public Boolean isInventoryEnough(List<FulfillOrderItem> fulfillOrderItems) {
        for(FulfillOrderItem orderItem : fulfillOrderItems) {
            int saleQuantity = orderItem.getSaleQuantity();
            int skuStock = getSkuStock(orderItem.getSkuCode());
            if(saleQuantity > skuStock ){
                return false;
            }
        }
        return true;
    }

    private Integer getSkuStock(String skuCode) {
        Integer stock = skuStockMap.get(skuCode);
        return Objects.isNull(stock) ? 0 : stock;
    }

    /**
     * 锁定库存
     * @param fulfillOrder
     * @return
     */
    public Boolean lockInventory(FulfillOrder fulfillOrder, WarehouseApiGateway warehouseGateway) {
        return warehouseGateway.lockInventory(warehouseId, fulfillOrder.getOrderId(),
                fulfillOrder.getSkuCodes(), fulfillOrder.getPurchaseCounts());
    }


    public BigDecimal getLon() {
        return lon;
    }


    public BigDecimal getLat() {
        return lat;
    }


    public String getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
    }

    public void setLon(BigDecimal lon) {
        this.lon = lon;
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
