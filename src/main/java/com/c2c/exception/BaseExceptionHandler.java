package com.c2c.exception;

import com.c2c.constants.StatusConstant;
import com.c2c.vo.ResponseVo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @Author: 55411
 * @Date: 2019/8/19 21:52
 * @Description: 全局异常处理
 */
@ControllerAdvice
@ResponseBody
public class BaseExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseVo exceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception e) throws Exception {
        return ResponseVo.setFailure(StatusConstant.SERVER_ERROR, "服务端内部错误");
    }

}
