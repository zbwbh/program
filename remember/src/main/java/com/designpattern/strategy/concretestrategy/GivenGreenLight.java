package com.designpattern.strategy.concretestrategy;

import com.designpattern.strategy.strategy.Strategy;

//妙计二
public class GivenGreenLight implements Strategy{

    public void operate() {
        System.out.println("求吴国太开个绿灯，放行");
    }
    
}
