package com.c2c.service.impl;

import com.c2c.dao.UserDao;
import com.c2c.dto.UserInfoInDTO;
import com.c2c.dto.UserInfoOutDTO;
import com.c2c.entity.User;
import com.c2c.enums.ErrorMsgEnum;
import com.c2c.service.UserService;
import com.c2c.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * @description: 用户service层实现
 * @author: 段辉
 * @create: 2019-11-25 20:08:00
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private HttpSession session;

    /**
     * 通过用户名和密码查询用户
     * @param username
     * @param password
     * @return
     */
    @Override
    public ResponseVo findUserByUsernameAndPassword(String username, String password) {
        User findUser = userDao.findUserByUsernameAndPassword(username, password);
        if (null == findUser) {
            return ResponseVo.setFailure(ErrorMsgEnum.USERNAME_OR_PASSWORD_ERROR.getStatus(),
                    ErrorMsgEnum.USERNAME_OR_PASSWORD_ERROR.getMsg());
        }
        return ResponseVo.setSuccess(findUser);
    }

    /**
     * 注册用户
     * @param user
     * @return
     */
    @Override
    public ResponseVo insertUser(User user) {
        // 查询用户名是否存在
        if (userDao.findUserExist(user.getUsername()) > 0) {
            return ResponseVo.setFailure(ErrorMsgEnum.USERNAME_EXIST_ERROR.getStatus(),
                    ErrorMsgEnum.USERNAME_EXIST_ERROR.getMsg());
        }
        userDao.insertUser(user);
        return ResponseVo.setSuccess(user);
    }

    /**
     * 通过用户id修改用户密码
     * @param id
     * @param password
     */
    @Override
    public ResponseVo updatePasswordByUserId(Long id, String password) {
        if (null == id || null == password)
            return ResponseVo.setFailure(ErrorMsgEnum.CANT_BE_NULL.getStatus(),
                    ErrorMsgEnum.CANT_BE_NULL.getMsg());
        userDao.updatePasswordByUserId(id, password);
        return ResponseVo.setSuccess();
    }

    /**
     * 通过用户id删除用户
     * @param id
     */
    @Override
    public ResponseVo deleteUserById(Long id) {
        userDao.deleteUserById(id);
        return ResponseVo.setSuccess();
    }

    /**
     * 通过id查询用户基本信息
     * @param id
     * @return
     */
    @Override
    public ResponseVo findUserInfo(Long id) {
        UserInfoOutDTO findUser = userDao.findUserInfo(id);
        return ResponseVo.setSuccess(findUser);
    }

    /**
     * 通过id修改用户基本信息
     * @param userInfoInDTO
     * @return
     */
    @Override
    public ResponseVo updateUserInfo(UserInfoInDTO userInfoInDTO) {
        String findPwd = null;
        if (null != userInfoInDTO.getId()) {
            findPwd = userDao.findPasswordById(userInfoInDTO.getId());
        } else {
            User user = (User) session.getAttribute("user");
            if (user == null) {
                return ResponseVo.setFailure(ErrorMsgEnum.ID_CANT_BE_NULL.getStatus(),
                        ErrorMsgEnum.ID_CANT_BE_NULL.getMsg());
            }
            findPwd = userDao.findPasswordById(user.getId());
        }
        if (!findPwd.equals(userInfoInDTO.getOldPwd())) {
            return ResponseVo.setFailure(ErrorMsgEnum.PASSWORD_ERROR.getStatus(),
                    ErrorMsgEnum.PASSWORD_ERROR.getMsg());
        }
        userDao.updateUserInfo(userInfoInDTO);
        return ResponseVo.setSuccess();
    }

}
