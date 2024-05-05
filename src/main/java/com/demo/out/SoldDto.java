package com.demo.out;

import com.demo.pojos.Item;
import lombok.Data;

import java.util.List;

@Data
public class SoldDto {
    /**
     * 店铺名称
     */
    public String shopName;

    /**
     * 商品明细
     */
    public List<Item> items;


}
