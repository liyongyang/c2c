package com.c2c.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @description: 商品实体类
 **/
@Data
public class Product {

    /** 商品ID */
    private Long id;

    /** 商品名称 */
    private String name;

    /** 商品成色 */
    private String level;

    /** 商品描述 */
    private String description;

    /** 价格 */
    private BigDecimal price;

    /** 商品类别 */
    private String type;

    /** 商品数量 */
    private Integer count;

    /** 商品是否被下架 */
    private int display;

    /** 交易方式 */
    private String transaction;

    /** 商品销量 */
    private Long sales;

    /** 商品图片 */
    private String image;

    /** 商品创建时间 */
    private Date time;

    /** 用户ID */
    private Long userId;
}
