package com.demo.po;

import lombok.Data;

import java.util.Date;

/**
 * @author admin
 * @Title: Comment
 * @ProjectName word
 * @Description: TODO
 * @date 2021/6/219:58
 */
@Data
public class CommentInfo {
    private int id;
    private String type;
    private String author;
    private String replyAccount;
    private String content;
    private Date createTime;
}
