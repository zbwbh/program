package com.baseframe.util;

/**
 * 返回结果类，把可能的情况都列举出来
 * 用构造方法
 *
 * @author koala
 * @since 2017年9月12日
 */
public class ResultVO {

    private int code;

    private String msg;

    private Object data;

    public ResultVO(ResultType type, Object data) {
        this.code = type.getCode();
        this.msg = type.getMsg();
        this.data = data;
    }

    public ResultVO(ResultType type) {
        this.code = type.getCode();
        this.msg = type.getMsg();
    }

    public ResultVO(int code) {
        this.code = code;
    }

    public ResultVO(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultVO(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
