package com.singleton;

/**
 * 使用枚举类创建单例
 * 实际上在开始创建enum类的时候就会默认继承自java.lang.Enum类
 * 它也可以有构造器的，在文档中看到的Enum构造器程序员无法调用，并且是唯一的(在java.lang.Enum的构造器)
 * 
 * @author koala
 * @since 2017年7月21日
 */
public class EnumSingleton {

    public enum Mysingleton{
        INSTANCE;
        private EnumSingleton instance;
        
        Mysingleton(){
            instance = new EnumSingleton();
        }
        
        public EnumSingleton getInstance() {
            return instance;
        }
    }
}
