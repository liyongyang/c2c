package com.c2c.dao;

import com.c2c.dto.UserInfoInDTO;
import com.c2c.dto.UserInfoOutDTO;
import com.c2c.entity.User;
import com.c2c.vo.ResponseVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 用户dao
 */
@Repository
public interface UserDao {

    /** 通过用户名查询用户是否存在 */
    int findUserExist(String username);

    /** 通过用户名和密码查询用户 */
    User findUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    /** 注册用户 */
    void insertUser(User user);

    /** 通过用户id修改用户密码 */
    void updatePasswordByUserId(@Param("id") Long id, @Param("password") String password);

    /** 通过用户id删除用户 */
    void deleteUserById(Long id);

    /** 通过id查询用户基本信息 */
    UserInfoOutDTO findUserInfo(Long id);

    /** 通过id修改用户基本信息 */
    void updateUserInfo(UserInfoInDTO userInfoInDTO);

    /** 通过id查询用户密码 */
    String findPasswordById(Long id);
}
