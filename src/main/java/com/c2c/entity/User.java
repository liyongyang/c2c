package com.c2c.entity;

import lombok.Data;

import java.util.Date;

/**
 * 用户实体对象
 */
@Data
public class User {

    /** 用户id */
    private Long id;

    /** 用户名 */
    private String username;

    /** 密码 */
    private String password;

    /** 昵称 */
    private String nickname;

    /** 真实名称 */
    private String realName;

    /** 手机号 */
    private Long phone;

    /** 班级 */
    private String clazz;

    /** 学号 */
    private Long sno;

    /** 宿舍 */
    private String dormitory;

    /** 性别 */
    private String gender;

    /** 创建时间 */
    private Date createTime;

    /** 头像 */
    private String avatar;

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username='" + username + '\'' + ", password='" + password + '\'' + ", nickname='" + nickname + '\'' + ", realName='" + realName + '\'' + ", phone=" + phone + ", clazz='" + clazz + '\'' + ", sno=" + sno + ", dormitory='" + dormitory + '\'' + ", gender='" + gender + '\'' + ", createTime=" + createTime + ", avatar='" + avatar + '\'' + '}';
    }
}
