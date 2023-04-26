package com.ruyuan.fulfill.api.web.response;

import com.ruyuan.fulfill.application.command.dto.FulfillOrderDTO;
import com.ruyuan.fulfill.application.command.dto.OrderDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 查询被风控拦截的履约单
 * @author zhonghuashishan
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryInterceptedFulfillOrderResponse {

    /**
     * 被风控拦截的履约单
     */
    private List<FulfillOrderDTO> fulfillOrders;
}
