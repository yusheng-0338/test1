package com.demo.service;

import com.demo.in.OrderIn;
import com.demo.out.OrderOut;
import com.demo.out.SoldOrderMsgDto;

import java.util.List;

public interface OrderService {
    List<SoldOrderMsgDto> getSoldOrderMsg();

    List<OrderOut> getSoldOrderMsgAll(OrderIn orderIn);
}
