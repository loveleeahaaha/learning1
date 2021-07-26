package com.learning.learningconsumer.service;

import com.learning.learningconsumer.entity.OrderRecord;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Random;

/**
 * created by liqiatao on 2021/7/22
 */
@Service
@Slf4j
public class PayService {

    @Resource
    private OrderRecordService orderRecordService;

    @Autowired
    private GoodsInfoService goodsInfoService;

    /**
     * 确认是否支付
     *
     * @param orderId
     */
    public void confirmPay(Long orderId) {
        OrderRecord orderRecord = orderRecordService.selectNoPayOrderById(orderId);
        //根据订单号校验该用户是否已支付
        if (checkPay(orderId)) {
            //已支付
            orderRecord.setPaystatus(1);
            orderRecordService.updatePayStatus(orderRecord);
            log.info("用户{}已支付", orderId);
        } else {
            //未支付
            orderRecord.setPaystatus(0);
            orderRecordService.updatePayStatus(orderRecord);
            //取消支付后，商品库存+1
            goodsInfoService.updateGoodsStockById(orderRecord.getGoodsid(), false);
            log.info("用户{}未支付", orderId);
        }
    }

    /**
     * 模拟判断订单支付成功或失败，成功失败随机
     *
     * @param orderId
     * @return
     */
    public boolean checkPay(Long orderId) {
        Random random = new Random();
        int res = random.nextInt(2);
        return res == 0 ? false : true;
    }
}

