package com.ruyuan.fulfill.infrastructure.gatewayimpl.database.dataobject;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 履约订单条目数据层对象
 *
 * @author zhonghuashishan
 */
@Data
@TableName("fulfill_order_item")
public class FulfillOrderItemDO implements Serializable {

    private static final long serialVersionUID = -4731152133848462948L;

    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;

    /**
     * 订单id
     */
    private String orderId;

    /**
     * 履约单id
     */
    private String fulfillId;

    /**
     * sku编码
     */
    private String skuCode;

    /**
     * 当前商品支付原总价
     */
    private Integer originAmount;

    /**
     * 付款金额
     */
    private Integer payAmount;

    /**
     * 销售数量
     */
    private Integer saleQuantity;

}