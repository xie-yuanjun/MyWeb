package com.demo.utils;

/**
 * @author admin
 * @Title: status
 * @ProjectName word
 * @Description: 操作状态枚举类
 * @date 2021/5/1914:14
 */
public enum StatusEnum {
    SUCCESS("1001"), FAILED("1002"), ERROR("1003");

    //状态码
    private String code;

    private StatusEnum(String statuscode){
        this.code = statuscode;
    }

    public String getCode(){
        return code;
    }

}
