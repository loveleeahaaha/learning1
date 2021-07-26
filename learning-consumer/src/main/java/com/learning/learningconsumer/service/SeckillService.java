package com.learning.learningconsumer.service;

import com.alibaba.fastjson.JSON;
import com.learning.learningconsumer.entity.OrderRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * created by liqiatao on 2021/7/22
 */
@Service
public class SeckillService {

    private static final Logger logger = LoggerFactory.getLogger(SeckillService.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private Environment env;
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 生产消息
     *
     * @param order
     */
    public void seckill(OrderRequest order) {
        //判断用户是否重复秒杀
        if (!checkUser(order)) {
            throw new RuntimeException("当前用户不可重复秒杀" + order.getUserid());
        }
        //设置交换机
        rabbitTemplate.setExchange(env.getProperty("order.mq.exchange.name"));
        //设置routingkey
        rabbitTemplate.setRoutingKey(env.getProperty("order.mq.routing.key"));
        //创建消息体
        Message msg = MessageBuilder.withBody(JSON.toJSONString(order).getBytes()).build();
        //发送消息
        logger.debug("有新的下单请求：{}", JSON.toJSONString(order));
        rabbitTemplate.convertAndSend(msg);
    }

    private boolean checkUser(OrderRequest order) {
        String key = String.valueOf(order.getUserid()) + order.getGoodsid();
        return redisTemplate.opsForValue().setIfAbsent(key, "1");
    }
}

