package com.c2c.dto;

import lombok.Data;

/**
 * @description: 用户信息DTO
 * @author: 段辉
 * @create: 2019-12-12 09:09:42
 **/
@Data
public class UserInfoInDTO {

    private Long id;

    private String nickname;

    private Long phone;

    private String oldPwd;

    private String newPwd;

}
