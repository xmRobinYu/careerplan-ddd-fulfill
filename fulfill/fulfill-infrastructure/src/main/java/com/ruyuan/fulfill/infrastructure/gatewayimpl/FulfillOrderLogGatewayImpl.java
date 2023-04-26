package com.ruyuan.fulfill.infrastructure.gatewayimpl;

import com.ruyuan.fulfill.domain.gateway.FulfillOrderLogGateway;
import com.ruyuan.fulfill.domain.model.fulfillorder.FulfillId;
import com.ruyuan.fulfill.domain.model.fulfillorder.FulfillOrderStatus;
import com.ruyuan.fulfill.infrastructure.gatewayimpl.database.dao.FulfillLogDAO;
import com.ruyuan.fulfill.infrastructure.gatewayimpl.database.dataobject.FulfillLogDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class FulfillOrderLogGatewayImpl implements FulfillOrderLogGateway {

    @Autowired
    private FulfillLogDAO fulfillLogDAO;

    @Override
    public void saveOperateLog(FulfillId fulfillID, FulfillOrderStatus fromStatus, FulfillOrderStatus toStatus) {
        FulfillLogDO logDO = buildLog(fulfillID,fromStatus,toStatus);
        fulfillLogDAO.save(logDO);
    }

    private FulfillLogDO buildLog(FulfillId fulfillID, FulfillOrderStatus fromStatus, FulfillOrderStatus toStatus) {
        FulfillLogDO fulfillLogDO = new FulfillLogDO();
        fulfillLogDO.setFulfillId(fulfillID.getFulfillId());
        fulfillLogDO.setBeforeStatus(fromStatus.getCode());
        fulfillLogDO.setCurrentStatus(toStatus.getCode());
        return fulfillLogDO;
    }
}
