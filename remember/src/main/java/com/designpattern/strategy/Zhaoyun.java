package com.designpattern.strategy;

import com.designpattern.strategy.concretestrategy.BackDoor;
import com.designpattern.strategy.concretestrategy.BlackEnemy;
import com.designpattern.strategy.concretestrategy.GivenGreenLight;
import com.designpattern.strategy.context.Context;

/*
 * 场景如下，刘备要到江东娶老婆了，走之前诸葛亮给赵云三个锦囊妙计，说是按天机拆开能解决棘手问题。
 * 场景中出现三个要素：三个妙计（具体策略类）、一个锦囊（环境类）、赵云（调用者）。
 * 
 * 不是工厂模式么，怎么感觉接口那个地方那么像呢，哎，乱套了
 */
public class Zhaoyun {

    public static void main(String[] args) {
        Context context;
        
        System.out.println("刚到吴国使用第一个锦囊");
        context = new Context(new BackDoor());
        context.operate();
        System.out.println("\n");
        
        System.out.println("刘备乐不思蜀使用第二个锦囊");
        context = new Context(new GivenGreenLight());
        context.operate();
        System.out.println("\n");
        
        System.out.println("孙权的追兵来了，使用第三个锦囊");
        context = new Context(new BlackEnemy());
        context.operate();
        System.out.println("\n");
    }
}
