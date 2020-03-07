package com.c2c.dto;

import lombok.Data;

/**
 * @description: 用户信息DTO
 * @author: 段辉
 * @create: 2019-12-12 09:06:01
 **/
@Data
public class UserInfoOutDTO {

    private Long id;

    private String nickname;

    private String realName;

    private String clazz;

    private Long sno;

    private Long phone;

    private String password;

}
