package com.ruyuan.fulfill.api.event.config;

import com.ruyuan.fulfill.api.event.listener.OrderPayedEventListener;
import com.ruyuan.fulfill.infrastructure.common.RocketMqConstant;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.spring.autoconfigure.RocketMQProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



/**
 * 消费者组件配置
 * @author zhonghuashishan
 * @version 1.0
 */
@Configuration
public class ConsumerConfig {

    @Autowired
    private RocketMQProperties rocketMQProperties;

    /**
     * 订单已支付消息消费者
     *
     * @param orderPayedEventListener
     * @return
     * @throws MQClientException
     */
    @Bean("orderPayedEventConsumer")
    public DefaultMQPushConsumer orderPayedEventConsumer(OrderPayedEventListener orderPayedEventListener)
            throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(RocketMqConstant.ORDER_PAID_EVENT_CONSUMER_GROUP);
        consumer.setNamesrvAddr(rocketMQProperties.getNameServer());
        //设置监听的tags
        consumer.subscribe(RocketMqConstant.ORDER_PAID_EVENT_TOPIC, "*");
        consumer.registerMessageListener(orderPayedEventListener);
        consumer.start();
        return consumer;
    }

}