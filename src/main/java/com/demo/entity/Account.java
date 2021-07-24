package com.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author admin
 * @Title: Account
 * @ProjectName word
 * @Description: TODO
 * @date 2021/7/1110:15
 */
@Data
@Component
@NoArgsConstructor
public class Account {
    private int id;
    private String username;
    private String password;

    public Account(int id) {
        this.id = id;
    }
}
