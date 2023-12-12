package com.pandi.mapping.relations.Dto;

import lombok.Data;

import java.math.BigDecimal;


@Data
public class ItemModel {

    private String itemName;
    private Integer quantity;
    private BigDecimal price;

    private Integer orderId;
}
