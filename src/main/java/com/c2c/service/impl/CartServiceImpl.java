package com.c2c.service.impl;

import com.c2c.dao.CartDao;
import com.c2c.dao.ProductDao;
import com.c2c.dto.CartDTO;
import com.c2c.entity.Cart;
import com.c2c.entity.Product;
import com.c2c.enums.ErrorMsgEnum;
import com.c2c.service.CartService;
import com.c2c.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description: 购物车service层接口实现
 **/
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDao cartDao;

    @Autowired
    private ProductDao productDao;

    /**
     * 添加购物车
     * @param cart
     * @return
     */
    @Override
    public ResponseVo addCart(Cart cart) {
        cartDao.addCart(cart);
        return ResponseVo.setSuccess();
    }

    /**
     * 我的购物车
     * @param userId
     * @return
     */
    @Override
    public ResponseVo myCart(Long userId) {
        List<CartDTO> cartDTOS = cartDao.myCart(userId);
        return ResponseVo.setSuccess(cartDTOS);
    }

    /**
     * 移除购物车
     * @param id
     * @return
     */
    @Override
    public ResponseVo removeCart(Long id, Long userId) {
        Long productId = cartDao.findProductIdById(id);
        int removeNumber = cartDao.removeCart(id, userId);
        if (removeNumber <= 0) {
            return ResponseVo.setFailure(ErrorMsgEnum.CANT_REMOVE_CART.getStatus(),
                    ErrorMsgEnum.CANT_REMOVE_CART.getMsg());
        }
        Product product = productDao.findProductById(productId);
        return ResponseVo.setSuccess(product);
    }
}
