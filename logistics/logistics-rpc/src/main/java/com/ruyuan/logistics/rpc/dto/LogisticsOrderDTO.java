package com.ruyuan.logistics.rpc.dto;

import java.io.Serializable;

/**
 * @author zhonghuashishan
 * @version 1.0
 */
public class LogisticsOrderDTO implements Serializable {

    private static final long serialVersionUID = 1476564174914481353L;

    /**
     * 物流单号
     */
    private String logisticsOrderId;

    public String getLogisticsOrderId() {
        return logisticsOrderId;
    }

    public void setLogisticsOrderId(String logisticsOrderId) {
        this.logisticsOrderId = logisticsOrderId;
    }
}