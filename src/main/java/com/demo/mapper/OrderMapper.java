package com.demo.mapper;

import com.demo.pojos.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    List<Order> selectAllBySellerId();
}
