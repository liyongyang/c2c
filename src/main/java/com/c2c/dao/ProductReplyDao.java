package com.c2c.dao;

import com.c2c.dto.ProductReplyDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 商品DAO层
 */
@Repository
public interface ProductReplyDao {

    /** 查询商品留言 */
    List<ProductReplyDTO> findProductReply(Long productId);

}
