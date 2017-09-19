package com.maintest;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

/**
 * 异步操作测试代码
 * 
 *
 * @author koala
 * @since 2017年9月19日
 */
public class Asynchronous {

    public static void main(String[] args) {
        //来自java.util.concurent包
        //刚开始是copy的过程，然后学习的过程呢就该有思考了，这段API相当陌生了
        //起始的时候有Executor，Executors等等很多选择，这时候想到了多态编程
        //于是首先打出单词Executor+万能键，找到接口，其中ExecutorService就是该包下的接口
        //Executor也是接口，这段我没有明白，原因是英文没有读懂，所以英文也是很重要的一环，
        //(Executor接口注释写明了使用的是Runnable，ExecutorService接口也写明了，使用的是Future，这回可以了吧)
        //而类Executor稍微能读懂点，意思是说作用于ExecutorService等等。。。
        ExecutorService executor = Executors.newFixedThreadPool(1);//原来写的2，发现内部只需要一个线程就可以了
        // future在1.8之前是不能实现异步获取结果的，也就是说需要线程阻塞，意思就是说必须阻塞线程一之后才能获得线程二的结果，这句话不准确
        // 看下面代码
        CompletableFuture<String> future = CompletableFuture.supplyAsync(new Supplier<String>() {
            //这里说一下，在自身技术不成熟的时候，很多时候都是根据代码提示完成的编程，这里supply的中文意思是提供，Async的意思是异步
            //那么该方法的意思自然就是提供异步的意思了，然后有意思的是该方法有两个重载的方法，一个是只有一个接口Supplier的，另一个额外多了一个
            // executor，既然我要实现异步，当然需要线程池，所以选择两个参数的那个方法,另外，这Supplier属于java.util.function包，
            //这也是1.8新加的一个包，通用函数接口
            @Override
            public String get() {
                System.out.println("内部线程开始任务");
                try {
                    Thread.sleep(3000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "内部任务结束了";
                /**
                 * 内部线程和main方法当中的线程是同时开始的，我在实际项目中遇到的情况是，因为插入数据库的操作比较耗时，
                 * 所以打算先返回页面一个结果，与此同时将数据插入数据库，互不影响，才会采用这个方法，也就是说，内部线程很适合
                 * 做一些增删改操作，但是查询的话好像有阻塞，是这个意思
                 */
            }
        }, executor);
        future.thenAccept(param->System.out.println(param + ",完成了!"));
        System.out.println("main方法当中的线程开始");
        
        
    }
}
