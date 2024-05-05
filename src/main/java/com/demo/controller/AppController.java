package com.demo.controller;

import com.demo.in.OrderIn;
import com.demo.out.OrderOut;
import com.demo.out.SoldOrderMsgDto;
import com.demo.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/getSoldOrderMsgAll")
    public List<OrderOut> getSoldOrderMsgAll(@RequestBody OrderIn orderIn){

        return orderService.getSoldOrderMsgAll(orderIn);
    }
}
