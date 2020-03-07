package com.c2c.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @description: 商品评论实体
 **/
@Data
public class ProductReply implements Serializable {

    /** 评论ID */
    private Long id;

    /** 评论内容 */
    private String msg;

    /** 评论的商品ID */
    private Long productId;

    /** 评论人 */
    private Long userId;

    /** 评论时间 */
    private Date time;

    /** 是否可见 0为不可见 1为可见 */
    private Integer display;
}
