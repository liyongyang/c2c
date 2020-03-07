package com.c2c.dto;

import com.c2c.entity.Product;
import lombok.Data;

/**
 * @description: 收藏DTO
 **/
@Data
public class CollectDTO {

    private Long id;

    private Product product;

}
