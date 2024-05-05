package com.demo.out;

import lombok.Data;

import java.util.List;

@Data
public class SoldOrderMsgDto {

    /**
     * 订单编号
     */
    public String orderId;


    /**
     * 商品数量
     */
    public  Integer shopNum;

    /**
     * 买家名称
     */
    public  String buyerName;

    /**
     * 封装对象
     */
    public List<SoldDto> soldDto;
}
