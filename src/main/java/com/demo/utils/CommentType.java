package com.demo.utils;

/**
 * @author admin
 * @Title: CommentType
 * @ProjectName word
 * @Description: TODO
 * @date 2021/6/418:21
 */
public enum CommentType {
    WORD(1,"word"), OTHER(2, "其他");

    private int dvalue;
    private String value;
    private CommentType(int dvalue, String value){
        this.dvalue = dvalue;
        this.value = value;
    };

    public int getDvalue() {
        return dvalue;
    }

    public void setDvalue(int dvalue) {
        this.dvalue = dvalue;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
