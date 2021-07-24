package com.demo.exception;

/**
 * @author admin
 * @Title: DeleteException
 * @ProjectName MyWeb
 * @Description: TODO
 * @date 2021/7/2416:59
 */
public class DeleteException extends ServiceException {
    public DeleteException(){}

    public DeleteException(String msg) {
        super(msg);
    }
}
