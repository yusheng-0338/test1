package com.demo.pojos;

import com.demo.customAnnotation.FilterableField;
import com.demo.customAnnotation.SortableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class Order implements Serializable {



    /**
     * 订单可筛选,可排序
     */
    @FilterableField(filterField = "orderId")
    @SortableField(sortField = "orderId")
    private String id;
    /**
     * 卖家
     */
    private String sellerId;

    /**
     * 买家
     */
    private String buyerId;
}
