package com.demo.service.impl;

import com.demo.entity.Account;
import com.demo.entity.AccountLikes;
import com.demo.entity.Likes;
import com.demo.entity.Word;
import com.demo.exception.ServiceException;
import com.demo.mapper.AccountLikesMapper;
import com.demo.mapper.LikesMapper;
import com.demo.service.AccountService;
import com.demo.service.LikesService;
import com.demo.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        //判断文档是否存在
        Word word = new Word();
        if (targetType.equals("word")) {
            word.setId(targetId);
            word = wordService.ifExists(word);
            if (word == null) {
                throw new ServiceException("不存在id为" + targetId + "的文档！");
            }
        }

        //判断用户是否存在
        Account account = new Account();
        account.setId(accountId);
        Account accountInfo = accountService.select(account);
        if (accountInfo == null) {
            throw new ServiceException("不存在id为" + accountId + "的用户！");
        }

        //判断 点赞/取消
        Likes likes = new Likes();
        likes.setTargetId(targetId);
        likes.setTargetType(targetType.toUpperCase());
        likes = likesMapper.select(likes);              //查找likesId
        AccountLikes accountLikes = new AccountLikes();
        accountLikes.setAccountId(accountId);
        accountLikes.setLikesId(likes.getId());
        accountLikes = ifExists(accountLikes);          //通过accountId 和 likesId 判断是否已经存在记录
        if (accountLikes == null) {
            int i = accountLikesMapper.insert(accountLikes);
            if (i == 1) {
                return true;
            }
        }

        //通过查询出来的 state 修改 state
        if (accountLikes.getState().equals("YES")) {
            accountLikes.setState("NO");
        } else {
            accountLikes.setState("YES");
        }
        accountLikesMapper.update(accountLikes);
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
        Likes likes = new Likes();
        AccountLikes accountLikes = new AccountLikes();
        likes.setTargetType(targetType);
        likes.setTargetId(targetId);
        likes = likesMapper.select(likes);
        if (likes != null) {
            accountLikes.setLikesId(likes.getId());
            int count = accountLikesMapper.count(accountLikes);
        }
        return 0;
    }
}
