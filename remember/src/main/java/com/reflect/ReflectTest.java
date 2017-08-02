package com.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class ReflectTest {

    public static void main(String[] args) throws ClassNotFoundException {
        
        /*这个是获取类的类型
        Code code1 = new Code();
        Class c1 = Code.class;//任何一个类都有一个隐含的静态成员变量
        System.out.println("c1:"+c1);//class com.reflect.Code
        Class c2 = code1.getClass();//通过对象获取类信息，这是一个native method，并且是Object类里面的
        System.out.println("c2:"+c2.getName());//com.reflect.Code
        Class c3 = Class.forName("com.reflect.Code");//调用Class类中的forName方法，根据类的全限定名获取类的信息
        System.out.println("c3:"+c3.getName());
        //c1,c2,c3都是Class的对象，他们都是Code的类的类型（class type）
         * 
        */
        
        /*这个是反射调用方法
        try {
            Class c = Class.forName("com.reflect.Person");
            Object o = c.newInstance();
            Method method = c.getMethod("fun", String.class,int.class);
            method.invoke(o, "你大爷",90);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        */
        
        /*
        try {
            Class c = Class.forName("com.reflect.Person");
            Method[] method = c.getDeclaredMethods();//得到该类所有的方法，不包括父类的
            for(Method m : method) {
                System.out.println(m.getName());
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        */
        
        /*
        try {
            Class c = Class.forName("com.reflect.Person");
            Method[] methods = c.getMethods();//得到该类和其父类中所有的public的方法
            for(Method m : methods){
                System.out.println(m.getName());
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        */
        
        /*
        try {
            Class c = Class.forName("com.reflect.Person");
            //此时c已经是Person类的类型了，所以再用c调取getDeclaredField就是获取Person类的实例域，实例域顾名思义，就是存放实例的区域，里面放的就是成员变量
            Field field = c.getDeclaredField("msg");//该方法是获取该类的成员变量信息，因为成员变量可能是私有的，所以只能使用getDeclaredField方法
            //如果使用Field f = c.getField("msg");//会报出NoSuchFieldException异常，说是没有这个成员变量，意思就是没有public的，只有private的
            Object o = c.newInstance();
            field.setAccessible(true);//如果是获取的private的field，那么必须用这个方法并设置成true，否则会报IllegalAccessException异常
            //该异常是安全权限异常，如果想访问私有的成员变量之前需要取得访问权限，，，，，该异常的翻译是“非法访问异常”field.get(Object)
            Object result = field.get(o);//拿到对象实例的 域成员的值
            System.out.println(result);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        */
        
        /*这个是获取所有成员变量的名字
        try {
            Class c = Class.forName("com.reflect.Person");
            Field[] fields = c.getDeclaredFields();
            for(Field f : fields) {
                System.out.println(f.getName());
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        */
        
        /*当前类的构造器
        try {
            Class c = Class.forName("com.reflect.Person");
            Constructor cons = c.getDeclaredConstructor(String.class);
            cons.setAccessible(true);//因为有私有构造器，所以要设置访问权限
            cons.newInstance("你好");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        */
        
        /*获取所有的构造器
        try {
            Class c = Class.forName("com.reflect.Person");
            Constructor[] cons = c.getDeclaredConstructors();
            for(Constructor cc : cons){
                System.out.println(cc);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        */
    }
}
