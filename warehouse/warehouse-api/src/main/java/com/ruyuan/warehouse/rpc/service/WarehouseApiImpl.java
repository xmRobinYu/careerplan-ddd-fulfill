package com.ruyuan.warehouse.rpc.service;

import com.ruyuan.warehouse.rpc.WarehouseApi;
import com.ruyuan.warehouse.rpc.dto.WarehouseDTO;
import com.ruyuan.warehouse.rpc.request.FulfillOrderWarehouseRequest;
import com.ruyuan.warehouse.rpc.request.LockWarehouseInventoryRequest;
import com.ruyuan.warehouse.rpc.request.WarehouseRequest;
import org.apache.dubbo.config.annotation.DubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhonghuashishan
 * @version 1.0
 */
@DubboService(version = "1.0.0", interfaceClass = WarehouseApi.class, retries = 0)
public class WarehouseApiImpl implements WarehouseApi {

    private static Logger log = LoggerFactory.getLogger(WarehouseApiImpl.class);

    @Override
    public List<WarehouseDTO> getAll(List<String> skuCodes) {
        if(skuCodes == null || skuCodes.isEmpty()) {
            log.error("skuCodes can not be empty");
            return new ArrayList<>();
        }

        List<WarehouseDTO> list = new ArrayList<>();
        for(String skuCode : skuCodes) {
            WarehouseDTO warehouseDTO = new WarehouseDTO();
            warehouseDTO.setWarehouseId("W001");
            warehouseDTO.setLon(new BigDecimal("116.421516"));
            warehouseDTO.setLat(new BigDecimal("39.91582"));
            Map<String, Integer> skuStockMap = new HashMap<>();
            skuStockMap.put(skuCode, 100000);
            warehouseDTO.setSkuStockMap(skuStockMap);
            list.add(warehouseDTO);
        }

        return list;
    }

    @Override
    public Boolean lockInventory(LockWarehouseInventoryRequest lockWarehouseInventoryRequest) {
        log.info("锁定仓储库存成功...");
        return true;
    }

    @Override
    public void sendFulfillOrder(FulfillOrderWarehouseRequest fulfillOrderWarehouseRequest, WarehouseRequest warehouseRequest) {
        log.info("下发履约单至仓储成功...");
    }
}