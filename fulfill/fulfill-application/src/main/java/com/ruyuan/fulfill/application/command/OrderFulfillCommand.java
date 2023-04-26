package com.ruyuan.fulfill.application.command;

import com.ruyuan.fulfill.application.command.dto.OrderDTO;
import com.ruyuan.fulfill.application.command.dto.OrderItemDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 发起一个订单履约的命令
 * @author zhonghuashishan
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderFulfillCommand {

    /**
     * 订单
     */
    private OrderDTO order;

    /**
     * 订单条目
     */
    private List<OrderItemDTO> orderItems;

}
