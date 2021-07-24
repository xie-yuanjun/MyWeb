package com.demo.service.impl;

import com.demo.entity.Account;
import com.demo.entity.AccountLikes;
import com.demo.entity.Likes;
import com.demo.entity.Word;
import com.demo.exception.DeleteException;
import com.demo.exception.ServiceException;
import com.demo.mapper.AccountLikesMapper;
import com.demo.mapper.LikesMapper;
import com.demo.service.AccountService;
import com.demo.service.LikesService;
import com.demo.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author admin
 * @Title: LikeServiceImpl
 * @ProjectName word
 * @Description: 点赞服务实现类
 * @date 2021/5/1915:04
 */
@Service
public class LikesServiceImpl implements LikesService {
    @Autowired
    private WordService wordService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private LikesMapper likesMapper;
    @Autowired
    private AccountLikesMapper accountLikesMapper;

    /**
     * 验证数据是否存在记录
     *
     * @param accountLikes
     * @return accountLikes
     */
    @Override
    public AccountLikes ifExists(AccountLikes accountLikes) {
        return accountLikesMapper.select(accountLikes);
    }

    /**
     * 点赞/取消点赞
     *
     * @param targetId
     * @param accountId
     * @param targetType
     * @return
     */
    @Override
    public boolean like(int targetId, int accountId, String targetType) {
        targetType = targetType.toUpperCase();

        //判断文档或评论是否存在
        if (targetType.equals("WORD")) {
            Word word = wordService.ifExists(new Word(targetId));
            if (word == null) {
                throw new ServiceException("不存在id为" + targetId + "的文档！");
            }
        }

        //判断用户是否存在
        Account accountInfo = accountService.select(new Account(accountId));
        if (accountInfo == null) {
            throw new ServiceException("不存在id为" + accountId + "的用户！");
        }

        //判断是否点过赞
        Likes likes = likesMapper.select(new Likes(targetId, targetType));                         //查找likesId
        AccountLikes accountLikes = ifExists(new AccountLikes(accountId, likes.getId()));          //通过accountId 和 likesId 判断是否已经存在记录
        if (accountLikes == null) {
            int i = accountLikesMapper.insert(new AccountLikes(accountId, likes.getId()));
            if (i == 1) {
                return true;
            }
        }

        //已经点过赞，存在记录，则修改点赞记录状态
        if (accountLikes.getState().equals("YES")) {
            accountLikes.setState("NO");
        } else {
            accountLikes.setState("YES");
        }
        int var = accountLikesMapper.update(accountLikes);
        if (var == 0) {
            return false;
        }
        return true;
    }

    /**
     * 点赞人数
     *
     * @param targetId
     * @param targetType
     * @return
     */
    @Override
    public int getCount(int targetId, String targetType) {
        targetType = targetType.toUpperCase();


        Likes likes = likesMapper.select(new Likes(targetId, targetType));
        int count = 0;
        if (likes != null) {
            count = accountLikesMapper.count(new AccountLikes(likes.getId()));
        }

        return count;
    }

    /**
     * 增加一个赞
     *
     * @param targetId
     * @param targetType
     * @return
     */
    @Override
    public int addLike(int targetId, String targetType) {
        targetType = targetType.toUpperCase();
        return addLike(new Likes(targetId, targetType));
    }

    /**
     * 增加一个赞
     *
     * @return
     */
    @Override
    public int addLike(Likes likes) {
        return likesMapper.insert(likes);
    }

    /**
     * 删除一个赞
     *
     * @param targetId
     * @param targetType
     * @return
     */
    @Override
    public int delete(int targetId, String targetType) {
        return this.delete(new Likes(targetId, targetType));
    }

    /**
     * 删除一个赞
     *
     * @param likes
     * @return
     */
    @Override
    @Transactional
    public int delete(Likes likes) {
        likes = likesMapper.selectOne(likes);
        if (likes == null) {
            throw new DeleteException("试图删除不存在的记录");
        }

        AccountLikes accountLikes = accountLikesMapper.select(new AccountLikes(likes.getId()));
        if (accountLikes != null) {
            accountLikesMapper.delete(likes.getId());
        }

        return likesMapper.delete(likes);
    }

    /**
     * 查看记录是否存在
     *
     * @param targetId
     * @param targetType
     * @return
     */
    @Override
    public boolean ifExists(int targetId, String targetType) {
        return ifExists(new Likes(targetId, targetType));
    }

    /**
     * 查看记录是否存在
     *
     * @param likes
     * @return
     */
    @Override
    public boolean ifExists(Likes likes) {
        likes = likesMapper.select(likes);
        if (likes != null) {
            return true;
        }
        return false;
    }
}
