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
public class User implements Serializable {
    private String id;
    private String name;
    /**
     * 1：卖家
     * 2：买家
     */
    private Integer type;
}
