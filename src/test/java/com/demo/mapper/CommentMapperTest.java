package com.demo.mapper;

import com.demo.entity.Comment;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author admin
 * @Title: CommentMapperTest
 * @ProjectName word
 * @Description: TODO
 * @date 2021/6/512:12
 */
public class CommentMapperTest extends TestBase {
    @Autowired
    private CommentMapper commentMapper;

    @Test
    public void selectByTopicTypeList() {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        List<Comment> commentList = commentMapper.selectByTopicIdList(list);
        if (commentList != null && commentList.size() != 0) {
            for (Object comment : commentList) {
                System.out.println((Comment)comment);
            }
        }
    }
}
