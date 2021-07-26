package com.learning.learningconsumer.component;

import com.alibaba.fastjson.JSONObject;
import com.learning.learningconsumer.entity.OrderRecord;
import com.learning.learningconsumer.service.OrderService;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 消息监听器（消费者）
 */
@Component
@Slf4j
public class OrderListener implements ChannelAwareMessageListener {

    @Autowired
    private OrderService orderService;

    /**
     * 处理接收到的消息
     *
     * @param message 消息体
     * @param channel 通道，确认消费用
     * @throws Exception
     */
    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        try {
            //获取交付tag
            long tag = message.getMessageProperties().getDeliveryTag();
            String str = new String(message.getBody(), "utf-8");
            log.info("接收到的消息：{}", str);
            OrderRecord orderRecord = JSONObject.parseObject(str, OrderRecord.class);
            //下单，操作数据库
            orderService.order(orderRecord.getUserid(), orderRecord.getGoodsid());
            //确认消费
            channel.basicAck(tag, true);
        } catch (Exception e) {
            log.error("消息监听确认机制发生异常：", e.fillInStackTrace());
        }
    }
}
