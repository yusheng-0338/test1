package com.demo.controller;

import com.demo.dto.SoldOrderMsgDto;
import com.demo.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/demo/api")
public class AppController {

    @Resource
    private OrderService orderService;

    @GetMapping("/getSoldOrderMsg")
    public List<SoldOrderMsgDto> getSoldOrderMsg(){

        return orderService.getSoldOrderMsg();
    }
}
