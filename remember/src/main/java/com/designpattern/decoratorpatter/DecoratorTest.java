package com.designpattern.decoratorpatter;

/**
 * 因为有两个扩展类，所以我将解释写在测试当中吧，也可能对于理解更方便一点
 * 装饰者模式（Decorator Pattern）就是动态地把职责附加到已有对象上去，实现扩展功能
 * ，这种特性，使得装饰者模式提供了比继承更具有弹性的解决方案
 * 
 * 当你需要动态的给一个对象添加功能，实现功能扩展的时候，就可以使用装饰者模式。
 * Java IO类中有一个经典的装饰者模式应用，BufferedReader装饰了InputStreamReader
 * 
 * 从main方法当中的代码也可以看出这一点，实际上是新对象当中的新功能装饰了新对象构造器当中原始抽象类当中的原始功能
 * 所以这里会说是BufferedReader装饰了InputStreamReader
 * 
 * BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
 * * InputStreamReader(InputStream in)-InputStreamReader读取bytes字节内容，然后转换成characters输出
 * BufferedReader(Reader in)-从characters流中读取内容并缓存
 * 
 * 
 * 装饰者模式、适配器模式区别
 * 1、关于新职责：适配器也可以在转换时增加新的职责，但其主要目的并不在此；
 * 而装饰者模式主要目的，就是给被装饰者增加新职责用的。
 * 2、关于原接口：适配器模式是用新接口来调用原接口，原接口对新系统来说是不可见或者
 * 说不可用的，而装饰者模式原封不动的使用原接口，系统对装饰的对象也通过原接口
 * 来完成使用。
 * 3、关于其包裹的对象：适配器是知道被适配者的详细情况的（就是那个类或那个接口）；
 * 而装饰者只知道接口是什么，至于其具体类型（是基类还是其他派生类）只有运行期间才知道
 *
 * @author zbw
 * @since 2017年10月20日
 */
public class DecoratorTest {

    public static void main(String[] args) {
        Girl g1 = new AmericanGirl();
        System.out.println(g1.getDescription());
        //DecoratorGirl是GoldenHair的抽象类
        DecoratorGirl g2 = new GoldenHair(g1);
        System.out.println(g2.getDescription());
        DecoratorGirl g3 = new Tall(g2);
        System.out.println(g3.getDescription());
        
        /**
         * 原图片是这样写的，不过感觉还是多态好点吧，也可能使用下面的方式更加明确
         *  GoldenHair g2 = new GoldenHair(g1);
            System.out.println(g2.getDescription());

            Tall g3 = new Tall(g2);
            System.out.println(g3.getDescription());
         */
    }
}
