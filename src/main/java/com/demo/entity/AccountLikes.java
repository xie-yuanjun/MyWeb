package com.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author admin
 * @Title: AccountLikes
 * @ProjectName MyWeb
 * @Description: TODO
 * @date 2021/7/1215:57
 */
@Data
@Component
@NoArgsConstructor
public class AccountLikes {
    private int id;
    private int accountId;
    private int likesId;
    private String state;

    public AccountLikes(int likesId) {
        this.likesId = likesId;
    }

    public AccountLikes(int accountId, int likesId) {
        this.accountId = accountId;
        this.likesId = likesId;
    }
}
