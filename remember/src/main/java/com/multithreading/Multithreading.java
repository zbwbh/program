package com.multithreading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

/**
 * 多线程这里应该是记录过了，但是是在项目中的内容。
 * 并没有一个好的记忆方式。
 * 并且这只是其中一种简单的方式
 * @author zbw
 * @since 2018年2月23日
 */
public class Multithreading {

    /**
     * 可直接运行
     * 
     * @param args
     *
     * @author zbw
     * @since 2018年2月23日
     */
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        CompletableFuture<String> future = CompletableFuture.supplyAsync(new Supplier<String>() {

            @Override
            public String get() {
                System.out.println("Thread1:" + Thread.currentThread());
                System.out.println("任务开始..." + System.currentTimeMillis());
                try {
                    Thread.sleep(5000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "任务结束..." + System.currentTimeMillis();
            }
            
        }, executor);
        
        /*****************************************/
        //被注释包围的代码和内部代码的任务开始的执行时间是一致的
        System.out.println("Thread外：" + Thread.currentThread());
        System.out.println("外面时间：" + System.currentTimeMillis());
        /****************************************/
        
        future.thenAccept(e -> System.out.println(e + "ok"));
    }
}
