package com.demo.service.impl;

import com.demo.entity.Account;
import com.demo.mapper.AccountMapper;
import com.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author admin
 * @Title: AccountServiceImpl
 * @ProjectName word
 * @Description: TODO
 * @date 2021/7/100:58
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;

    /**
     * 用户登录时检查
     *
     * @param account
     * @return
     */
    public Account select(Account account) {
        Account account1 = accountMapper.select(account);
        if (account1 != null) {
            return account1;
        }
        return null;
    }

    /**
     * 登录
     *
     * @param account
     * @return
     */
    @Override
    public Account login(Account account) {
        if (account.getUsername() != null && account.getPassword() != null) {
            Account account1 = select(account);
            if (account.getPassword().equals(account1.getPassword())) {
                return account1;
            }
        }
        return null;
    }

    /**
     * 通过用户名查找用户
     *
     * @param username
     * @return
     */
    @Override
    public Account selectByUsername(String username) {
        return this.select(0, username);
    }

    /**
     * 通过 Id 查找用户
     *
     * @param id
     * @return
     */
    @Override
    public Account selectById(int id) {
        return this.select(id, null);
    }

    /**
     * 通过用户名判断用户是否存在
     *
     * @param username
     * @return
     */
    @Override
    public boolean ifExists(String username) {
        Account account = this.select(0, username);
        if (account != null) {
            return true;
        }
        return false;
    }

    /**
     * 通过用户id判断用户是否存在
     *
     * @param accountId
     * @return
     */
    @Override
    public boolean ifExists(int accountId) {
        Account account = this.select(accountId, null);
        if (account != null) {
            return true;
        }
        return false;
    }

    /**
     * 查找用户
     *
     * @param accountId
     * @param username
     * @return
     */
    private Account select(int accountId, String username) {
        Account account = new Account();
        account.setUsername(username);
        account.setId(accountId);

        return accountMapper.select(account);
    }

}
