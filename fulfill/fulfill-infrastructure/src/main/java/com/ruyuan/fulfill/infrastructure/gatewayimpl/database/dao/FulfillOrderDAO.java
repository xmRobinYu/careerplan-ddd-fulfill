package com.ruyuan.fulfill.infrastructure.gatewayimpl.database.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.ruyuan.fulfill.domain.model.fulfillorder.RiskStatus;
import com.ruyuan.fulfill.infrastructure.common.BaseDAO;
import com.ruyuan.fulfill.infrastructure.gatewayimpl.database.dataobject.FulfillOrderDO;
import com.ruyuan.fulfill.infrastructure.gatewayimpl.database.mapper.FulfillOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 履约单 DAO
 * </p>
 *
 * @author zhonghuashishan
 */
@Repository
public class FulfillOrderDAO extends BaseDAO<FulfillOrderMapper, FulfillOrderDO> {

    public FulfillOrderDO getByFulfillId(String fulfillId) {
        LambdaQueryWrapper<FulfillOrderDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(FulfillOrderDO::getFulfillId, fulfillId);
        return baseMapper.selectOne(queryWrapper);
    }

    public List<FulfillOrderDO> queryInterceptedFulfillOrders() {
        LambdaQueryWrapper<FulfillOrderDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(FulfillOrderDO::getRiskStatus, RiskStatus.UN_PASS.getCode());
        queryWrapper.isNull(FulfillOrderDO::getManualReviewStatus);
        return list(queryWrapper);
    }

    public boolean saveAllocatedWarehouse(String fulfillId, String warehouseId) {
        LambdaUpdateWrapper<FulfillOrderDO> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.set(FulfillOrderDO::getWarehouseId, warehouseId)
                .eq(FulfillOrderDO::getFulfillId, fulfillId);
        return update(updateWrapper);
    }

    public boolean saveLogisticsOrder(String fulfillId, String logisticsId) {
        LambdaUpdateWrapper<FulfillOrderDO> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.set(FulfillOrderDO::getLogisticsId, logisticsId)
                .eq(FulfillOrderDO::getFulfillId, fulfillId);
        return update(updateWrapper);
    }

    public boolean updateRiskStatus(String fulfillId, Integer status) {
        LambdaUpdateWrapper<FulfillOrderDO> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.set(FulfillOrderDO::getRiskStatus, status)
                .eq(FulfillOrderDO::getFulfillId, fulfillId);
        return update(updateWrapper);
    }

    public boolean updateManualReviewStatus(String fulfillId, Integer status) {
        LambdaUpdateWrapper<FulfillOrderDO> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.set(FulfillOrderDO::getManualReviewStatus, status)
                .eq(FulfillOrderDO::getFulfillId, fulfillId);
        return update(updateWrapper);
    }
}