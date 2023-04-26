package com.ruyuan.risk.rpc.service;

import com.ruyuan.risk.rpc.RiskApi;
import com.ruyuan.risk.rpc.dto.FulfillOrderRiskDTO;
import com.ruyuan.risk.rpc.request.FulfillOrderRiskRequest;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zhonghuashishan
 * @version 1.0
 */
@DubboService(version = "1.0.0", interfaceClass = RiskApi.class, retries = 0)
public class RiskApiImpl implements RiskApi {

    private static Logger log = LoggerFactory.getLogger(RiskApiImpl.class);

    @Override
    public FulfillOrderRiskDTO fulfillOrderRiskControlIntercept(FulfillOrderRiskRequest fulfillOrderRiskRequest) {
        // mock数据返回
        FulfillOrderRiskDTO fulfillOrderRiskDTO = new FulfillOrderRiskDTO();

        String orderId = fulfillOrderRiskRequest.getOrderId();
        if(StringUtils.isEmpty(orderId)) {
            log.error("orderId can not be empty");
            fulfillOrderRiskDTO.setRiskResult(false);
            fulfillOrderRiskDTO.setRiskComment("风险提示：非法的订单号");
            return fulfillOrderRiskDTO;
        }

        long orderId_long = Long.parseLong(orderId);
        // 当orderId是双数时，风控检查通过，是单数时，风控检查不通过
        if(orderId_long % 2 == 0) {
            fulfillOrderRiskDTO.setRiskResult(true);
            fulfillOrderRiskDTO.setRiskComment("风控检查通过");
            return fulfillOrderRiskDTO;
        } else {
            fulfillOrderRiskDTO.setRiskResult(false);
            fulfillOrderRiskDTO.setRiskComment("风险提示：黄牛恶意刷单");
            return fulfillOrderRiskDTO;
        }

    }
}