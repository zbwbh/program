package com.hashmap;

import java.util.HashMap;

public class TestClass {

    public static void main(String[] args) {
        Person p1 = new Person("jack", 12);
        System.out.println(p1.hashCode());
        
        HashMap<Person,Integer> hashMap = new HashMap<Person,Integer>();
        hashMap.put(p1, 1);
        
        //在没有重写hashCode方法之前，下面的输出是null，因为上面的new对象和下面的new对象虽然equals
        //判定为相等的对象，但是，默认情况下，hashCode方法是将对象的存储地址进行映射，所以
        //这两个new对象是生成了两个对象，存储地址不同，所以会是null
        
        //如果想让输出结果为1，只需要重写hashCode方法，让equals方法和hashCode方法始终
        //在逻辑上保持一致性
        System.out.println(hashMap.get(new Person("jack", 12)));
        
        /**
         * 以下内容来自effective java
         * 1、在程序执行期间，只要equals方法的比较操作用到的信息没有被修改，那么对
         * 这同一个对象调用多次，hashCode方法必须始终如一地返回同一个整数
         * 2、如果两个对象根据equals方法比较是相等的，那么调用两个对象的hashCode方法必须返回相同的整数
         * 3、如果两个对象根据equals方法比较是不等的，则hashCode方法不一定得返回不同的整数
         * 
         * 对于第一条，在java编程思想里也有一段类似的话：
         * 设计hashCode()时最重要的因素就是：无论何时，对同一个对象调用hashCode()都应该产生同样
         * 的值。如果在将一个对象用put()添加进HashMap时产生一个hashCode值，而用get()取出时却产生了
         * 另一个hashCode值，那么就无法获取该对象了。所以如果你的hashCode方法依赖于对象中
         * 易变的数据，用户就要当心了，因为此数据发生变化时，hashCode方法就会生成一个不同的散列码 
         * 请看下面的例子：
         */
        
        Person p2 = new Person("lucy", 13);
        System.out.println(p2.hashCode());
            
        hashMap.put(p2, 2);
        p2.setAge(15);//重写的hashCode方法包含age变量，所以这里修改之后，hashCode算法得到的值发生了变化
        
        System.out.println(hashMap.get(p2));
        
        /**
         * 在理解hashcode数据结构的时候，要分离对象和存储结构，理解好他们之间的关系
         * 
         * 我的浅显理解，因为没有写过用到hashcode的代码：
         * 因为hashcode是计算对象地址值的方法，而hashmap是存储对象的数据结构，实际上集合是存储的引用而非实际对象
         * 所以通过查找对象地址找到对象就会用到hashcode，而equals是比较对象是否相等，通过equals和hashcode同时
         * 确定对象是否唯一，而hashcode仅仅通过关键字就能快速定位需要的元素，避免了equals全部对比的低效率查找
         */
    }
}
