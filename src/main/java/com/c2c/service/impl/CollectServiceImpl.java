package com.c2c.service.impl;

import com.c2c.dao.CollectDao;
import com.c2c.dao.ProductDao;
import com.c2c.dto.CollectDTO;
import com.c2c.entity.Collect;
import com.c2c.entity.Product;
import com.c2c.service.CollectService;
import com.c2c.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: CollectService层接口实现
 **/
@Service
public class CollectServiceImpl implements CollectService {

    @Autowired
    private CollectDao collectDao;

    @Autowired
    private ProductDao productDao;

    /**
     * 添加收藏
     * @param collect
     */
    @Override
    public ResponseVo addCollect(Collect collect) {
        collectDao.addCollect(collect);
        return ResponseVo.setSuccess();
    }

    /**
     * 我的收藏
     * @param userId
     * @return
     */
    @Override
    public ResponseVo myCollect(Long userId) {
        List<CollectDTO> collectDTOS = collectDao.myCollect(userId);
        return ResponseVo.setSuccess(collectDTOS);
    }

    /**
     * 移除收藏商品
     * @param productId
     * @param userId
     * @return
     */
    @Override
    public ResponseVo removeCollect(Long productId, Long userId) {
        collectDao.removeCollect(productId, userId);
        Product product = productDao.findProductById(productId);
        return ResponseVo.setSuccess(product);
    }
}
