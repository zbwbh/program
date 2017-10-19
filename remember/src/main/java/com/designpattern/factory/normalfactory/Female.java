package com.designpattern.factory.normalfactory;

/**
 * 女人实现类
 * 
 *
 * @author zbw
 * @since 2017年10月19日
 */
public class Female implements Human {

    @Override
    public void eat() {
        // TODO Auto-generated method stub
        System.out.println("Female can eat.");
    }

    @Override
    public void sleep() {
        // TODO Auto-generated method stub
        System.out.println("Female can sleep.");
    }

    @Override
    public void beat() {
        // TODO Auto-generated method stub
        System.out.println("Female can beat.");
    }

}
