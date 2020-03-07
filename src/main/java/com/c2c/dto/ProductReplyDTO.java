package com.c2c.dto;

import com.c2c.entity.ProductReply;
import lombok.Data;

/**
 * @description: 商品评论DTO
 **/
@Data
public class ProductReplyDTO extends ProductReply {

    /** 用户昵称 */
    private String userNickname;

}
