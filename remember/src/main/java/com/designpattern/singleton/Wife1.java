package com.designpattern.singleton;

/**
 * 我们可以通过Wife.INSTANCE来访问实例对象，这比getWife()要简单的多
 * 而且创建枚举默认就是线程安全的，还可以防止反序列化带来的问题。
 *
 * 
 *
 * @author zbw
 * @since 2017年10月20日
 */
public enum Wife1 {

    INSTANCE;
    
    //自定义其他任意方法
    public void whateverMethod() {
        
    }
}
