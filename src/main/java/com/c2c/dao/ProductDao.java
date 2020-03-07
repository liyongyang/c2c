package com.c2c.dao;

import com.c2c.dto.ProductDTO;
import com.c2c.dto.ProductDetailDTO;
import com.c2c.entity.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description: 商品DAO层
 **/
@Repository
public interface ProductDao {

    /** 查询所有商品 */
    List<ProductDTO> findAllProduct(Integer page);

    /** 商品详情 */
    ProductDetailDTO findProductDetail(Long productId);

    /** 通过类型查询商品 */
    List<ProductDTO> searchProduct(String type);

    /** 通过ID查询商品 */
    Product findProductById(Long productId);

    /** 新增商品 */
    void addProduct(Product product);

    /** 我的商品 */
    List<ProductDTO> myProduct(Long userId);

    /** 移除商品 */
    int removeProduct(@Param("id") Long id, @Param("userId") Long userId);
}
