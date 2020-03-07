package com.c2c.controller;

import com.c2c.entity.Cart;
import com.c2c.entity.User;
import com.c2c.enums.ErrorMsgEnum;
import com.c2c.service.CartService;
import com.c2c.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @description: 购物车controller层
 **/
@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private HttpSession session;

    /**
     * 添加购物车
     * @param cart
     * @return
     */
    @CrossOrigin(value = "http://localhost:4200")
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ResponseVo add(@RequestBody Cart cart) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return ResponseVo.setFailure(ErrorMsgEnum.USER_NOT_LOGIN.getStatus(),
                    ErrorMsgEnum.USER_NOT_LOGIN.getMsg());
        }
        cart.setUserId(user.getId());
        if (cart.getQuantity() == null) {
            cart.setQuantity(1);
        }
        return cartService.addCart(cart);
    }

    /**
     * 我的购物车
     * @return
     */
    @CrossOrigin(value = "http://localhost:4200")
    @RequestMapping(value = "/mine", method = RequestMethod.GET)
    public ResponseVo mine() {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return ResponseVo.setFailure(ErrorMsgEnum.USER_NOT_LOGIN.getStatus(),
                    ErrorMsgEnum.USER_NOT_LOGIN.getMsg());
        }
        return cartService.myCart(user.getId());
    }

    /**
     * 移除购物车商品
     * @param id
     * @return
     */
    @CrossOrigin(value = "http://localhost:4200")
    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    public ResponseVo remove(@PathVariable("id") Long id) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return ResponseVo.setFailure(ErrorMsgEnum.USER_NOT_LOGIN.getStatus(),
                    ErrorMsgEnum.USER_NOT_LOGIN.getMsg());
        }
        return cartService.removeCart(id, user.getId());
    }

}
