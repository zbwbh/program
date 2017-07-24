package com.designpattern.strategy.concretestrategy;

import com.designpattern.strategy.strategy.Strategy;

public class BlackEnemy implements Strategy{

    public void operate() {
        System.out.println("孙夫人断后，阻挡追兵");
    }

}
