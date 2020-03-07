package com.c2c.controller;

import com.c2c.entity.Product;
import com.c2c.entity.User;
import com.c2c.enums.ErrorMsgEnum;
import com.c2c.service.ProductService;
import com.c2c.vo.PageResponseVo;
import com.c2c.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @description: 商品controller层
 **/
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private HttpSession session;

    /**
     * 查询所有商品
     * @param page
     * @return
     */
    @CrossOrigin(value = "http://localhost:4200")
    @RequestMapping(value = "/list/{page}", method = RequestMethod.GET)
    public PageResponseVo findAllProduct(@PathVariable("page") Integer page) {
        return productService.findAllProduct(page);
    }

    /**
     * 查询商品详情
     * @param id
     * @return
     */
    @CrossOrigin(value = "http://localhost:4200")
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public ResponseVo detail(@PathVariable("id") Long id) {
        if (id == null) {
            return ResponseVo.setFailure(ErrorMsgEnum.CANT_BE_NULL.getStatus(),
                    ErrorMsgEnum.CANT_BE_NULL.getMsg());
        }
        return productService.findProductDetail(id);
    }

    /**
     * 通过类型查询商品
     * @param type 商品类别
     * @return
     */
    @CrossOrigin(value = "http://localhost:4200")
    @RequestMapping(value = "/search/{type}", method = RequestMethod.GET)
    public ResponseVo search(@PathVariable("type") String type) {
        if (type == null) {
            return ResponseVo.setFailure(ErrorMsgEnum.TYPE_CANT_BE_NULL.getStatus(),
                    ErrorMsgEnum.TYPE_CANT_BE_NULL.getMsg());
        }
        return productService.searchProduct(type);
    }

    /**
     * 添加商品
     * @param product
     * @return
     */
    @CrossOrigin(value = "http://localhost:4200")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseVo addProduct(@RequestBody Product product) {
        User user = (User) session.getAttribute("user");
        if (null == user) {
            return ResponseVo.setFailure(ErrorMsgEnum.USER_NOT_LOGIN.getStatus(),
                    ErrorMsgEnum.USER_NOT_LOGIN.getMsg());
        }
        product.setUserId(user.getId());
        product.setTime(new Date());
        return productService.addProduct(product);
    }

    /**
     * 我发布的商品
     * @return
     */
    @CrossOrigin(value = "http://localhost:4200")
    @RequestMapping(value = "/mine", method = RequestMethod.GET)
    public ResponseVo mine() {
        User user = (User) session.getAttribute("user");
        if (null == user) {
            return ResponseVo.setFailure(ErrorMsgEnum.USER_NOT_LOGIN.getStatus(),
                    ErrorMsgEnum.USER_NOT_LOGIN.getMsg());
        }
        return productService.myProduct(user.getId());
    }

    /**
     * 移除商品
     * @param id
     * @return
     */
    @CrossOrigin(value = "http://localhost:4200")
    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    public ResponseVo remove(@PathVariable("id") Long id) {
        /*User user = (User) session.getAttribute("user");
        if (null == user) {
            return ResponseVo.setFailure(ErrorMsgEnum.USER_NOT_LOGIN.getStatus(),
                    ErrorMsgEnum.USER_NOT_LOGIN.getMsg());
        }
        return productService.removeProduct(id, user.getId());*/
        return productService.removeProduct(id, 1L);
    }
}
