package com.reflect.another;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 
 * 通常来讲，一般框架的开发使用反射的次数比较多，
 * 因为很多东西是不确定的，需要在加载中运行
 *
 * @author zbw
 * @since 2018年2月24日
 */
public class ReflectTest {

    public static void main(String[] args) {
        try {
            /**
             * 获取类
             */
            // 第一种方式：
            Class c1 = Class.forName("com.reflect.another.Employee");
            // 第二种方式：Java中每个类型都有class属性
            Class c2 = Employee.class;
            // 第三种方式：Java语言中任何一个Java对象都有getClass()方法
            Employee e = new Employee();
            Class c3 = e.getClass();
//            System.out.println(c1 == c2);
//            System.out.println(c2 == c3);
//            System.out.println(c1 == c3);
            
            /**
             * 创建对象：获取类之后用newInstance
             */
            Class c = Class.forName("com.reflect.another.Employee");
            // 创建此Class 对象所表示的类的一个新实例
            Object o = c.newInstance();
//            System.out.println(c);
//            System.out.println(o);
            /**
             * 获取属性：分为所有的属性和指定的属性
             * 
             */
            //a.获取所有属性的写法
            // 获取整个类
            Class ci = Class.forName("java.lang.Integer");
            // 详见API
            Field [] fs = ci.getDeclaredFields();
            
            //定义可变长字符串，用来存储属性
            StringBuilder sb = new StringBuilder();
            
            //直到拼接结束都直接看API吧，应该是能看懂的
            sb.append(Modifier.toString(ci.getModifiers()) + " class " + ci.getSimpleName() + "{\n");
            
            for (Field field : fs) {
                sb.append("\t");//制表符
                sb.append(Modifier.toString(field.getModifiers()) + " ");
                sb.append(field.getType().getSimpleName() + " ");
                sb.append(field.getName() + ";\n");
            }
            sb.append("}");
//            System.out.println(sb);
            
            
            // b.获取特定的属性，对比着传统的方法来学习
            // 这里使用上面已经获取的类c1,
            Field idf = c1.getDeclaredField("name");
            Object o1 = c1.newInstance();//实例化
            
            idf.setAccessible(true);//打破封装，这种操作不安全，可以访问私有属性
            idf.set(o1, "Jack");
            
            System.out.println(idf.get(o1));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    /**
     * String：适用于少量的字符串操作的情况

　　      StringBuilder：适用于单线程下在字符缓冲区进行大量操作的情况（有synchronize关键字）

　　      StringBuffer：适用多线程下在字符缓冲区进行大量操作的情况（没有关键字，速度快）
     */
    
    
}
