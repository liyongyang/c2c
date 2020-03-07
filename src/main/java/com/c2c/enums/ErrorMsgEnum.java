package com.c2c.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @description: 错误信息枚举
 * @author: 段辉
 * @create: 2019-11-25 20:08:00
 **/
@Getter
@AllArgsConstructor
public enum ErrorMsgEnum {
    USERNAME_EXIST_ERROR(4000, "用户名已存在"),
    CANT_BE_NULL(4001, "不能为空"),
    USERNAME_OR_PASSWORD_ERROR(4002, "用户名或密码错误"),
    USER_NOT_LOGIN(4003, "用户未登录"),
    ID_CANT_BE_NULL(4004, "ID不能为空"),
    PASSWORD_ERROR(4005, "密码输入有误"),
    TYPE_CANT_BE_NULL(4006, "类别不能为空"),
    CANT_REMOVE_CART(4007, "不能移除购物车"),
    CANT_REMOVE_PRODUCT(4008, "不能移除商品")
    ;

    /** 错误状态码 */
    private int status;

    /** 错误提示信息 */
    private String msg;

}
