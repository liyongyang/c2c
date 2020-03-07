package com.c2c.service;

import com.c2c.dto.ProductDTO;
import com.c2c.dto.ProductDetailDTO;
import com.c2c.entity.Product;
import com.c2c.vo.PageResponseVo;
import com.c2c.vo.ResponseVo;

import java.util.List;

/**
 * @description: 商品service接口
 **/
public interface ProductService {

    /** 查询所有商品 */
    PageResponseVo findAllProduct(Integer page);

    /** 商品详情 */
    ResponseVo findProductDetail(Long productId);

    /** 通过类型查询商品 */
    ResponseVo searchProduct(String type);

    /** 新增商品 */
    ResponseVo addProduct(Product product);

    /** 我的商品 */
    ResponseVo myProduct(Long userId);

    /** 移除商品 */
    ResponseVo removeProduct(Long id, Long productId);
}
