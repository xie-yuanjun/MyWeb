package com.demo.mapper;


import com.demo.entity.WordClass;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author admin
 * @Title: WordClassMapper
 * @ProjectName word
 * @Description: 文档类型Mapper接口
 * @date 2021/3/1918:09
 */
@Repository
public interface WordClassMapper {

    /**
     * 新增文档类型
     * @param wordClass
     * @return
     */
    int insert(WordClass wordClass);

    /**
     * 删除文档类型
     * @param wordClass
     * @return
     */
    int delete(WordClass wordClass);

    /**
     * 修改文档类型
     * @param wordClass
     * @return
     */
    int update(WordClass wordClass);

    /**
     * 查找所有属于accountId的文档类型
     * @param wordClass
     * @return
     */
    List select(WordClass wordClass);

    /**
     * 根据wordClassIdList 查询文档类型
     * @param list
     * @return
     */
    List selectByClassIdList(List list);

    /**
     * 根据条件查找单个文档类别信息（name）
     * @param wordClass
     * @return
     */
    WordClass selectOne(WordClass wordClass);
}
