package com.demo.mapper;

import com.demo.entity.Likes;
import com.demo.entity.Word;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author admin
 * @Title: LikeMapper
 * @ProjectName word
 * @Description: LikesMapper接口
 * @date 2021/5/1915:21
 */
@Mapper
@Repository
public interface LikesMapper {

    /**
     * 检查likes表是否存在记录
     * @param likes
     * @return likesId
     */
    Likes select(Likes likes);

    /**
     * 插入一条记录
     * @param likes
     * @return
     */
    int insert(Likes likes);
}
