package com.demo.mapper;


import com.demo.entity.Word;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author admin
 * @Title: WordMapper
 * @ProjectName note
 * @Description: TODO
 * @date 2021/3/1517:26
 */
@Mapper
@Repository
public interface WordMapper {

    /**
     * 修改
     *
     * @param word
     * @return int
     */
    int insert(Word word);

    /**
     * 删除
     *
     * @param word
     * @return
     */
    int delete(Word word);

    /**
     * 更新
     *
     * @param word
     * @return
     */
    int update(Word word);

    /**
     * 根据条件查询(id, author, classId)
     *
     * @param
     * @return
     */
    List<Word> select(Word word);

}
