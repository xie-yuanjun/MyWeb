package com.demo.controller;

import com.demo.exception.IllegalParameterException;
import com.demo.exception.ServiceException;
import com.demo.utils.ResponseTemplate;
import com.demo.utils.StatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author admin
 * @Title: ExceptionHandler
 * @ProjectName word
 * @Description: 异常处理
 * @date 2021/5/2916:50
 */
@RestControllerAdvice
public class ControllerExceptionHandler {
    @Autowired
    private ResponseTemplate responseTemplate;

    /**
     * 参数传递不合法异常
     * @param ex
     * @return
     */
    @ExceptionHandler(IllegalStateException.class)
    public ResponseTemplate IllegalStateExceptionHandler(IllegalStateException ex){
        responseTemplate.setResponseTemplate(null, StatusEnum.ERROR, "不合法的参数");
        return responseTemplate;
    }

    /**
     * 所有异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(IllegalParameterException.class)
    public ResponseTemplate ExceptionHandler(Exception e) {
        responseTemplate.setResponseTemplate(null, StatusEnum.FAILED, e.getMessage());
        return responseTemplate;
    }

    /**
     * 业务中出现的异常的处理
     * @param e
     * @return
     */
    @ExceptionHandler(ServiceException.class)
    public ResponseTemplate ServiceExceptionHandler(ServiceException e) {
        responseTemplate.setResponseTemplate(null, StatusEnum.ERROR, e.getMessage());
        return responseTemplate;
    }

}
