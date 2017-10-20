package com.designpattern.singleton;

/**
 * 这种检验方式问题在于wife= new Wife()这句代码
 * 因为在JVM执行这句代码的时候，要做好几件事情，而JVM为了优化代码
 * 有可能造成做这几件事情的执行顺序是不固定的，从而造成错误。
 * 
 * 这时候需要给实例加上一个volatile关键字，它的作用就是防止编译器自行
 * 优化代码。
 * 
 *
 * @author zbw
 * @since 2017年10月20日
 */
public class DoubleCheck {

    private static Wife wife;
    
    public DoubleCheck() {
        
    }
    //有机会看一下synchronized部分的内容
    public static Wife getWife() {
        //第一个检验锁，如果不为空直接返回实例对象，为空才进入下一步
        if (wife == null) {
           synchronized (Wife.class) {
               //第二个检验锁，因为可能有多个线程进入到if语句内
               if (wife == null) {
                   wife = new Wife();
               }
           }
        }
        return wife;
    }
}
