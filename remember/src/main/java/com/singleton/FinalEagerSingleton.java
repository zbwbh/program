package com.singleton;

/**
 * 饿汉模式最终版本
 * 该版是effective java以前版本推荐使用的
 * 首先CreateSingleton类时私有的，所以外部无法访问
 * 还有另外一种是使用枚举类调用，但是枚举类本身不太熟悉，暂时先放一下
 * @author koala
 * @since 2017年7月21日
 */
public class FinalEagerSingleton {

    private static class CreateSingleton{
        private static FinalEagerSingleton INSTANCE = new FinalEagerSingleton();
    }
    
    private FinalEagerSingleton(){
        
    }
    
    public static FinalEagerSingleton getInstance(){
        return CreateSingleton.INSTANCE;
    }
}
