package com.demo.out;

import lombok.Data;

@Data
public class OrderOut {


    /**
     * 店铺名称
     */
    private String shop_name;

    /**
     * 订单编号
     */
    private String order_id;

    /**
     * 买家
     */
    private String buyer_nickname;


    /**
     * 商品数量
     */
    private Integer item_count;

    /**
     * 商品详情
     */
    private String item_details;
}
