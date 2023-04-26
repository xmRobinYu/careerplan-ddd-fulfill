package com.ruyuan.fulfill.application.command.dto;

import com.ruyuan.fulfill.domain.model.fulfillorder.FulfillOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 风控拦截的履约订单集合DTO
 * @author zhonghuashishan
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InterceptedFulfillOrdersDTO {

    /**
     * 被风控拦截的履约订单
     */
    private List<FulfillOrderDTO> fulfillOrders;

}
