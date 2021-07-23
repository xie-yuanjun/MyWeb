package com.demo.exception;

/**
 * @author admin
 * @Title: ServiceException
 * @ProjectName MyWeb
 * @Description: 在业务中出现的异常
 * @date 2021/7/1218:33
 */
public class ServiceException extends RuntimeException {
    public  ServiceException(){};

    public ServiceException(String message) {
        super(message);
    }
}
