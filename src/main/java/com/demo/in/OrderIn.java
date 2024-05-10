package com.demo.in;

import com.demo.customAnnotation.FilterableField;
import lombok.Data;

@Data
public class OrderIn {
    /**
     * 店铺名称
     */
    @FilterableField(filterField = "shopName")
    private String shopName;

    /**
     * 商品数量最大值
     */
    @FilterableField(filterField = "numMax")
    private Integer numMax;

    /**
     * 商品数量最小值
     */
    @FilterableField(filterField = "numMin")
    private Integer numMin;


    /**
     * 页数
     */
    @FilterableField(filterField = "page")
    private Integer page;

    /**
     * 条数
     */
    @FilterableField(filterField = "rows")
    private Integer rows;
}
