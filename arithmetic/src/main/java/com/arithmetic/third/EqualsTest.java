package com.arithmetic.third;

/**
 * 
 * 要明白他们==和equals的区别首先要知道他俩分别比较的是什么。
 * 
 *
 * @author koala
 * @since 2017年7月28日
 */
public class EqualsTest {

    public static void main(String[] args) {
        //先说==，当比较的两边是8种基本数据类型时，==比较的就是变量里的值。
        int i = 1;
        int j = 1;
        System.out.println(i==j);//true
        //当==比较的是对象的时候，比较的并不是变量里的值，而是比较对象在内存中的地址了
        String str = new String("hello");
        String str1 = new String("hello");
        System.out.println(str==str1);//false,因为两个变量在内存中的地址不一样啊
        
        //然后是equals，这个稍微复杂一点。首先equals方法是所有类的父类Object类里的方法，当子类没有重写equals方法时
        //调用的是Object类里的equals方法，Object里的equals方法只是简单的比较了一下两个变量的地址。
        //String类就重写了Object类的equals方法，所以当调用String类的equals方法比较时就是字符串是否相等了
        System.out.println(str.equals(str1));//true,因为两个变量里的字符串都是hello
        
        /**
         * 那么重点来了，这记忆就方便多了，哈哈
         * equals是方法，所以方法内部允许空值，有相应的处理方法，所以一般都是   常量.equals(变量);
         */
        
        //再看下面一段方法
        String str2 = null;
        if(str2 instanceof String) {
            System.out.println("属于String类型");
        }else{
            System.out.println("不属于String类型");
        }
        
        //执行结果为不属于String类型，也就是说跟初始声明的变量类型无关，而是跟变量的具体值有关
        //null肯定不是String类型的
        
        //接下来看一下String类重写的equals方法，先不管编译错误，因为是从String类里拷贝过来的
        //一些常量没法声明
//        public boolean equals(Object anObject) {
//            if (this == anObject) {
//                return true;
//            }
//            if (anObject instanceof String) {//主要看这里，如果是null肯定不走下面，直接return false，这是做了相应的处理的
//                String anotherString = (String)anObject;
//                int n = value.length;
//                if (n == anotherString.value.length) {
//                    char v1[] = value;
//                    char v2[] = anotherString.value;
//                    int i = 0;
//                    while (n-- != 0) {
//                        if (v1[i] != v2[i])
//                            return false;
//                        i++;
//                    }
//                    return true;
//                }
//            }
//            return false;
//        }
    }
}
