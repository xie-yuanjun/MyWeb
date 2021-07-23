package com.demo.service;


import com.demo.entity.Comment;
import com.demo.po.CommentInfo;

import java.util.List;

/**
 * @author admin
 * @Title: ICommentService
 * @ProjectName word
 * @Description: 评论服务层接口
 * @date 2021/5/2014:56
 */
public interface CommentService {
    /**
     * 为文章添加评论
     * @param comment
     * @return
     */
    int addComment(Comment comment);

    /**
     * 查询所有评论
     * @param wordId
     * @return
     */
    List getAllComment(int wordId);

    /**
     * 查询评论回复
     * @param commentId
     * @return
     */
    Comment getAnswer(int commentId);

    /**
     * 根据wordId 列表查询评论和回复信息
     * @param wordId
     * @return
     */
    List<CommentInfo> selectByTopicIdList(List wordId);
}
