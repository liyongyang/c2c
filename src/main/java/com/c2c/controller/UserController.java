package com.c2c.controller;

import com.c2c.dto.AlterPasswordDTO;
import com.c2c.dto.UserInfoInDTO;
import com.c2c.entity.User;
import com.c2c.enums.ErrorMsgEnum;
import com.c2c.service.UserService;
import com.c2c.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @description: 用户controller层
 **/

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private HttpSession session;

    /**
     * 通过用户名密码查询用户
     * @param user
     * @return
     */
    @CrossOrigin(value = "http://localhost:4200")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseVo findUserByUsernameAndPassword(@RequestBody User user) {
        if (null == user.getUsername() || null == user.getPassword()) {
            return ResponseVo.setFailure(ErrorMsgEnum.CANT_BE_NULL.getStatus(),
                    ErrorMsgEnum.CANT_BE_NULL.getMsg());
        }
        ResponseVo responseVo = userService.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
        if (null != responseVo.getData()) {
            session.setAttribute("user", responseVo.getData());
        }
        return responseVo;
    }

    /**
     * 新增用户
     * @param user
     * @return
     */
    @CrossOrigin(value = "http://localhost:4200")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseVo register(@RequestBody User user) {
        return userService.insertUser(user);
    }

    /**
     * 通过用户id删除用户
     * @param id
     * @return
     */
    @CrossOrigin(value = "http://localhost:4200")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseVo deleteUserById(@PathVariable("id") Long id) {
        if (null == id) {
            return ResponseVo.setFailure(ErrorMsgEnum.CANT_BE_NULL.getStatus(),
                    ErrorMsgEnum.CANT_BE_NULL.getMsg());
        }
        return userService.deleteUserById(id);
    }

    /**
     * 通过用户id修改用户mim
     * @param alterPasswordDTO
     * @return
     */
    @CrossOrigin(value = "http://localhost:4200")
    @RequestMapping(value = "/alterPassword", method = RequestMethod.POST)
    public ResponseVo alterPassword(@RequestBody AlterPasswordDTO alterPasswordDTO) {
        if (null == alterPasswordDTO.getId() || null == alterPasswordDTO.getPassword()) {
            return ResponseVo.setFailure(ErrorMsgEnum.CANT_BE_NULL.getStatus(),
                    ErrorMsgEnum.CANT_BE_NULL.getMsg());
        }
        return userService.updatePasswordByUserId(alterPasswordDTO.getId(), alterPasswordDTO.getPassword());
    }

    /**
     * 通过id查询用户基本信息
     * @return
     */
    @CrossOrigin(value = "http://localhost:4200")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public ResponseVo findUserInfo() {
        User user = (User) session.getAttribute("user");
        if (null == user) {
            return ResponseVo.setFailure(ErrorMsgEnum.USER_NOT_LOGIN.getStatus(),
                    ErrorMsgEnum.USER_NOT_LOGIN.getMsg());
        }
        return userService.findUserInfo(user.getId());
    }

    /**
     * 通过id修改用户基本信息
     * @return
     */
    @CrossOrigin(value = "http://localhost:4200")
    @RequestMapping(value = "/info", method = RequestMethod.POST)
    public ResponseVo updateUserInfo(@RequestBody UserInfoInDTO userInfoInDTO) {
        return userService.updateUserInfo(userInfoInDTO);
    }
}
