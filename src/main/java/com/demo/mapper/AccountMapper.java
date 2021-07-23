package com.demo.mapper;

import com.demo.entity.Account;
import org.springframework.stereotype.Repository;

/**
 * @author admin
 * @Title: AccountMapper
 * @ProjectName word
 * @Description: TODO
 * @date 2021/7/1110:17
 */
@Repository
public interface AccountMapper {

    /**
     * 查询
     *
     * @param account
     * @return
     */
    Account select(Account account);
}
