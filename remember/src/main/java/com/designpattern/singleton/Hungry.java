package com.designpattern.singleton;

//饿汉模式
public class Hungry {

    //一开始就新建一个实例
    private static final Wife wife = new Wife();
    
    private Hungry() {
        
    }
    
    //获得实例的方法
    public static Wife getWife() {
        return wife;
    }
}
