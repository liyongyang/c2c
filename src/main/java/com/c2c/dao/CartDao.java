package com.c2c.dao;

import com.c2c.dto.CartDTO;
import com.c2c.entity.Cart;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 购物车DAO层
 */
@Repository
public interface CartDao {

    /** 添加购物车 */
    void addCart(Cart cart);

    /** 我的购物车 */
    List<CartDTO> myCart(Long userId);

    /** 删除购物车商品 */
    int removeCart(@Param("id") Long id, @Param("userId") Long userId);

    /** 通过id查询商品id */
    Long findProductIdById(Long id);
}
