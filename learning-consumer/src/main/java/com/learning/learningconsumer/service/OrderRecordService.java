package com.learning.learningconsumer.service;

import com.learning.learningconsumer.entity.OrderRecord;
import com.learning.learningconsumer.repository.IOrderRecordRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * created by liqiatao on 2021/7/22
 */
@Slf4j
@Service
public class OrderRecordService {
    @Autowired
    private IOrderRecordRepository repository;


    /**
     * 新增订单
     *
     * @param orderRecord
     */
    public void insertOrderRecord(OrderRecord orderRecord) {
        OrderRecord record = repository.save(orderRecord);
        log.info("insertOrderRecord：{}", record);
    }

    /**
     * 根据订单id查找未支付订单
     *
     * @param orderId
     * @return
     */
    public OrderRecord selectNoPayOrderById(Long orderId) {
        return repository.findById(orderId).get();
    }

    /**
     * 更新支付状态
     *
     * @param orderRecord
     */
    public void updatePayStatus(OrderRecord orderRecord) {
        repository.save(orderRecord);
    }
}
