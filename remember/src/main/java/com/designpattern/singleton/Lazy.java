package com.designpattern.singleton;

/**
 * 没有加异步锁关键字的懒汉模式会存在问题，
 * 如果多个线程并行调用getWife()方法的时候，
 * 还是不能保证只创建一个实例，单例模式就失效了
 * 
 *
 * @author zbw
 * @since 2017年10月20日
 */
public class Lazy {

    private static Wife wife;
    
    private Lazy() {
        
    }
    //最开始没有加异步锁
    public static synchronized Wife getWife() {
        if (wife == null) {
            return new Wife();
        }
        return wife;
    }
    
}
