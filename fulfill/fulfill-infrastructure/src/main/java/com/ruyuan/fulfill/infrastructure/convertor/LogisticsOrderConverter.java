package com.ruyuan.fulfill.infrastructure.convertor;

import com.ruyuan.fulfill.domain.model.fulfillorder.LogisticsOrder;
import com.ruyuan.logistics.rpc.dto.LogisticsOrderDTO;
import org.springframework.stereotype.Component;

/**
 * @author zhonghuashishan
 * @version 1.0
 */
@Component
public class LogisticsOrderConverter {

    public LogisticsOrder convert(LogisticsOrderDTO logisticsOrderDTO) {
        LogisticsOrder logisticsOrder = new LogisticsOrder();
        logisticsOrder.setLogisticsId(logisticsOrderDTO.getLogisticsOrderId());
        return logisticsOrder;
    }

}