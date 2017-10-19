package com.designpattern.factory.abstractfactory;

/**
 * 抽象工厂模式应用
 * 抽象工厂模式特别适合于这样的一种产品结构：产品分为几个系列，在每个系列中，
 * 产品的布局都是类似的，在一个系列中某个位置的产品，在另一个系列中一定有一个对应的产品
 * 。这样的产品结构是存在的，这几个系列中同一位置的产品可能是互斥的，他们是针对
 * 不同客户的解决方案，每个客户都只能选择其一
 * 
 * 接下来谈重点：
 * 工厂方法模式、抽象工厂模式的区别
 * 
 * 先介绍两个概念：
 *   产品等级结构：比如一个抽象类是食物，其子类有苹果、牛奶等等，则抽象食物与
 * 具体食物名称之间构成了一个产品等级结构。食物是抽象的父类，而
 * 具体的食物名称是其子类。
 *   产品族：在抽象工厂模式中，产品是只由同一个工厂生产的，位于不同产品等级结构中的一组产品
 * 。如Akitchen生产的苹果、刀子，苹果属于食物产品等级结构中，而刀子则属于餐具产品等级结构中。
 * 而BKitchen可能生成另一组产品，如牛奶、杯子。
 * 因此工厂方法模式、抽象工厂模式最大的区别在于：
 * 工厂方法模式：针对的是一个产品等级结构。
 * 抽象工厂模式：针对多个产品等级结构
 *
 * @author zbw
 * @since 2017年10月19日
 */
public class Foodaholic {

    public void eat(KitchenFactory k) {
        System.out.println("A foodaholic is eating "+k.getFood().getFoodName()+" with "+
                k.getTableWare().getTableWareName());
    }
    
    public static void main(String[] args) {
        Foodaholic fh = new Foodaholic();
        KitchenFactory kf = new AKitchen();
        fh.eat(kf);
    }
}
