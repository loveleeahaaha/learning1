package com.learning.learningconsumer.repository;

import com.learning.learningconsumer.entity.GoodsInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * created by liqiatao on 2021/7/22
 */
@Repository
public interface IGoodsInfoRepository extends JpaRepository<GoodsInfo, Long> {
}
