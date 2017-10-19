package com.designpattern.factory.multifactory;

import com.designpattern.factory.normalfactory.Female;
import com.designpattern.factory.normalfactory.Male;

/**
 * 这里使用normalfactory包里面的基础接口和类了
 * 主要是看出来工厂类里面的区别
 * 多工厂方法环境下生成产品
 * @author zbw
 * @since 2017年10月19日
 */
public class HumanFactory {

    public Male createMale() {
        return new Male();
    }
    
    public Female createFemale() {
        return new Female();
    }
}
