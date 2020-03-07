package com.c2c.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @description: 返回前端视图
 * @author: 段辉
 * @create: 2019-11-25 20:08:00
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseVo implements Serializable {

    /** 状态码 */
    private int status;

    /** 提示信息 */
    private String msg;

    /** 数据 */
    private Object data;

    public static ResponseVo setSuccess() {
        return new ResponseVo(200, null, null);
    }

    public static ResponseVo setSuccess(Object data) {
        return new ResponseVo(200, null, data);
    }

    public static ResponseVo setSuccess(int code, Object data) {
        return new ResponseVo(code, null, data);
    }

    public static ResponseVo setFailure(int code, String msg) {
        return new ResponseVo(code, msg, null);
    }

}
