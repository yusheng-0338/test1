package com.demo.dto;

import com.demo.pojos.Item;
import lombok.Data;

import java.math.BigDecimal;
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
