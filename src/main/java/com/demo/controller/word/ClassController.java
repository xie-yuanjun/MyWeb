package com.demo.controller.word;

import com.demo.service.WordClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author admin
 * @Title: ClassController
 * @ProjectName word
 * @Description: 文档类型接口
 * @date 2021/3/1918:04
 */
@RestController
public class ClassController {
    @Autowired
    private WordClassService wordClassService;

}
