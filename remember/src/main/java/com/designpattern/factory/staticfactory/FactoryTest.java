package com.designpattern.factory.staticfactory;

import com.designpattern.factory.normalfactory.Human;

public class FactoryTest {

    /**
     * 凡是出现了大量的产品需要创建，并且具有共同的接口时，可以通过工厂方法模式
     * 进行创建。在普通工厂模式、多个工厂方法、静态工厂方法模式这三种模式中，第一种
     * 如果传入的字符串有误，不能正确的创建对象，第三种相对于第二种，不需要实例化工厂类
     * ，所以绝大多数情况下，我们会选用第三种--静态工厂方法模式，
     * 貌似在spring中也有这个方法，就是bean，因为你看他们传入的class都是固定的
     * 
     * @param args
     *
     * @author zbw
     * @since 2017年10月19日
     */
    public static void main(String[] args) {
        Human male = HumanFacotry.createMale();
        male.beat();
        male.eat();
        male.sleep();
    }
}
