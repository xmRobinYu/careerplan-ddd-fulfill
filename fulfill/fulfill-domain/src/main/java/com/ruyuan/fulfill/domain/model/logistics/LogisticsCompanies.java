package com.ruyuan.fulfill.domain.model.logistics;

import com.ruyuan.fulfill.domain.model.warehouse.Warehouse;
import com.ruyuan.fulfill.domain.service.CalculateDistanceService;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 物流公司
 *
 * @author zhonghuashishan
 * @version 1.0
 */
public class LogisticsCompanies {

    /**
     * 物流公司
     */
    private List<LogisticsCompany> logisticsCompanies;

    /**
     * 选择合适的物流公司
     *
     * @param warehouse
     * @return
     */
    public LogisticsCompany selectBest(Warehouse warehouse, CalculateDistanceService calculateDistanceService) {
        if (logisticsCompanies.size() == 1) {
            return logisticsCompanies.get(0);
        }

        // 按照物流公司距离仓库离从小到大排序
        List<LogisticsCompany> sortedList = logisticsCompanies.stream().sorted((c1, c2) -> {
            BigDecimal srcLon = warehouse.getLon();
            BigDecimal srcLat = warehouse.getLat();
            Double distance1 = calculateDistanceService.getDirectDistance(srcLon, srcLat, c1.getLon(), c1.getLat());
            Double distance2 = calculateDistanceService.getDirectDistance(srcLon, srcLat, c2.getLon(), c2.getLat());
            return distance1.compareTo(distance2);
        }).collect(Collectors.toList());


        return sortedList.get(0);
    }

    public List<LogisticsCompany> getLogisticsCompanies() {
        return logisticsCompanies;
    }

    public void setLogisticsCompanies(List<LogisticsCompany> logisticsCompanies) {
        this.logisticsCompanies = logisticsCompanies;
    }
}
