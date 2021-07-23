package com.demo.entity;

import lombok.Data;
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
public class Account {
    private int id;
    private String username;
    private String password;
}
