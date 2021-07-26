package com.learning.learningconsumer.component;

import com.alibaba.fastjson.JSON;
import com.learning.learningconsumer.entity.OrderRecord;
import com.learning.learningconsumer.service.PayService;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * created by liqiatao on 2021/7/22
 */
@Component
public class PayListener implements ChannelAwareMessageListener {

    private static final Logger logger = LoggerFactory.getLogger(PayListener.class);

    @Autowired
    private PayService payService;

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        Long tag = message.getMessageProperties().getDeliveryTag();
        try {
            String str = new String(message.getBody(), "utf-8");
            logger.info("接收到的消息：{}", str);
            OrderRecord record = JSON.parseObject(str, OrderRecord.class);
            //确认是否付款
            payService.confirmPay(record.getId());
            //确认消费
            channel.basicAck(tag, true);
        } catch (Exception e) {
            logger.info("支付消息消费出错：{}", e.getMessage());
            logger.info("出错的tag:{}", tag);
        }
    }
}

