package com.designpattern.factory.normalfactory;

/**
 * 普通工厂类，用于生产人类
 * 普通工厂类应该是有那么个标致的，就是ifelse来区分不同产品的
 *
 * @author zbw
 * @since 2017年10月19日
 */
public class HumanFactory {

    public Human createHuman(String gender) {
        if ("male".equals(gender)) {
            return new Male();
        }else if ("Female".equals(gender)) {
            return new Female();
        }else {
            System.out.println("请输入正确的类型!");
            return null;
        }
    }
}
