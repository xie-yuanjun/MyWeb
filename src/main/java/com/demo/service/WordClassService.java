package com.demo.service;


import com.demo.entity.WordClass;
import com.demo.po.WordClassInfo;

import java.util.List;

/**
 * @author admin
 * @Title: IWordClassService
 * @ProjectName word
 * @Description: 文档类型服务层接口
 * @date 2021/3/1918:29
 */
public interface WordClassService {

    /**
     * 新增文档类型
     *
     * @param wordClass
     * @return
     */
    int add(WordClass wordClass);

    /**
     * 删除文档类型
     *
     * @param wordClass
     * @return
     */
    int delete(WordClass wordClass);

    /**
     * 修改文档类型
     *
     * @param wordClass
     * @return
     */
    int update(WordClass wordClass);

    /**
     * 根据多条件查找文档类别
     *
     * @param wordClass
     * @return
     */
    List select(WordClass wordClass);

    /**
     * 根据类别名查找类别
     *
     * @param category
     * @return
     */
    WordClass select(String category);

    /**
     * 通过类别id查找类别
     *
     * @param classId
     * @return
     */
    WordClass select(int classId);

    /**
     * 根据classId 列表查询文档类型
     *
     * @param classId
     * @return
     */
    List<WordClassInfo> selectByClassIdList(List classId);

    /**
     * 查看是否存在文档类型--根据id
     *
     * @param classId
     * @return
     */
    boolean ifExists(int classId);

    /**
     * 查看用户是否拥有此文档类型--根据accountId, category
     *
     * @param accountId
     * @param category
     * @return
     */
    boolean ifExists(int accountId, String category);

    /**
     * 查看用户是否拥有此文档类型--根据classId, accountId
     *
     * @param classId
     * @param accountId
     * @return
     */
    boolean ifExists(int classId, int accountId);

    /**
     * 查看是否存在文档类型
     *
     * @param wordClass
     * @return
     */
    boolean ifExists(WordClass wordClass);
}
