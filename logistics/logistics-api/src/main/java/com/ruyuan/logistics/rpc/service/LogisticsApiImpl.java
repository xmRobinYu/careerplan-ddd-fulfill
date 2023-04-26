package com.ruyuan.logistics.rpc.service;

import com.ruyuan.logistics.rpc.LogisticsApi;
import com.ruyuan.logistics.rpc.dto.LogisticsCompaniesDTO;
import com.ruyuan.logistics.rpc.dto.LogisticsOrderDTO;
import com.ruyuan.logistics.rpc.request.ApplyLogisticsOrderRequest;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author zhonghuashishan
 * @version 1.0
 */
@DubboService(version = "1.0.0", interfaceClass = LogisticsApi.class, retries = 0)
public class LogisticsApiImpl implements LogisticsApi {

    @Override
    public LogisticsCompaniesDTO getAll() {
        LogisticsCompaniesDTO logisticsCompaniesDTO = new LogisticsCompaniesDTO();
        List<String> logisticsCompanyIds = new ArrayList<>();
        logisticsCompanyIds.add("顺丰快递ID");
        logisticsCompanyIds.add("中通快递ID");
        logisticsCompanyIds.add("申通快递ID");
        logisticsCompanyIds.add("圆通快递ID");
        logisticsCompanyIds.add("韵达快递ID");
        logisticsCompaniesDTO.setLogisticsCompanyIds(logisticsCompanyIds);
        return logisticsCompaniesDTO;
    }

    @Override
    public LogisticsOrderDTO applyLogisticsOrder(ApplyLogisticsOrderRequest applyLogisticsOrderRequest) {
        LogisticsOrderDTO logisticsOrderDTO = new LogisticsOrderDTO();
        logisticsOrderDTO.setLogisticsOrderId(genRandomNumber(11));
        return logisticsOrderDTO;
    }

    /**
     * 生成指定长度的随机数
     *
     * @param length
     * @return
     */
    private String genRandomNumber(int length) {

        String sources = "0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < length; j++) {
            sb.append(sources.charAt(random.nextInt(9)));
        }
        return sb.toString();
    }

}