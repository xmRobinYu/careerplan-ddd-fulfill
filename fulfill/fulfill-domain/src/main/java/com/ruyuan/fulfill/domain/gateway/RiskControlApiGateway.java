package com.ruyuan.fulfill.domain.gateway;

import com.ruyuan.fulfill.domain.model.fulfillorder.FulfillOrder;

/**
 * 风控子域API接口
 */
public interface RiskControlApiGateway {

    Boolean riskControlIntercept(FulfillOrder fulfillOrder);

}
