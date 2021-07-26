package com.learning.learningconsumer.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 商品库存
 */
@Data
@Entity
@Table(name = "goods_info")
public class GoodsInfo implements Serializable {

    @Id
    private Long id;

    @Column
    private String goodsname;

    @Column
    private Integer goodsstock;

    @Column
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime createtime;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @Column
    private LocalDateTime updatetime;
}


