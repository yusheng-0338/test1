package com.demo.in;

import lombok.Data;

@Data
public class OrderIn {
    /**
     * 店铺名称
     */
    private String shopName;

    /**
     * 商品数量最大值
     */
    private Integer numMax;

    /**
     * 商品数量最小值
     */
    private Integer numMin;


    /**
     * 页数
     */
    private Integer page;

    /**
     * 条数
     */
    private Integer rows;
}
