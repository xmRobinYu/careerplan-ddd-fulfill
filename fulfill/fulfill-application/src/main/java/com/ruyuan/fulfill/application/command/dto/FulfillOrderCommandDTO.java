package com.ruyuan.fulfill.application.command.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author zhonghuashishan
 * @version 1.0
 */
@Data
public class FulfillOrderCommandDTO implements Serializable {
    private static final long serialVersionUID = 3997378883353957511L;
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 更新时间
     */
    private Date gmtModified;

    /**
     * 订单id
     */
    private String orderId;

    /**
     * 当前商品支付原总价
     */
    private Integer originAmount;

    /**
     * 付款金额
     */
    private Integer payAmount;

    /**
     * 支付类型 10 微信支付 20 支付宝支付
     */
    private Integer payType;

    /**
     * 履约单号
     */
    private String fulfillId;

    /**
     * 买家id
     */
    private String userId;

    /**
     * 仓库id
     */
    private String warehouseId;

    /**
     * 预分仓履约状态 10 未分仓 20 已分仓
     */
    private Integer fulfillStatus;

    /**
     * 风控状态 10 未通过 20 已通过
     */
    private Integer riskStatus;

    /**
     * 人工审核状态 10 未通过 20 已通过
     */
    private Integer manualReviewStatus;

    /**
     * 物流单号
     */
    private String logisticsId;

    /**
     * 配送地址
     */
    private String deliveryAddress;

    /**
     * 配送方式 10 自营 20 三方配送
     */
    private Integer deliveryMode;

    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 省
     */
    private String area;

    /**
     * 街道
     */
    private String street;

    /**
     * 收货人姓名
     */
    private String receiverName;

    /**
     * 详细地址
     */
    private String detailAddress;

    /**
     * 收货人电话
     */
    private String receiverPhone;

    /**
     * 经度
     */
    private BigDecimal lon;

    /**
     * 维度
     */
    private BigDecimal lat;
}
