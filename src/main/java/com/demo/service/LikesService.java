package com.demo.service;


import com.demo.entity.AccountLikes;
import com.demo.entity.Likes;

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
     *
     * @param accountLikes
     * @return accountLikes
     */
    AccountLikes ifExists(AccountLikes accountLikes);

    /**
     * 点赞/取消点赞
     *
     * @param targetId
     * @param accountId
     * @param targetType
     * @return
     */
    boolean like(int targetId, int accountId, String targetType);

    /**
     * 点赞人数
     *
     * @param targetId
     * @param targetType
     * @return
     */
    int getCount(int targetId, String targetType);

    /**
     * 增加一个赞
     *
     * @param targetId
     * @param targetType
     * @return
     */
    int addLike(int targetId, String targetType);

    /**
     * 增加一个赞
     *
     * @return
     */
    int addLike(Likes likes);

    /**
     * 删除一个赞
     *
     * @param targetId
     * @param targetType
     * @return
     */
    int delete(int targetId, String targetType);

    /**
     * 删除一个赞
     *
     * @param likes
     * @return
     */
    int delete(Likes likes);

    /**
     * 查看记录是否存在
     *
     * @param targetId
     * @param targetType
     * @return
     */
    boolean ifExists(int targetId, String targetType);

    /**
     * 查看记录是否存在
     *
     * @param likes
     * @return
     */
    boolean ifExists(Likes likes);
}
