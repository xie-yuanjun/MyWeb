package com.demo.mapper;

import com.demo.entity.AccountLikes;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author admin
 * @Title: AccountLikesMapper
 * @ProjectName MyWeb
 * @Description: TODO
 * @date 2021/7/1217:00
 */
@Repository
public interface AccountLikesMapper {

    /**
     * 检查数据库记录是否存在
     *
     * @param accountLikes
     * @return id, state
     */
    AccountLikes select(AccountLikes accountLikes);

    /**
     * 插入一条记录
     *
     * @param accountLikes
     * @return affect_row
     */
    int insert(AccountLikes accountLikes);

    /**
     * 修改state
     *
     * @param accountLikes
     * @return affect_row
     */
    int update(AccountLikes accountLikes);

    /**
     * 统计数量
     *
     * @param accountLikes
     * @return
     */
    int count(AccountLikes accountLikes);

    /**
     * 批量删除
     *
     * @param likesId
     * @return
     */
    int delete(int likesId);
}
