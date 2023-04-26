package com.ruyuan.fulfill.domain.model.fulfillorder;

import lombok.Data;

/**
 * 履约单状态记录
 *
 * @author zhonghuashishan
 * @version 1.0
 */
@Data
public class FulfillLog {
    /**
     * 履约订单id
     */
    private String orderId;

    /**
     * 履约单号
     */
    private String fulFillId;

    /**
     * 履约单前置状态 10 已创建 20 已出库 30 已配送
     */
    private Integer beforeStatus;

    /**
     * 履约单当前状态 10 已创建 20 已出库 30 已配送
     */
    private Integer currentStatus;


}
