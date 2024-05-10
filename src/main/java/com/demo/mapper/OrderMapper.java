package com.demo.mapper;

import com.demo.out.Order2Out;
import com.demo.out.OrderOut;
import com.demo.pojos.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface OrderMapper {
    List<Order> selectAllBySellerId();

    /*
    / 根据条件做筛选
     */
    List<OrderOut> selectAllBySellerOut(@Param("shopName") String shopName,
                                        @Param("numMax") Integer numMax,
                                        @Param("numMin") Integer numMin,
                                        @Param("page") Integer page,
                                        @Param("rows") Integer rows);


    List<Order2Out> selectAllBySeller2Out(@Param("itemTitle")  String itemTitle);

    /*
    / 根据条件做筛选
     */
    List<OrderOut> selectAllBySeller3Out(@Param("map")Map<String, Object> map);
}
