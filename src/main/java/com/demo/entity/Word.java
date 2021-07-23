package com.demo.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author admin
 * @Title: Word
 * @ProjectName word
 * @Description: TODO
 * @date 2021/7/919:01
 */
@Data
@Component
public class Word {
    private int id;
    private int accountId;
    private int classId;
    private String title;
    private String content;
    private Date createTime;
}
