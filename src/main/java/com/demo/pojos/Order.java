package com.demo.pojos;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class Order implements Serializable {
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
