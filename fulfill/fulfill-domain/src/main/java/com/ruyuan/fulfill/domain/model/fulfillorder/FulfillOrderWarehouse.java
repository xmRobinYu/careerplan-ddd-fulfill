package com.ruyuan.fulfill.domain.model.fulfillorder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author zhonghuashishan
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FulfillOrderWarehouse implements Serializable {

    /**
     * 仓库id
     */
    private String warehouseId;
}