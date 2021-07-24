package com.demo.service.impl;

import com.demo.entity.WordClass;
import com.demo.mapper.WordClassMapper;
import com.demo.po.WordClassInfo;
import com.demo.service.WordClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author admin
 * @Title: WordClassServiceImpl
 * @ProjectName word
 * @Description: 文档类型服务层实现类
 * @date 2021/3/1918:36
 */
@Service
public class WordClassServiceImpl implements WordClassService {
    @Autowired
    private WordClassMapper wordClassMapper;
    private List<WordClassInfo> wordClassInfoList;
    private WordClassInfo wordClassInfo;

    /**
     * 新增文档类型
     *
     * @param wordClass
     * @return
     */
    @Override
    public int add(WordClass wordClass) {
        return wordClassMapper.insert(wordClass);
    }

    /**
     * 删除文档类型
     *
     * @param wordClass
     * @return
     */
    @Override
    public int delete(WordClass wordClass) {
        return wordClassMapper.delete(wordClass);
    }

    /**
     * 修改文档类型
     *
     * @param wordClass
     * @return
     */
    @Override
    public int update(WordClass wordClass) {
        return wordClassMapper.update(wordClass);
    }

    /**
     * 查找所有属于accountId的文档类型
     *
     * @param wordClass
     * @return
     */
    @Override
    public List select(WordClass wordClass) {
        return wordClassMapper.select(wordClass);
    }

    /**
     * 根据类别名查找类别
     *
     * @param category
     * @return
     */
    @Override
    public WordClass select(String category) {
        return this.select(0, category);
    }

    /**
     * 通过类别id查找类别
     *
     * @param classId
     * @return
     */
    @Override
    public WordClass select(int classId) {
        return this.select(classId, null);
    }

    /**
     * 通过多条件查找类别信息
     *
     * @param classId
     * @param category
     * @return
     */
    private WordClass select(int classId, String category) {
        WordClass wordClass = new WordClass();
        wordClass.setName(category);
        wordClass.setId(classId);
        return wordClassMapper.selectOne(wordClass);
    }

    /**
     * 根据classId 列表查询文档类型
     *
     * @param classId
     * @return
     */
    @Override
    public List<WordClassInfo> selectByClassIdList(List classId) {
        wordClassInfoList = new ArrayList<>();
        List<WordClass> wordClassList = wordClassMapper.selectByClassIdList(classId);
        if (wordClassList != null && wordClassList.size() != 0) {
            for (WordClass wordClass : wordClassList) {
                wordClassInfo = new WordClassInfo();
                wordClassInfo.setId(wordClass.getId());
                wordClassInfo.setName(wordClass.getName());
                wordClassInfoList.add(wordClassInfo);
            }
        }
        return wordClassInfoList;
    }

    /**
     * 查看是否存在文档类型--根据id
     *
     * @param classId
     * @return
     */
    @Override
    public boolean ifExists(int classId) {
        return this.ifExists(new WordClass(classId));
    }

    /**
     * 查看是否存在文档类型--根据accountId, category
     *
     * @param accountId
     * @param category
     * @return
     */
    @Override
    public boolean ifExists(int accountId, String category) {
        return this.ifExists(new WordClass(accountId, category));
    }

    /**
     * 查看用户是否拥有此文档类型--根据classId, accountId
     *
     * @param classId
     * @param accountId
     * @return
     */
    @Override
    public boolean ifExists(int classId, int accountId) {
        return this.ifExists(new WordClass(classId, accountId));
    }

    /**
     * 查看是否存在文档类型
     *
     * @param wordClass
     * @return
     */
    @Override
    public boolean ifExists(WordClass wordClass) {
        WordClass wordClass1 = wordClassMapper.selectOne(wordClass);
        if (wordClass1 != null) {
            return true;
        }
        return false;
    }
}
