package com.arithmetic.first;

import com.algs4.stdlib.StdOut;
import com.algs4.stdlib.StdRandom;
/**
 * 格式化输出
 * 
 *
 * @author koala
 * @since 2017年7月18日
 */
public class RandomSeq {

    public static void main(String[] args) {
        int n = Integer.parseInt("5");//循环次数
        double lo = Double.parseDouble("100.0");
        double hi = Double.parseDouble("200.0");
        for(int i = 0;i<n;i++){
            //起始double和结束double之间的数double
            //数字大小顺序颠倒会报参数错误，方法内部主动封装的异常
            double x = StdRandom.uniform(lo,hi);
            StdOut.printf("%.2f\n",x);//方法内部封装的格式化输出
        }
        StdOut.printf("PI is %.2f\n", Math.PI);
        //临时看见的，Java中&&的优先级高于||
        System.out.println(true&&false||true&&true);//true
    }
}
