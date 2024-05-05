package com.demo.mapper;

import com.demo.pojos.Shop;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShopMapper {
    Shop selectById(@Param("id") String id);
}
