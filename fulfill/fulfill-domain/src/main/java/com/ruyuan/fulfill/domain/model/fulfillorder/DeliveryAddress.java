package com.ruyuan.fulfill.domain.model.fulfillorder;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 配送地址信息
 * @author zhonghuashishan
 * @version 1.0
 */
@Data
public class DeliveryAddress {

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

}
