package com.maintest;

import java.util.Comparator;
import java.util.concurrent.CompletableFuture;

/**
 * 
 * 因为在项目中用到了，也看到了lambda表达式挺有意思，想看看，
 * 实际上这些我是很懵懂的，也就是在Python当中见过一星半点，现在也不是很懂
 * 目前来看lambda表达式给我的感觉就是简化匿名内部类的
 *
 * @author koala
 * @since 2017年9月19日
 */
public class LambdaC {

    public static void main(String[] args) {
        //java.lang
//        Runnable r = ()->System.out.println("Hello World!");
//        r.run();
        //java.util.Comparator
        /*
         * 
        Comparator<Integer> cmp = (x,y)->(x<y)?-1:((x>y)?1:0);
        int a = cmp.compare(2, 6);//-1，如果是6,2 结果是1，问题出在三木运算符上，这里主要是以为了阐述简化匿名内部类
        System.out.println(a);
        Comparator<Integer> cmp1 = (x,y) ->{
          return (x<y)?-1:((x>y)?1:0);  
        };
        int a1 = cmp1.compare(6, 2);//1
        System.out.println(a1);
        Comparator<Integer> cmp2 = new Comparator<Integer>() {

            @Override
            public int compare(Integer x, Integer y) {
                return (x<y)?-1:((x>y)?1:0);
            }
            
        };
        int a2 = cmp2.compare(6, 2);
        System.out.println(a2);
        */
        //上面三个的共同部分正是比较逻辑，其余部分不同
        
        
        //Action接口的定义
//        public interface Action {
//            void run(String param);
//        }
        
        //有没有发现这个Action接口和异步编程那个java.util.function包里面的new Supplier接口有些相似
        //CompletableFuture.supplyAsync(new Supplier...)实现的方法和该execute方法很类似
        execute(new Action(){
            @Override
            public void run(String param) {
                System.out.println(param+"1");
            }
        });
        
        //lambda表达式在运行期表示一个函数式接口，它传递的参数实际上是一个函数(接口内有方法)
        
        //声明参数类型的lambda表达式，实际上是可以不用声明的
        execute((String param)->System.out.println(param+"2"));
        //这个就没有声明
        execute(param->System.out.println(param+"3"));
        
        //从上面的三个演变过程可以看出来，实际上匿名内部类被lambda表达式简化了，目前我能看到的深度就只有这些，
        //因为实际编程经验太少，在实际项目中根本就没写过匿名内部类这样的代码，所以什么看视频学习，自学什么的，顶多就是个入门基础
        //真正还要到实际项目中总结
    }
    
    //实现接口的方法
    public static void execute(Action action){
        action.run("Hello World!");
    }
    
    /**
     * lambda表达式在运行期表示为一个函数接口，函数接口是一种只定义了一个抽象方法的接口
     * jdk8新增了一个包java.util.funciton，这个包里有一些专门给新增的API使用的函数接口
     */
}
