package com.arithmetic.first;

/**
 * 一些最基本的简单算法
 * 
 *
 * @author koala
 * @since 2017年7月18日
 */
public class BaseArithmetic {

    /**
     * 计算一个整数的绝对值
     *
     * @author koala
     * @since 2017年7月18日
     */
    public static int abs(int x) {
        if (x < 0)
            return -x;
        else
            return x;
    }

    /**
     * 计算一个浮点数的绝对值
     *
     * @author koala
     * @since 2017年7月18日
     */
    public static double abs(double x) {
        if (x < 0)
            return -x;
        else
            return x;
    }

    /**
     * 判断一个数是不是素数，素数概念，大于1的自然数
     * 感觉这个方法有点不对了啊
     * 
     * @author koala
     * @since 2017年7月18日
     */
    public static boolean isPrime(int N) {
        if (N < 2)
            return false;// 首先如果小于2肯定不是素数了
        for (int i = 2; i * i <= N; i++)
            if (N % i == 0)
                return false;
        return true;
    }

    /**
     * 计算直角三角形的斜边
     * Math本身是final类，无法被继承，里面的方法还都是本地方法
     * 
     * @author koala
     * @since 2017年7月18日
     */
    public static double xiebian(double a, double b) {
        return Math.sqrt(a * a + b * b);
    }

    public static void main(String[] args) {

    }
}
