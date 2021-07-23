package com.demo.mapper;

import com.demo.entity.Comment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author admin
 * @Title: CommentMapper
 * @ProjectName word
 * @Description: 评论功能Mapper接口
 * @date 2021/5/2015:16
 */
@Repository
public interface CommentMapper {

    /**
     * 添加评论
     * @param comment
     * @return
     */
    int addComment(Comment comment);

    /**
     * 查询所有评论
     * @param wordId
     * @return
     */
    List getAllComment(@Param("wordId") int wordId);

    /**
     * 查寻评论的回复
     * @param commentId
     * @return
     */
    Comment getAnswer(@Param("commentId") int commentId);

    /**
     * 根据topic_type列表查询评论信息
     * @param wordId
     * @return
     */
    List<Comment> selectByTopicIdList(List wordId);
}
