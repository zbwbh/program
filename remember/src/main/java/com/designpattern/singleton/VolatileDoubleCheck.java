package com.designpattern.singleton;


public class VolatileDoubleCheck {

    //volatile这个单词比较特殊，它涉及到了jvm底层的一些的东西
    //再说
    private volatile static Wife wife;
    
    public VolatileDoubleCheck() {
        // TODO Auto-generated constructor stub
    }
    
    public static Wife getWife() {
        if (wife == null) {
            synchronized (Wife.class) {
                if (wife == null) {
                    wife = new Wife();
                }
            }
        }
        return wife;
    }
}
