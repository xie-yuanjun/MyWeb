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

    /**
     * 设置提示信息，数据默认为空，状态默认成功
     *
     * @param tip
     * @return
     */
    public ResponseTemplate setResponseTemplate(String tip) {
       return this.setResponseTemplate(null, StatusEnum.SUCCESS, tip);
    }

    /**
     * 设置返回数据、提示信息，状态默认成功
     * @param data
     * @param tip
     * @return
     */
    public ResponseTemplate setResponseTemplate(T data, String tip) {
        return setResponseTemplate(data, StatusEnum.SUCCESS, tip);
    }

    /**
     * 设置状态、提示信息，数据默认为空
     * @param state
     * @param tip
     * @return
     */
    public ResponseTemplate setResponseTemplate(StatusEnum state, String tip) {
        return setResponseTemplate(null, state, tip);
    }

    /**
     * 设置返回数据、状态
     *
     * @param data
     * @param state
     * @return
     */
    public ResponseTemplate setResponseTemplate(T data, StatusEnum state) {
        return setResponseTemplate(data, state, null);
    }

    /**
     * 设置返回数据，状态默认成功
     *
     * @param data
     * @return
     */
    public ResponseTemplate setResponseTemplate(T data) {
        return setResponseTemplate(data, StatusEnum.SUCCESS, null);
    }

    /**
     * 设置返回数据、状态、提示信息
     *
     * @param data
     * @param state
     * @param tip
     * @return
     */
    public ResponseTemplate setResponseTemplate(T data, StatusEnum state, String tip) {
        this.state = state;
        this.code = state.getCode();
        this.tip = tip;
        this.data = data;
        return this;
    }

}
