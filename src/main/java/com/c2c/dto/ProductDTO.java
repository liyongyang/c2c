package com.c2c.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @description: 商品DTO
 **/
@Data
public class ProductDTO {

    private Long id;

    private String name;

    private BigDecimal price;

    private String image;

    private int display;

    private String type;

}
