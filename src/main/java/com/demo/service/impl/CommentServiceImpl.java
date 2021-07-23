package com.demo.service.impl;

import com.demo.entity.Comment;
import com.demo.mapper.CommentMapper;
import com.demo.po.CommentInfo;
import com.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author admin
 * @Title: CommentServiceImpl
 * @ProjectName word
 * @Description: 评论服务接口实现类
 * @date 2021/5/2015:03
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    private List<CommentInfo> commentInfoList;
    private CommentInfo commentInfo;

    /**
     * 为文章添加评论
     *
     * @param comment
     * @return
     */
    @Override
    public int addComment(Comment comment) {
        return commentMapper.addComment(comment);
    }

    /**
     * 查询所有评论
     *
     * @param wordId
     * @return
     */
    @Override
    public List getAllComment(int wordId) {
        return commentMapper.getAllComment(wordId);
    }

    /**
     * 查询评论回复
     *
     * @param commentId
     * @return
     */
    @Override
    public Comment getAnswer(int commentId) {
        return commentMapper.getAnswer(commentId);
    }

    /**
     * 根据wordId 列表查询评论和回复信息
     *
     * @param wordId
     * @return
     */
    @Override
    public List<CommentInfo> selectByTopicIdList(List wordId) {
        commentInfoList = new ArrayList<>();
        List<Comment> commentList = commentMapper.selectByTopicIdList(wordId);
        if (commentList != null && commentList.size() != 0) {
            for (Comment comment : commentList) {
                commentInfo = new CommentInfo();
                commentInfo.setId(comment.getId());
//                commentInfo.setAuthor(comment.getAccountId());
//                commentInfo.setReplyAccount(comment.getReplyId());
                commentInfo.setContent(comment.getContent());
                commentInfo.setType(comment.getCommentType());
                commentInfo.setCreateTime(comment.getCreateTime());
                commentInfoList.add(commentInfo);
            }
        }
        return commentInfoList;
    }
}
