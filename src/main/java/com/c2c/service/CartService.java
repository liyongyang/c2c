package com.c2c.service;

import com.c2c.dto.CartDTO;
import com.c2c.entity.Cart;
import com.c2c.vo.ResponseVo;

import java.util.List;

/**
 * 购物车service层
 */
public interface CartService {

    /** 添加购物车 */
    ResponseVo addCart(Cart cart);

    /** 我的购物车 */
    ResponseVo myCart(Long userId);

    /** 移除购物车商品 */
    ResponseVo removeCart(Long id, Long userId);
}
