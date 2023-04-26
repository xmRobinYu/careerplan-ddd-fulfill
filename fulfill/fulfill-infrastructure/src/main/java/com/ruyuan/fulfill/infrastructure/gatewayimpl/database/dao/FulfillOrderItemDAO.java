package com.ruyuan.fulfill.infrastructure.gatewayimpl.database.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.ruyuan.fulfill.infrastructure.common.BaseDAO;
import com.ruyuan.fulfill.infrastructure.gatewayimpl.database.dataobject.FulfillOrderItemDO;
import com.ruyuan.fulfill.infrastructure.gatewayimpl.database.mapper.FulfillOrderItemMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 履约单条目 DAO
 * </p>
 *
 * @author zhonghuashishan
 */
@Repository
public class FulfillOrderItemDAO extends BaseDAO<FulfillOrderItemMapper, FulfillOrderItemDO> {

    public List<FulfillOrderItemDO> listByFulfillId(String fulfillId) {
        LambdaQueryWrapper<FulfillOrderItemDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(FulfillOrderItemDO::getFulfillId, fulfillId);
        return list(queryWrapper);
    }
}