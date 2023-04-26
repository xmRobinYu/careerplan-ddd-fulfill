package com.ruyuan.fulfill.infrastructure.convertor;

import com.ruyuan.fulfill.domain.model.warehouse.Warehouse;
import com.ruyuan.warehouse.rpc.dto.WarehouseDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhonghuashishan
 * @version 1.0
 */
@Component
public class WarehouseConverter {

    public List<Warehouse> convert(List<WarehouseDTO> warehouseDTOList) {
        List<Warehouse> list = new ArrayList<>();
        for(WarehouseDTO warehouseDTO : warehouseDTOList) {
            Warehouse warehouse = new Warehouse();
            warehouse.setWarehouseId(warehouseDTO.getWarehouseId());
            warehouse.setLon(warehouseDTO.getLon());
            warehouse.setLat(warehouseDTO.getLat());
            warehouse.setSkuStockMap(warehouseDTO.getSkuStockMap());
            list.add(warehouse);
        }
        return list;
    }

}