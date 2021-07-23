package com.demo.entity;

import lombok.Data;
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
public class WordClass {
    private int id;
    private int accountId;
    private String name;
}
