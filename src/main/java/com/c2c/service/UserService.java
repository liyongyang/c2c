package com.c2c.service;

import com.c2c.dto.UserInfoInDTO;
import com.c2c.entity.User;
import com.c2c.vo.ResponseVo;

/**
 * @description: 用户service接口
 **/
public interface UserService {

    /** 通过用户名和密码查询用户 */
    ResponseVo findUserByUsernameAndPassword(String username, String password);

    /** 注册用户 */
    ResponseVo insertUser(User user);

    /** 通过用户id修改用户密码 */
    ResponseVo updatePasswordByUserId(Long id, String password);

    /** 通过用户id删除用户 */
    ResponseVo deleteUserById(Long id);

    /** 通过id查询用户基本信息 */
    ResponseVo findUserInfo(Long id);

    /** 通过id修改用户基本信息 */
    ResponseVo updateUserInfo(UserInfoInDTO userInfoInDTO);
}
