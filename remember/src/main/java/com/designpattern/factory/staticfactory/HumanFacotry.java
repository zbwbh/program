package com.designpattern.factory.staticfactory;

import com.designpattern.factory.normalfactory.Female;
import com.designpattern.factory.normalfactory.Male;

/**
 * 在多工厂方法的前提下，将创建对象的方式改为静态，省去了创建工厂对象的麻烦
 * 
 *
 * @author zbw
 * @since 2017年10月19日
 */
public class HumanFacotry {

    public static Male createMale() {
        return new Male();
    }
    
    public static Female createFemale() {
        return new Female();
    }
}
