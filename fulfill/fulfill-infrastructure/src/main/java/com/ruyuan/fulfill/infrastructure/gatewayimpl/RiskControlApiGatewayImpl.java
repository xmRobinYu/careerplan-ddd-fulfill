package com.ruyuan.fulfill.infrastructure.gatewayimpl;

import com.ruyuan.fulfill.domain.model.fulfillorder.FulfillOrder;
import com.ruyuan.fulfill.domain.gateway.RiskControlApiGateway;
import com.ruyuan.fulfill.infrastructure.convertor.FulfillOrderRiskRequestConverter;
import com.ruyuan.risk.rpc.RiskApi;
import com.ruyuan.risk.rpc.dto.FulfillOrderRiskDTO;
import com.ruyuan.risk.rpc.request.FulfillOrderRiskRequest;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RiskControlApiGatewayImpl implements RiskControlApiGateway {

    private static Logger log = LoggerFactory.getLogger(RiskControlApiGatewayImpl.class);

    @DubboReference(version = "1.0.0", retries = 0)
    private RiskApi riskApi;

    @Autowired
    private FulfillOrderRiskRequestConverter fulfillOrderRiskRequestConverter;

    @Override
    public Boolean riskControlIntercept(FulfillOrder fulfillOrder) {
        FulfillOrderRiskRequest fulfillOrderRiskRequest = fulfillOrderRiskRequestConverter.convert(fulfillOrder);
        FulfillOrderRiskDTO fulfillOrderRiskDTO = riskApi.fulfillOrderRiskControlIntercept(fulfillOrderRiskRequest);
        if(fulfillOrderRiskDTO == null) {
            log.warn("风控调用失败");
            return false;
        }
        if(!fulfillOrderRiskDTO.getRiskResult()) {
            log.warn("风控检查拒绝通过");
            return false;
        }
        return true;
    }

}
