package com.designpattern.factory.abstractfactory;

//抽象工厂，产品族基本上都是抽象的，产品都通过实现类去实现
//我说什么来着，工厂也TM是抽象的，产品抽象工厂也抽象，都需要实现类
public interface KitchenFactory {

    public Food getFood();
    public TableWare getTableWare();
}
