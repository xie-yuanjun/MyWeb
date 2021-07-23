package com.demo.controller.user;

import com.demo.entity.Account;
import com.demo.service.AccountService;
import com.demo.utils.ResponseTemplate;
import com.demo.utils.StatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author admin
 * @Title: LoginController
 * @ProjectName word
 * @Description: TODO
 * @date 2021/7/1110:31
 */
@RestController
@Slf4j
public class LoginController {
    @Autowired
    private AccountService accountService;
    private ResponseTemplate response;
    /**
     * 登录
     *
     * @param account
     * @return
     */
    @GetMapping("/login")
    public ResponseTemplate login(Account account) {
        response = new ResponseTemplate();
        account = accountService.login(account);
        if (account != null) {
            response.setResponseTemplate(account);
        }
        response.setResponseTemplate(null, StatusEnum.FAILED, "用户名或密码不匹配！");
        return response;
    }
}
