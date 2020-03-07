package com.c2c.dao;

import com.c2c.dto.CollectDTO;
import com.c2c.entity.Collect;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 收藏DAO层
 */
@Repository
public interface CollectDao {

    /** 添加收藏 */
    void addCollect(Collect collect);

    /** 我的收藏 */
    List<CollectDTO> myCollect(Long userId);

    /** 取消收藏 */
    void removeCollect(@Param("productId") Long productId, @Param("userId") Long userId);
}
