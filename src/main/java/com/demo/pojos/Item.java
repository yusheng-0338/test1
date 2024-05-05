package com.demo.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class Item implements Serializable {
    private String id;
    private String title;
    private String color;
    private String size;
    private String sku;
    private String shopId;
    private BigDecimal price;
}
