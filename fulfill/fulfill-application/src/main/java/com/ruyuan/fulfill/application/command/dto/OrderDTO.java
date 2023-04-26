package com.ruyuan.fulfill.application.command.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 订单数据对象
 * @author zhonghuashishan
 * @version 1.0
 */
@Data
public class OrderDTO implements Serializable {

    /**
     * 订单id
     */
    private String orderId;

    /**
     * 订单类型
     */
    private Integer orderType;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 配送方式
     */
    private Integer deliveryMode;

    /**
     * 收货人姓名
     */
    private String receiverName;

    /**
     * 收货人电话
     */
    private String receiverPhone;

    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 区
     */
    private String area;

    /**
     * 街道地址
     */
    private String street;

    /**
     * 详细地址
     */
    private String detailAddress;

    /**
     * 经度 六位小数点
     */
    private BigDecimal lon;

    /**
     * 纬度 六位小数点
     */
    private BigDecimal lat;

    /**
     * 支付方式
     */
    private Integer payType;

    /**
     * 付款总金额
     */
    private Integer payAmount;

    /**
     * 交易总金额
     */
    private Integer originAmount;

}
