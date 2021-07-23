package com.demo.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author admin
 * @Title: Comment
 * @ProjectName word
 * @Description: TODO
 * @date 2021/7/918:56
 */
@Data
@Component
public class Comment {
    private int id;
    private String topicType;
    private int topicId;
    private int accountId;
    private String content;
    private String commentType;
    private Date createTime;
    private int replyId;
    private int link;
}
