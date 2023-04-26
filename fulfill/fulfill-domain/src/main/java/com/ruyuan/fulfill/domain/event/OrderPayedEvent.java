package com.ruyuan.fulfill.domain.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Tolerate;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 订单已支付领域事件
 */
@Data
@AllArgsConstructor
@Builder
public class OrderPayedEvent implements Serializable {

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
    private String phone;

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


    /**
     * 订单商品明细
     */
    private List<OrderItem> orderItems;

    /**
     * 订单条目
     */
    @Data
    public static class OrderItem {

        /**
         * 商品id
         */
        private String skuCode;

        /**
         * 销售单价
         */
        private Integer salePrice;

        /**
         * 销售数量
         */
        private Integer saleQuantity;

        /**
         * 付款金额
         */
        private Integer payAmount;

        /**
         * 当前商品支付原总价
         */
        private Integer originAmount;

    }

    @Tolerate
    public OrderPayedEvent() {

    }

}
