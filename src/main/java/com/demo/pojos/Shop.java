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
public class Shop implements Serializable  {
    private String id;
    /**
     * 商户名称
     */
    private String shopName;
    /**
     * 平台
     */
    private String plateform;



}
