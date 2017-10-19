package com.designpattern.factory.normalfactory;

public class FactoryTest {

    public static void main(String[] args) {
        HumanFactory factory = new HumanFactory();//首先要创建工厂对象，因为是根据工厂创建的产品
        Human male = factory.createHuman("male");//这里使用Human接口因为多态可以更好的管理对象，因为你不知道要创建的是什么产品
        male.beat();
        male.eat();
        male.sleep();
    }
}
