package com.c2c.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 带分页的返回信息
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResponseVo extends ResponseVo {

    /** 当前页数 */
    private Integer page;

    /** 每页显示数 */
    private Integer size;

    /** 查询总数 */
    private Integer total;

    /** 总页数 */
    private Integer pages;

    public PageResponseVo(int status, String msg, Object data, Integer page, Integer size, Integer total, Integer pages) {
        super(status, msg, data);
        this.page = page;
        this.size = size;
        this.total = total;
        this.pages = pages;
    }
}
