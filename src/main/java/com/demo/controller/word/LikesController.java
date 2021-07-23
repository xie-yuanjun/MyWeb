package com.demo.controller.word;

import com.demo.service.LikesService;
import com.demo.utils.ResponseTemplate;
import com.demo.utils.StatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author admin
 * @Title: LikeController
 * @ProjectName word
 * @Description: TODO
 * @date 2021/3/1918:04
 */
@RestController
@Slf4j
public class LikesController {
    @Autowired
    private LikesService likesService;
    private ResponseTemplate response;

    /**
     * 点赞
     *
     * @return
     */
    @RequestMapping(value = "/like", method = RequestMethod.GET)
    public ResponseTemplate like(int targetId, int accountId, String targetType) {
        response = new ResponseTemplate();
        boolean like = likesService.like(targetId, accountId, targetType);
        if (!like) {
            response.setResponseTemplate(null, StatusEnum.FAILED);
        }
        return response;
    }

    @GetMapping("/like/count")
    public ResponseTemplate getCount(int likesId) {
        return response;
    }
}
