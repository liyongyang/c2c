package com.c2c.dto;

import com.c2c.entity.Product;
import com.c2c.entity.ProductReply;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @description: 商品详情
 **/
@Data
public class ProductDetailDTO extends Product implements Serializable {

    private String seller;

    private Long phone;

    private List<ProductReplyDTO> productReplyList;

}
