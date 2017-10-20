package com.designpattern.singleton;

/**
 * 
 * 因为volatile关键字在某些老版本的JDK中无法正常工作，
 * 
 * 静态内部类这种方式，利用了JVM自身的机制来保证线程安全
 * 因为WifeHolder是私有的，除了getWife()之外没有其他方式可以访问对象，而且
 * 只有在调用getWife()时才会去真正创建实例的对象。
 *
 * @author zbw
 * @since 2017年10月20日
 */
public class StaticInerClass {

    private static class WifeHolder{
        private static final Wife wife = new Wife();
    }
    
    public static Wife getWife() {
        return WifeHolder.wife;
    }
}
