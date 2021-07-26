package com.learning.learningconsumer;

import com.alibaba.fastjson.JSON;
import com.learning.learningconsumer.entity.GoodsInfo;
import com.learning.learningconsumer.entity.OrderRequest;
import com.learning.learningconsumer.service.GoodsInfoService;
import com.learning.learningconsumer.service.SeckillService;
import com.learning.learningconsumer.util.SnowFlake;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Slf4j
public class RabbitMQTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private SeckillService seckillService;

    @Autowired
    private GoodsInfoService goodsInfoService;

    /**
     * 测试秒杀下单
     */
    @Test
    public void testSeckill() {
        OrderRequest order = new OrderRequest();
        order.setUserid(new SnowFlake(2, 3).nextId());
        //order.setUserid(616840111275126784L);
        order.setGoodsid(615710277635420160L);
        seckillService.seckill(order);
    }

    /**
     * 测试商品入库
     */
    @Test
    public void testCreateGoods() {
        GoodsInfo goodsInfo = new GoodsInfo();
        goodsInfo.setGoodsstock(20);
        goodsInfo.setGoodsname("iphone12");
        goodsInfo.setCreatetime(LocalDateTime.now());
        goodsInfoService.create(goodsInfo);
        System.out.println("新增的商品为：" + JSON.toJSONString(goodsInfo));
    }
}
