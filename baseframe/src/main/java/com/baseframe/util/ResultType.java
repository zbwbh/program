package com.baseframe.util;

/**
 * 枚举类，貌似是要写出私有构造方法才可以啊
 * 2017-9-12 19:06:00
 * 写上面那句话的时候突然间想起来在remember里面写过，于是去看了一下，然后大概就了解了
 * 枚举类属于单例模式，构造器必须私有化，构造器确定了，那么枚举属性的值就确定了
 *
 * @author koala
 * @since 2017年9月12日
 */
public enum ResultType {

                        NO_DATA(0, "没有数据"),
                        
                        NULL_OBJ(1,"参数不全或为空"),
                        
                        SUCCESS(200,"操作成功"),
                        
                        FAIL(201,"操作失败");
 
    private int code;

    private String msg;

    private ResultType(int code, String msg) {
        this.code = code;
        this.msg = msg;
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

}
