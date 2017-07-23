package com.javacexersize;

/**
 * 猫，包含了猫相关的行为动作...
 * 
 * @see 详见百度
 * @author koala
 * @since 2017年7月23日
 */
public class Cat implements IWalkable {

    //它会显示接口中的注释
    public void walk(){
        System.out.println("走猫步");
    }
}
