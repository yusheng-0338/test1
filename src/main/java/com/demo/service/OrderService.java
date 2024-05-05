package com.demo.service;

import com.demo.dto.SoldOrderMsgDto;

import java.util.List;

public interface OrderService {
    List<SoldOrderMsgDto> getSoldOrderMsg();
}
