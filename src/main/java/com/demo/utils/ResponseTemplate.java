package com.demo.utils;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author admin
 * @Title: ResponseTemplate
 * @ProjectName word
 * @Description: 响应模板
 * @date 2021/5/1914:46
 */
@Component
@Data
public class ResponseTemplate<T> {
    //状态
    private StatusEnum state;
    //状态码
    private String code;
    //提示信息
    private String tip;
    //数据
    private T data;

    @Autowired
    public ResponseTemplate() {
        this.state = StatusEnum.SUCCESS;
        this.code = state.getCode();
        this.tip = null;
        this.data = null;
    }

    public ResponseTemplate setResponseTemplate(T data, StatusEnum state) {
        return setResponseTemplate(data, state, "");
    }

    public ResponseTemplate setResponseTemplate(T data){
        return setResponseTemplate(data, StatusEnum.SUCCESS);
    }

    public ResponseTemplate setResponseTemplate(T data, StatusEnum state, String tip){
        this.state = state;
        this.code = state.getCode();
        this.tip = tip;
        this.data = data;
        return this;
    }

}
