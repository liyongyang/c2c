package com.c2c.dto;

import com.c2c.entity.Product;
import lombok.Data;

/**
 * @description: 购物车DTO
 **/
@Data
public class CartDTO {

    private Long id;

    private Product product;

    private Integer quantity;
}
