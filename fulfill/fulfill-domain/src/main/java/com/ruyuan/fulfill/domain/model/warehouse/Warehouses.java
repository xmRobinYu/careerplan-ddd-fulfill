package com.ruyuan.fulfill.domain.model.warehouse;

import com.ruyuan.fulfill.domain.model.fulfillorder.DeliveryAddress;
import com.ruyuan.fulfill.domain.service.CalculateDistanceService;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 代表了仓库集合的领域模型
 */
public class Warehouses {

    /**
     * 仓库
     */
    private List<Warehouse> warehouses;


    /**
     * 查询最近一个仓库
     * @param deliveryAddress
     * @return
     */
    public Warehouse selectNearest(DeliveryAddress deliveryAddress, CalculateDistanceService calculateDistanceService) {

        if(warehouses.size() == 1) {
            return warehouses.get(0);
        }

        // 按照仓库距离收货地址距离从小到大排序
        List<Warehouse> sortedList = warehouses.stream().sorted((w1,w2)->{
            BigDecimal srcLon = deliveryAddress.getLon();
            BigDecimal srcLat = deliveryAddress.getLat();
            Double distance1 = calculateDistanceService.getDirectDistance(srcLon,srcLat,w1.getLon(),w1.getLat());
            Double distance2 = calculateDistanceService.getDirectDistance(srcLon,srcLat,w2.getLon(),w2.getLat());
            return distance1.compareTo(distance2);
        }).collect(Collectors.toList());


        return sortedList.get(0);
    }

    public List<Warehouse> getWarehouses() {
        return warehouses;
    }

    public void setWarehouses(List<Warehouse> warehouses) {
        this.warehouses = warehouses;
    }
}
