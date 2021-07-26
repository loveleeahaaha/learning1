package com.learning.learningconsumer.repository;

import com.learning.learningconsumer.entity.OrderRecord;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * created by liqiatao on 2021/7/22
 */
public interface IOrderRecordRepository extends JpaRepository<OrderRecord, Long> {
}
