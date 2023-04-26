package com.ruyuan.fulfill.infrastructure.convertor;

import com.ruyuan.fulfill.domain.model.logistics.LogisticsCompanies;
import com.ruyuan.fulfill.domain.model.logistics.LogisticsCompany;
import com.ruyuan.logistics.rpc.dto.LogisticsCompaniesDTO;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhonghuashishan
 * @version 1.0
 */
@Component
public class LogisticsCompaniesConverter {

    public LogisticsCompanies convert(LogisticsCompaniesDTO logisticsCompaniesDTO) {
        LogisticsCompanies logisticsCompanies = new LogisticsCompanies();
        List<LogisticsCompany> logisticsCompanyList = new ArrayList<>();
        if(logisticsCompaniesDTO != null) {
            List<String> logisticsCompanyIds = logisticsCompaniesDTO.getLogisticsCompanyIds();
            int i=100;
            for(String logisticsCompanyId : logisticsCompanyIds) {
                LogisticsCompany logisticsCompany = new LogisticsCompany();
                logisticsCompany.setLogisticsCompanyId(logisticsCompanyId);
                logisticsCompany.setLat(new BigDecimal(i));
                logisticsCompany.setLon(new BigDecimal(i));
                logisticsCompanyList.add(logisticsCompany);
                i+=10;
            }
        }
        logisticsCompanies.setLogisticsCompanies(logisticsCompanyList);
        return logisticsCompanies;
    }

}