package com.demo.exception;

/**
 * @author admin
 * @Title: NotFindException
 * @ProjectName MyWeb
 * @Description: TODO
 * @date 2021/7/2317:24
 */
public class NotFindException extends ServiceException {
    public NotFindException(){}

    public NotFindException(String msg) {
        super(msg);
    }
}
