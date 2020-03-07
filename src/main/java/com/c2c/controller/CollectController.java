package com.c2c.controller;

import com.c2c.entity.Collect;
import com.c2c.entity.User;
import com.c2c.enums.ErrorMsgEnum;
import com.c2c.service.CollectService;
import com.c2c.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @description: 收藏controller层
 **/
@RestController
@RequestMapping("/collect")
public class CollectController {

    @Autowired
    private CollectService collectService;

    @Autowired
    private HttpSession session;

    /**
     * 新增收藏
     * @param productId
     * @return
     */
    @CrossOrigin(value = "http://localhost:4200")
    @RequestMapping(value = "/add/{productId}", method = RequestMethod.GET)
    public ResponseVo add(@PathVariable("productId") Long productId) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return ResponseVo.setFailure(ErrorMsgEnum.USER_NOT_LOGIN.getStatus(),
                    ErrorMsgEnum.USER_NOT_LOGIN.getMsg());
        }
        Collect collect = new Collect(productId, user.getId());
        return collectService.addCollect(collect);
    }

    /**
     * 我的收藏
     * @return
     */
    @CrossOrigin(value = "http://localhost:4200")
    @RequestMapping(value = "/mine", method = RequestMethod.GET)
    public ResponseVo mine() {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return ResponseVo.setFailure(ErrorMsgEnum.USER_NOT_LOGIN.getStatus(),
                    ErrorMsgEnum.USER_NOT_LOGIN.getMsg());
        }
        return collectService.myCollect(user.getId());
    }

    /**
     * 移除收藏商品
     * @param productId
     * @return
     */
    @CrossOrigin(value = "http://localhost:4200")
    @RequestMapping(value = "/remove/{productId}", method = RequestMethod.GET)
    public ResponseVo remove(@PathVariable("productId") Long productId) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return ResponseVo.setFailure(ErrorMsgEnum.USER_NOT_LOGIN.getStatus(),
                    ErrorMsgEnum.USER_NOT_LOGIN.getMsg());
        }
        return collectService.removeCollect(productId, user.getId());
    }
}
