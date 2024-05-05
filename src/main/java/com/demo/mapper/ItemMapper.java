package com.demo.mapper;

import com.demo.pojos.Item;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface ItemMapper {
    List<Item> selectByShopId(@Param("shopId") String shopId);
}
