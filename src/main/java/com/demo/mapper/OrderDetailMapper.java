package com.demo.mapper;

import com.demo.pojos.OrderDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderDetailMapper {
    List<OrderDetail>  selectByTid(@Param("tId") String tId);
}
