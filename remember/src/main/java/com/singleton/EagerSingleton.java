package com.singleton;

/**
 * 饿汉模式，类加载时直接初始化
 * 
 *
 * @author koala
 * @since 2017年7月21日
 */
public class EagerSingleton {

    //饿汉式，声明之后直接初始化，不过是私有静态实例，在该类中只创建了一个
    private static EagerSingleton singleton = new EagerSingleton();
    
    private EagerSingleton(){
        //私有构造器，避免实例化
    }
    
    public static EagerSingleton getInstance() {
        return singleton;
    }
}
