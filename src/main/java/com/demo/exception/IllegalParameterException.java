package com.demo.exception;

/**
 * @author admin
 * @Title: IllegalParameterException
 * @ProjectName MyWeb
 * @Description: 不合法的参数异常
 * @date 2021/7/2314:54
 */
public class IllegalParameterException extends ServiceException {
    public IllegalParameterException(){};

    public IllegalParameterException(String msg) {
        super(msg);
    }
}
