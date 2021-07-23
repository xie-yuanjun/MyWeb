package com.demo.entity;

import lombok.Data;
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
public class AccountLikes {
    private int id;
    private int accountId;
    private int likesId;
    private String state;
}
