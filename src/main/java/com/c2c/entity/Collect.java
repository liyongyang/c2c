package com.c2c.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 收藏
 **/
@Data
@NoArgsConstructor
public class Collect {

    /** 收藏ID */
    private Long id;

    /** 商品ID */
    private Long productId;

    /** 用户ID */
    private Long userId;

    public Collect(Long productId, Long userId) {
        this.productId = productId;
        this.userId = userId;
    }
}
