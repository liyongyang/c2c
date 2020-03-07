package com.c2c.service.impl;

import com.c2c.dao.ProductDao;
import com.c2c.dto.ProductDTO;
import com.c2c.dto.ProductDetailDTO;
import com.c2c.entity.Product;
import com.c2c.enums.ErrorMsgEnum;
import com.c2c.service.ProductService;
import com.c2c.vo.PageResponseVo;
import com.c2c.vo.ResponseVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: 商品service接口实现
 **/
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    /** 每页商品显示数 */
    private static final Integer PRODUCT_PAGE_SIZE = 10;

    /**
     * 查询所有商品
     * @param page 查询页数
     * @return
     */
    @Override
    public PageResponseVo findAllProduct(Integer page) {
        PageHelper.startPage(page, PRODUCT_PAGE_SIZE);
        List<ProductDTO> productList = productDao.findAllProduct(page);
        PageInfo<ProductDTO> productPageInfo = new PageInfo<ProductDTO>(productList);
        PageResponseVo pageResponseVo = new PageResponseVo(
                200, null, productList,
                page,
                productPageInfo.getPageSize(),
                (int) productPageInfo.getTotal(),
                productPageInfo.getPages());
        return pageResponseVo;
    }

    /**
     * 查询商品详情
     * @param productId
     * @return
     */
    @Override
    public ResponseVo findProductDetail(Long productId) {
        ProductDetailDTO productDetail = productDao.findProductDetail(productId);
        return ResponseVo.setSuccess(productDetail);
    }

    /**
     * 通过类型查询商品
     * @param type
     * @return
     */
    @Override
    public ResponseVo searchProduct(String type) {
        List<ProductDTO> productDTOS = productDao.searchProduct(type);
        return ResponseVo.setSuccess(productDTOS);
    }

    /**
     * 新增商品
     * @param product
     */
    @Override
    public ResponseVo addProduct(Product product) {
        productDao.addProduct(product);
        return ResponseVo.setSuccess();
    }

    /**
     * 我的商品
     * @param userId
     * @return
     */
    @Override
    public ResponseVo myProduct(Long userId) {
        List<ProductDTO> products = productDao.myProduct(userId);
        return ResponseVo.setSuccess(products);
    }

    /**
     * 移除商品
     * @param id
     * @param userId
     * @return
     */
    @Override
    public ResponseVo removeProduct(Long id, Long userId) {
        Product product = productDao.findProductById(id);
        int removeNumber = productDao.removeProduct(id, userId);
        if (removeNumber <= 0) {
            return ResponseVo.setFailure(ErrorMsgEnum.CANT_REMOVE_PRODUCT.getStatus(),
                    ErrorMsgEnum.CANT_REMOVE_PRODUCT.getMsg());
        }
        return ResponseVo.setSuccess(product);
    }
}
