package com.arithmetic.first;

import com.algs4.stdlib.StdDraw;

/**
 * 刚开始只是一个测试，
 * 有三条线性函数，最明显的是第一条，(i,i)那条是从下到上逐渐增长的
 *
 * @author koala
 * @since 2017年7月19日
 */
public class StdDrawFirst {

    public static void main(String[] args) {
        int n = 100;
        StdDraw.setXscale(0, n);
        StdDraw.setYscale(0, n * n);
        StdDraw.setPenRadius(.01);
        for (int i = 1; i <= n; i++) {
            StdDraw.point(i, i);
            StdDraw.point(i, i * i);
            StdDraw.point(i, i * Math.log(i));
        }
    }
}
