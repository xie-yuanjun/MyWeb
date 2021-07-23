package com.demo.service;

import com.demo.entity.Account;

/**
 * @author admin
 * @Title: IAccountService
 * @ProjectName word
 * @Description: TODO
 * @date 2021/7/1110:22
 */
public interface AccountService {

    /**
     * 检查是否存在
     *
     * @param account
     * @return
     */
    Account select(Account account);

    /**
     * 登录
     *
     * @param account
     * @return
     */
    Account login(Account account);

    /**
     * 通过用户名查找用户
     *
     * @param username
     * @return
     */
    Account selectByUsername(String username);

    /**
     * 通过 Id 查找用户
     *
     * @param id
     * @return
     */
    Account selectById(int id);

    /**
     * 通过用户名判断用户是否存在
     *
     * @param username
     * @return
     */
    boolean ifExists(String username);

    /**
     * 通过用户id判断用户是否存在
     *
     * @param accountId
     * @return
     */
    boolean ifExists(int accountId);
}
