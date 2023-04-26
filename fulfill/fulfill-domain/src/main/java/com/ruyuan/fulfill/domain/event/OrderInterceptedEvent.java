package com.ruyuan.fulfill.domain.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 订单被风控拦截的领域事件
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderInterceptedEvent implements Serializable {

    /**
     * 履约单id
     */
    private String fulfillId;

}
