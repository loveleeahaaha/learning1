package com.learning.learningconsumer.service;

import com.alibaba.fastjson.JSON;
import com.learning.learningconsumer.entity.GoodsInfo;
import com.learning.learningconsumer.repository.IGoodsInfoRepository;
import com.learning.learningconsumer.util.SnowFlake;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * 商品信息逻辑层
 * created by liqiatao on 2021/7/22
 */
@Slf4j
@Service
public class GoodsInfoService {

    @Autowired
    IGoodsInfoRepository repository;

    /**
     * 库存修改操作
     *
     * @param goodsId
     * @param isReduce true-库存减1  false-库存加1
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public int updateGoodsStockById(Long goodsId, boolean isReduce) {
        Optional<GoodsInfo> byId = repository.findById(goodsId);
        if (byId.isPresent()) {
            GoodsInfo goodsInfo = byId.get();
            Integer stockNums = goodsInfo.getGoodsstock();
            goodsInfo.setGoodsstock(isReduce ? stockNums - 1 : stockNums + 1);
            repository.save(goodsInfo);
            log.debug("当前库存：{}", JSON.toJSON(goodsInfo));
            return goodsInfo.getGoodsstock();
        }
        return -1;
    }

    /**
     * 商品入库
     *
     * @param info
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public GoodsInfo create(GoodsInfo info) {
        info.setId(new SnowFlake(2, 3).nextId());
        return repository.save(info);
    }
}
