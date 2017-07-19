package com.arithmetic.first;

import com.algs4.stdlib.StdDraw;
import com.algs4.stdlib.StdRandom;

/**
 * 随机数组图像
 * 这是图像，实际上并不影响结果，只是观察起来更直观
 * 真正使用的就是数组的每个元素赋上随机值
 *
 * @author koala
 * @since 2017年7月19日
 */
public class RandomArray {

    public static void main(String[] args) {
        int n = 50;
        double[] a = new double[n];
        for (int i = 0; i < n; i++)
            a[i] = StdRandom.random();
        for (int i = 0; i < n; i++) {
            double x = 1.0 * i / n;
            double y = a[i] / 2.0;
            double rw = 0.5 / n;
            double rh = a[i] / 2.0;
            StdDraw.filledRectangle(x, y, rw, rh);
        }
    }
}
