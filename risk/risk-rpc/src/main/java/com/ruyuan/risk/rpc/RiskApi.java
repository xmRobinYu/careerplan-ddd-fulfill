package com.ruyuan.risk.rpc;

import com.ruyuan.risk.rpc.dto.FulfillOrderRiskDTO;
import com.ruyuan.risk.rpc.request.FulfillOrderRiskRequest;

/**
 * 风控服务API
 * @author zhonghuashishan
 * @version 1.0
 */
public interface RiskApi {

    /**
     * 履约订单风控检查
     * @param fulfillOrderRiskRequest
     * @return
     */
    FulfillOrderRiskDTO fulfillOrderRiskControlIntercept(FulfillOrderRiskRequest fulfillOrderRiskRequest);

}