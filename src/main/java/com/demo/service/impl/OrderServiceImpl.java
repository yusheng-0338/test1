package com.demo.service.impl;


import com.demo.Utils.Utils;
import com.demo.customAnnotation.FilterableField;
import com.demo.customAnnotation.GroupableField;
import com.demo.customAnnotation.SortableField;
import com.demo.in.OrderIn;
import com.demo.out.Order2Out;
import com.demo.out.OrderOut;
import com.demo.out.SoldDto;
import com.demo.out.SoldOrderMsgDto;
import com.demo.mapper.*;
import com.demo.pojos.*;
import com.demo.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.demo.Utils.Utils.buildQuery;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private OrderDetailMapper orderDetailMapper;
    @Resource
    private ShopMapper shopMapper;

    @Resource
    private ItemMapper itemMapper;

    @Resource
    private UserMapper userMapper;


    @Override
    public List<SoldOrderMsgDto> getSoldOrderMsg() {
        List<SoldOrderMsgDto> soldOrderMsgDtoList = new ArrayList<>();

        List<Order> orders = orderMapper.selectAllBySellerId();
        for (Order order : orders) {
            SoldOrderMsgDto soldOrderMsgDto = new SoldOrderMsgDto();

            //每个订单的买家id
            String buyerId = order.getBuyerId();
            User user = userMapper.selectById(buyerId);
            //买家名称
            String name = user.getName();
            //订单编号
            String id = order.getId();
            //根据订单id查询多个订单详情
            int num = 0;
            List<SoldDto> soldDtos = new ArrayList<>();
            List<OrderDetail> orderDetails = orderDetailMapper.selectByTid(order.getId());
            for (OrderDetail orderDetail : orderDetails) {
                //该订单详情下的店铺
                Shop shop = shopMapper.selectById(orderDetail.getItemId());
                //店铺名称
                String shopName = shop.getShopName();
                //根据店铺id返回多个商品
                List<Item> items = itemMapper.selectByShopId(shop.getId());
                //商品数量
                int size = items.size();
                num = size + num;
                //
                SoldDto soldDto = new SoldDto();
                soldDto.setItems(items);
                soldDto.setShopName(shopName);
                soldDtos.add(soldDto);
            }
            //商品id
//            String itemId = orderDetail.itemId;
            soldOrderMsgDto.setOrderId(id);
            soldOrderMsgDto.setBuyerName(name);
            soldOrderMsgDto.setShopNum(num);
            soldOrderMsgDto.setSoldDto(soldDtos);

            soldOrderMsgDtoList.add(soldOrderMsgDto);
        }


        return soldOrderMsgDtoList;
    }

    @Override
    public List<OrderOut> getSoldOrderMsgAll(OrderIn orderIn) {

//        //当前页
//        int page =  (orderIn.getPage() - 1) * orderIn.getRows();

        return orderMapper.selectAllBySellerOut(orderIn.getShopName(), orderIn.getNumMax(), orderIn.getNumMin(), (orderIn.getPage() - 1) * orderIn.getRows(), orderIn.getRows());

    }

    @Override
    public List<Order2Out> getSoldOrderMsgByItemTitle(String itemTitle) {


        return orderMapper.selectAllBySeller2Out(itemTitle);

    }

    /**
     * 通过注解方式查询所有订单信息
     *
     * @return
     */
    @Override
    public List<OrderOut> getSoldOrderMsgByAnnotation(OrderIn orderIn) {
        System.out.println(Utils.buildQuery(orderIn));
        Map<String, Object> stringObjectMap = Utils.buildQuery(orderIn);
        String shopName = String.valueOf(stringObjectMap.get("shopName"));
        int numMin = Integer.parseInt(String.valueOf(stringObjectMap.get("numMin")));
        int numMax = Integer.parseInt(String.valueOf(stringObjectMap.get("numMax")));
        int page = Integer.parseInt(String.valueOf(stringObjectMap.get("page")));
        int rows = Integer.parseInt(String.valueOf(stringObjectMap.get("rows")));
//        List<OrderOut> orderOuts = orderMapper.selectAllBySeller3Out(stringObjectMap);
        return orderMapper.selectAllBySellerOut(shopName, numMax, numMin, page, rows);
    }





}
