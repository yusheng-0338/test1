package com.demo.out;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Order2Out {


    /**
     * 订单编号
     */
    private String order_id;

    /**
     * 买家id
     */
    private String buyer_id;

    /**
     * 买家名称
     */
    private String buyer_nickname;


    /**
     * 商品id
     */
    private String item_ids;

    /**
     * 颜色
     */
    private String colors;

    /**
     * 尺码
     */
    private String sizes;

    /**
     * 商品sku
     */
    private String skus;

    /**
     * 商品价格
     */
    private BigDecimal total_price;
}
