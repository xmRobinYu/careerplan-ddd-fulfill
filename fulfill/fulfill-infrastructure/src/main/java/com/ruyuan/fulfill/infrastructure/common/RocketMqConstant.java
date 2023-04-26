package com.ruyuan.fulfill.infrastructure.common;

/**
 * RocketMQ 常量类
 *
 * @author zhonghuashishan
 * @version 1.0
 */
public class RocketMqConstant {

    /**
     * 默认的producer分组
     */
    public static String ORDER_DEFAULT_PRODUCER_GROUP = "order_default_producer_group";

    /**
     * 订单已支付 producer 分组
     */
    public static String ORDER_PAID_EVENT_PRODUCER_GROUP = "order_paid_event_producer_group";

    /**
     * 订单已支付事件 topic
     */
    public static String ORDER_PAID_EVENT_TOPIC = "order_paid_topic";

    /**
     * 订单已支付 consumer 分组
     */
    public static String ORDER_PAID_EVENT_CONSUMER_GROUP = "order_paid_event_consumer_group";

    /**
     * 订单被风控拦截事件 topic
     */
    public static String ORDER_INTERCEPTED_EVENT_TOPIC = "order_intercepted_topic";

    /**
     * 订单履约被拒绝事件 topic
     */
    public static String ORDER_FULFILL_DENIED_EVENT_TOPIC = "order_fulfill_denied_topic";

}

