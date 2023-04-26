package com.ruyuan.logistics.rpc;

import com.ruyuan.logistics.rpc.dto.LogisticsCompaniesDTO;
import com.ruyuan.logistics.rpc.dto.LogisticsOrderDTO;
import com.ruyuan.logistics.rpc.request.ApplyLogisticsOrderRequest;

/**
 * @author zhonghuashishan
 * @version 1.0
 */
public interface LogisticsApi {

    /**
     * 查询所有的物流公司
     * @return
     */
    LogisticsCompaniesDTO getAll();

    /**
     * 申请物流单
     * @param applyLogisticsOrderRequest
     * @return
     */
    LogisticsOrderDTO applyLogisticsOrder(ApplyLogisticsOrderRequest applyLogisticsOrderRequest);

}