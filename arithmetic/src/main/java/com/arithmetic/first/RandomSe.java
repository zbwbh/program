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
public class RandomSe {

    public static void main(String[] args) {
        int n = Integer.parseInt("5");
        double lo = Double.parseDouble("100.0");
        double hi = Double.parseDouble("200.0");
        for(int i = 0;i<n;i++){
            double x = StdRandom.uniform(lo,hi);
            StdOut.printf("%.2f\n",x);
        }
        StdOut.printf("PI is %.2f\n", Math.PI);
    }
}
