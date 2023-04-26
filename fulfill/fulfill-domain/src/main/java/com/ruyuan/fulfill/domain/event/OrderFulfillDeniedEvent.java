package com.ruyuan.fulfill.domain.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 订单履约被拒绝的领域事件
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderFulfillDeniedEvent implements Serializable {

    /**
     * 履约单id
     */
    private String fulfillId;

}
