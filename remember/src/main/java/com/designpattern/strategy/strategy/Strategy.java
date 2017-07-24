package com.designpattern.strategy.strategy;

//抽象策略类，什么抽象策略类，这不就是一个公共接口么，把策略/功能统一一套规范，所有功能类都需要实现该接口，
//然后该接口归环境类管，环境类利用该接口调用相应的实现类中的策略

public interface Strategy {
    public void operate();
}
