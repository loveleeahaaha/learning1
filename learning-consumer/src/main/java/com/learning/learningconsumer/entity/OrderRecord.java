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
 * 下单记录
 */
@Data
@Entity
@Table(name = "order_record")
public class OrderRecord implements Serializable {
    @Id
    private Long id;

    @Column
    private Long userid;

    @Column
    private Long goodsid;

    /**
     * 0-超时未支付  1-已支付  2-待支付
     */
    @Column
    private Integer paystatus;

    @Column
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime createtime;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @Column
    private LocalDateTime updatetime;
}


