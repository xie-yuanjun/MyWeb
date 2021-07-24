package com.demo.exception;

/**
 * @author admin
 * @Title: IncorrectParamsException
 * @ProjectName MyWeb
 * @Description: TODO
 * @date 2021/7/2417:33
 */
public class IncorrectParamsException extends ServiceException {
    public IncorrectParamsException(){}

    public IncorrectParamsException(String msg) {
        super(msg);
    }
}
