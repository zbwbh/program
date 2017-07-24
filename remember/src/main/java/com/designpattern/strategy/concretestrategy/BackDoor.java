package com.designpattern.strategy.concretestrategy;

import com.designpattern.strategy.strategy.Strategy;

//妙计一
public class BackDoor implements Strategy{

    public void operate() {
      System.out.println("找乔国老帮忙，让吴国太给孙权施加压力，使孙权不能杀刘备");  
    }

}
