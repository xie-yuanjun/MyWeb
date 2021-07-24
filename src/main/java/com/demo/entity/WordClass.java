package com.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author admin
 * @Title: WordClass
 * @ProjectName word
 * @Description: TODO
 * @date 2021/7/920:47
 */
@Data
@Component
@NoArgsConstructor
public class WordClass {
    private int id;
    private int accountId;
    private String name;

    public WordClass(int id) {
        this.id = id;
    }

    public WordClass(int id, int accountId) {
        this.id = id;
        this.accountId = accountId;
    }

    public WordClass(int accountId, String category) {
        this.accountId = accountId;
        this.name = category;
    }
}
