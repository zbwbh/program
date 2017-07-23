package com.singleton;


/**
 * 单例模式关键点
 * 1、一个类只有一个实例，这个是最基本的
 * 2、它必须自行创建这个实例
 * 3、它必须自行向整个系统提供这个实例
 *
 * 懒汉模式，类加载时不初始化，运行时获取对象速度较慢
 * 当然懒汉模式和饿汉模式这两个类所给出只是示例版本，真正程序中是不会这么写的
 * @author koala
 * @since 2017年7月21日
 */
public class LazySingleton {

    private static LazySingleton singleton = null;//只声明了，未初始化，
    
    private LazySingleton(){
        //私有构造器，避免产生实例
    }
    
    //属不属于懒汉模式啊
    public static LazySingleton getInstance(){
        if(singleton==null){
            singleton = new LazySingleton();
        }
        return singleton;
    }
    
}
