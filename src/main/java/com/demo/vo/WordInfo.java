package com.demo.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author admin
 * @Title: V0WordCard
 * @ProjectName word
 * @Description: TODO
 * @date 2021/7/917:11
 */
@Data
@NoArgsConstructor
public class WordInfo {
    //标题
    private String title;
    //作者
    private String author;
    //创建时间
    private Date creatTime;
    //浏览人数
    private String overview;
    // 点赞人数
    private int likeCount;
}
