package com.c2c.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 购物车
 * @author: 段辉
 * @create: 2019-12-12 11:56:31
 **/
@Data
@NoArgsConstructor
public class Cart {

    private Long id;

    private Long userId;

    private Long productId;

    /** 数量 */
    private Integer quantity;

    public Cart(Long userId, Long productId, Integer quantity) {
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
    }
}
