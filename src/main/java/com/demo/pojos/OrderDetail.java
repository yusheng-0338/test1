package com.demo.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class OrderDetail implements Serializable {
    private String id;
    private String tId;
    /**
     * 商品id
     */
    private String itemId;
}
