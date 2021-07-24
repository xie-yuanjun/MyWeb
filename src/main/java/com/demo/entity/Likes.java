package com.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author admin
 * @Title: Love
 * @ProjectName word
 * @Description: TODO
 * @date 2021/7/920:23
 */
@Data
@Component
@NoArgsConstructor
public class Likes {
    private int id;
    private int targetId;
    private String targetType;

    public Likes(int targetId, String targetType) {
        this.targetId = targetId;
        this.targetType = targetType;
    }
}
