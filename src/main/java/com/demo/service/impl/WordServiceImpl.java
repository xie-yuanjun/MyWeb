package com.demo.service.impl;


import com.demo.entity.Account;
import com.demo.entity.Word;
import com.demo.entity.WordClass;
import com.demo.mapper.AccountMapper;
import com.demo.mapper.WordMapper;
import com.demo.po.WordInfo;
import com.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author admin
 * @Title: WordServiceImpl
 * @ProjectName note
 * @Description: 文档业务类
 * @date 2021/3/1519:07
 */
@Service
public class WordServiceImpl implements WordService {
    @Autowired
    private WordMapper wordMapper;
    @Autowired
    private AccountService accountService;
    @Autowired
    private LikesService likesService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private WordClassService wordClassService;
    @Autowired
    private AccountMapper accountMapper;
    private WordInfo wordInfo;
    private List<WordInfo> wordInfoList;

    /**
     * 检查是否存在
     *
     * @param word
     * @return
     */
    @Override
    public Word ifExists(Word word) {
        List wordList = wordMapper.select(word);
        if (wordList == null || wordList.size() == 0) {
            return null;
        }
        return (Word) wordList.get(0);
    }

    /**
     * 添加新的文档
     *
     * @param word
     * @return
     */
    public int insert(Word word) {
        return wordMapper.insert(word);
    }

    /**
     * @param word
     * @return
     */
    @Override
    public int delete(Word word) {
        return wordMapper.delete(word);
    }

    /**
     * @param word
     * @return
     */
    @Override
    public int update(Word word) {
        return wordMapper.update(word);
    }


    /**
     * 根据标题模糊查找文档
     *
     * @param condition
     * @return
     */
    @Override
    public List<WordInfo> findWordByTitle(String condition) {
        wordInfoList = new ArrayList<>();

        //根据条件模糊查找word信息
        Word word_title = new Word();
        word_title.setTitle("%" + condition + "%");
        List<Word> wordList = wordMapper.select(word_title);

        //如果没有，直接返回
        if (wordList == null || wordList.size() == 0) {
            return wordInfoList;
        }

        //如果有，将word信息转换为wordInfo，然后返回
        for (Word word : wordList) {
            wordInfo = transWord(word);
            wordInfoList.add(wordInfo);
        }
        return wordInfoList;
    }

    /**
     * 根据类别查找文档
     *
     * @param category
     * @return
     */
    @Override
    public List<WordInfo> findWordByCategory(String category) {
        wordInfoList = new ArrayList<>();
        WordClass wordClass = new WordClass();
        wordClass.setName(category);
        wordClass = wordClassService.select(category);

        //判断有没有这个类别
        if (wordClass == null) {
            return null;
        }

        int classId = wordClass.getId();

        //根据classId查询文档信息
        Word word = new Word();
        word.setClassId(classId);
        List<Word> wordList = wordMapper.select(word);

        //判断这个类别下有没有文档
        if (wordList == null || wordList.size() == 0) {
            return null;
        }

        WordInfo wordInfo;
        for (Word word1 : wordList) {
            wordInfo = transWord(word1, null, category);
            wordInfoList.add(wordInfo);
        }
        return wordInfoList;
    }

    /**
     * 根据用户名查找
     *
     * @return
     */
    @Override
    public List<WordInfo> findWordByUsername(String username) {
        wordInfoList = null;

        //根据用户名查找用户id
        Account account = accountService.selectByUsername(username);
        int accountId = 0;
        if (account != null) {
            accountId = account.getId();
        }

        //根据用户id查找文档
        List<Word> wordList = null;
        if (accountId != 0) {
            Word word = new Word();
            word.setAccountId(accountId);
            wordList = wordMapper.select(word);
        }

        //数据类型转换
        if (wordList != null && wordList.size() != 0) {
            wordInfoList = new ArrayList<>();
            WordInfo wordInfo = null;
            for (Word word : wordList) {
                wordInfo = transWord(word, username, null);
                wordInfoList.add(wordInfo);
            }
        }
        return wordInfoList;
    }

    /**
     * 根据用户名和类别查找
     *
     * @param username
     * @param category
     * @return
     */
    @Override
    public List<WordInfo> findWordByUsernameAndCategory(String username, String category) {
        wordInfoList = null;

        //根据用户名查找用户Id
        Account account = accountService.selectByUsername(username);
        int accountId = 0;
        if (account != null) {
            accountId = account.getId();
        }

        //根据类别名查找类别id

        return null;
    }


    /**
     * 将 word 转换为 wordInfo
     *
     * @param word
     * @return
     */
    private WordInfo transWord(Word word) {
        //根据用户ID查询作者
        int accountId = word.getAccountId();
        Account account = accountService.selectById(accountId);
        String author = null;
        if (account != null) {
            author = account.getUsername();
        }

        //根据类别ID查询类别
        int classId = word.getClassId();
        WordClass wordClass = wordClassService.select(classId);
        String category = null;
        if (wordClass != null) {
            category = wordClass.getName();
        }

        return transWord(word, author, category);
    }

    /**
     * 将指定作者和类别的 word 转换为 wordInfo
     *
     * @param word
     * @param author
     * @param category
     * @return
     */
    private WordInfo transWord(Word word, String author, String category) {
        String title = word.getTitle();
        String content = word.getContent();
        String date = word.getCreateTime().toString();

        if (author == null) {
            ///根据用户ID查询作者
            int accountId = word.getAccountId();
            Account account = accountService.selectById(accountId);
            if (account != null) {
                author = account.getUsername();
            }
        }

        if (category == null) {
            //根据类别ID查询类别
            int classId = word.getClassId();
            WordClass wordClass = wordClassService.select(classId);
            if (wordClass != null) {
                category = wordClass.getName();
            }
        }

        return new WordInfo(title, content, category, author, date);
    }

}
