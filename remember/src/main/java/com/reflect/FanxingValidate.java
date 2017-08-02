package com.reflect;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 *
 * @author koala
 * @since 2017年8月1日
 */
public class FanxingValidate {

    public static void main(String[] args) {
        List list1 = new ArrayList();
        List<String> list2 = new ArrayList<String>();
        list2.add("hello");
        //list2.add(10);//编译报错
        System.out.println("list2的长度是："+list2.size());
        
        /**
         * 通过反射添加元素方式，在运行期动态加载类，首先得到list1和list2的类类型相同，
         * 然后通过方法反射绕过编译器来调用add方法，看能否插入int型的元素
         */
        Class c1 = list1.getClass();
        Class c2 = list2.getClass();
        System.out.println(c1==c2);//true,说明类型相同
        //验证：我们可以通过方法的反射来给list2添加元素，这样可以绕过编译检查
        try {
            Method m = c2.getMethod("add", Object.class);
            m.invoke(list2, 20);
            //m.invoke(obj, args)从形参上可以看出来，第一个参数是调用方法的对象，第二个参数是调用的方法需要的形参
            System.out.println("list2的长度是："+list2.size());//说明泛型没有生效
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
