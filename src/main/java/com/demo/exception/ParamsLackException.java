package com.demo.exception;

/**
 * @author admin
 * @Title: ParamsLackException
 * @ProjectName MyWeb
 * @Description: TODO
 * @date 2021/7/2417:08
 */
public class ParamsLackException extends ServiceException{
    public ParamsLackException(){}

    public ParamsLackException(String msg) {
        super(msg);
    }
}
