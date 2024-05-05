package com.demo.mapper;

import com.demo.out.OrderOut;
import com.demo.pojos.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {
    List<Order> selectAllBySellerId();

    List<OrderOut> selectAllBySellerOut(@Param("shopName") String shopName,
                                        @Param("numMax") Integer numMax,
                                        @Param("numMin") Integer numMin,
                                        @Param("page") Integer page,
                                        @Param("rows") Integer rows);
}
