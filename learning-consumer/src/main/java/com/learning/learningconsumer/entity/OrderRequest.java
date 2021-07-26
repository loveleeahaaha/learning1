package com.learning.learningconsumer.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * created by liqiatao on 2021/7/22
 */
@Data
public class OrderRequest implements Serializable {
    private Long userid;
    private Long goodsid;
}
