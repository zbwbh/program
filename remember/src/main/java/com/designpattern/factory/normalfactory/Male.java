package com.designpattern.factory.normalfactory;

/**
 * 男人实现类
 * 
 *
 * @author zbw
 * @since 2017年10月19日
 */
public class Male implements Human {

    @Override
    public void eat() {
        // TODO Auto-generated method stub
        System.out.println("male can eat.");
    }

    @Override
    public void sleep() {
        // TODO Auto-generated method stub
        System.out.println("male can sleep.");
    }

    @Override
    public void beat() {
        // TODO Auto-generated method stub
        System.out.println("male can beat.");
    }

}
