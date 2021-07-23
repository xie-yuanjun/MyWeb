package com.demo.po;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author admin
 * @Title: Word
 * @ProjectName word
 * @Description: TODO
 * @date 2021/6/219:22
 */
@Data
@AllArgsConstructor
public class WordInfo {
    private int id;
    //标题
    private String title;
    //内容
    private String content;
    //类别
    private String wordClass;
    //作者
    private String author;
    //创建时间
    private String createTime;
}
