package com.demo.service;


import com.demo.entity.AccountLikes;

/**
 * @author admin
 * @Title: ILikeService
 * @ProjectName word
 * @Description: 点赞服务层接口
 * @date 2021/5/1914:08
 */
public interface LikesService {

    /**
     * 验证数据是否存在记录
     * @param accountLikes
     * @return accountLikes
     */
    AccountLikes ifExists(AccountLikes accountLikes);

    /**
     * 点赞/取消点赞
     * @param targetId
     * @param accountId
     * @param targetType
     * @return
     */
    boolean like(int targetId, int accountId, String targetType);

    /**
     * 点赞人数
     * @param targetId
     * @param targetType
     * @return
     */
    int getCount(int targetId, String targetType);

}
