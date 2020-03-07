package com.c2c.service;

import com.c2c.entity.Collect;
import com.c2c.vo.ResponseVo;

/**
 * CollectService层接口
 */
public interface CollectService {

    /** 添加收藏 */
    ResponseVo addCollect(Collect collect);

    /** 我的收藏 */
    ResponseVo myCollect(Long userId);

    /** 移除收藏商品 */
    ResponseVo removeCollect(Long productId, Long userId);
}
