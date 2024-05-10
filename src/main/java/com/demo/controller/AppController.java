package com.demo.controller;

import com.demo.in.OrderIn;
import com.demo.out.Order2Out;
import com.demo.out.OrderOut;
import com.demo.out.SoldOrderMsgDto;
import com.demo.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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
/*
/ 店铺名称，订单编号，商品明细（返回订单商品的全部信息），商品数量，买家名称
店铺名称：可筛选，可分组 商品数量：可排序，可筛选（a<=数量<=b） 支持分页
 */
    @PostMapping(value = "/getSoldOrderMsgAll")
    public List<OrderOut> getSoldOrderMsgAll(@RequestBody OrderIn orderIn){

        return orderService.getSoldOrderMsgAll(orderIn);
    }
/*
/商品明细：可筛选（查看拥有某种商品的订单），
可分组（按单件商品分组，比如买A商品的有哪些，B商品的有哪些，
一个订单有多个商品的，显示到两个多个商品分组条件下面）
 */
    @PostMapping(value = "/getSoldOrderMsgByItemTitle")
    public List<Order2Out> getSoldOrderMsgByItemTitle(@RequestParam("itemTitle") String itemTitle){

        return orderService.getSoldOrderMsgByItemTitle(itemTitle);
    }
/*
/ 店铺名称，订单编号，商品明细（返回订单商品的全部信息），商品数量，买家名称
店铺名称：可筛选，可分组 商品数量：可排序，可筛选（a<=数量<=b） 支持分页 通过AOP思想,注解模式通过反射获取属性,
 */

    @PostMapping("/getSoldOrderMsgByAnnotation")
    public List<OrderOut> getSoldOrderMsgByAnnotation(@RequestBody OrderIn orderIn){
        return orderService.getSoldOrderMsgByAnnotation(orderIn);
    }


}
