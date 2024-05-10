package com.demo.service;

import com.demo.in.OrderIn;
import com.demo.out.Order2Out;
import com.demo.out.OrderOut;
import com.demo.out.SoldOrderMsgDto;

import java.util.List;
import java.util.Map;

public interface OrderService {
    List<SoldOrderMsgDto> getSoldOrderMsg();

    List<OrderOut> getSoldOrderMsgAll(OrderIn orderIn);

    List<Order2Out> getSoldOrderMsgByItemTitle(String itemTitle);

    /**
     * 通过注解方式查询所有订单信息
     * @return
     */
    List<OrderOut> getSoldOrderMsgByAnnotation(OrderIn orderIn);
}
