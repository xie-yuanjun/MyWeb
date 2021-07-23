package com.demo.service;


import com.demo.entity.Word;
import com.demo.po.WordInfo;

import java.util.List;

/**
 * @author admin
 * @Title: IWordServiece
 * @ProjectName note
 * @Description: 文档业务类接口
 * @date 2021/3/1519:06
 */
public interface WordService {

    /**
     * 检查是否存在
     *
     * @param word
     * @return
     */
    Word ifExists(Word word);

    /**
     * 添加新的文档
     *
     * @param word
     * @return
     */
    int insert(Word word);

    /**
     * 删除文档
     *
     * @param word
     * @return
     */
    int delete(Word word);

    /**
     * 跟新文档（内容，标题）
     *
     * @param word
     * @return
     */
    int update(Word word);

    /**
     * 根据关键字查找文档
     *
     * @param condition
     * @return
     */
    List<WordInfo> findWordByTitle(String condition);

    /**
     * 根据类别查找文档
     *
     * @param category
     * @return
     */
    List<WordInfo> findWordByCategory(String category);

    /**
     * 根据用户名查找
     *
     * @param username
     * @return
     */
    List<WordInfo> findWordByUsername(String username);

    /**
     * 根据用户名和类别查找
     *
     * @param username
     * @param category
     * @return
     */
    List<WordInfo> findWordByUsernameAndCategory(String username, String category);
}
