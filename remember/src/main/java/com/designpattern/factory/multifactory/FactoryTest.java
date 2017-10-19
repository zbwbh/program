package com.designpattern.factory.multifactory;

import com.designpattern.factory.normalfactory.Human;

public class FactoryTest {

    public static void main(String[] args) {
        HumanFactory factory = new HumanFactory();
        Human male = factory.createMale();
        male.beat();
        male.eat();
        male.sleep();
    }
}
