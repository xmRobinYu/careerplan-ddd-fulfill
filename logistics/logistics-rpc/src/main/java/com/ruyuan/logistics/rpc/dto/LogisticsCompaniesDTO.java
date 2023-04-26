package com.ruyuan.logistics.rpc.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author zhonghuashishan
 * @version 1.0
 */
public class LogisticsCompaniesDTO implements Serializable {

    private static final long serialVersionUID = 4901865828181990276L;

    List<String> logisticsCompanyIds;

    public List<String> getLogisticsCompanyIds() {
        return logisticsCompanyIds;
    }

    public void setLogisticsCompanyIds(List<String> logisticsCompanyIds) {
        this.logisticsCompanyIds = logisticsCompanyIds;
    }
}