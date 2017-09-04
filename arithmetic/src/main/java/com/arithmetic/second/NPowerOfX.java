package com.arithmetic.second;

/**
 * x的n次幂
 * 
 *
 * @author koala
 * @since 2017年8月31日
 */
public class NPowerOfX {

    public static long calculatePower(long x, int n){
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n % 2 == 0) {
            return calculatePower(x * x, n/2);//每次相乘在此基础上叠加，比如
            //开始是x*x,接下来就是(x*x)*(x*x),依次往上涨
        }else{
            return calculatePower(x * x, n/2) * x;//如果是奇数那么最后腾出来一个数跟之前叠加的次数相乘
        }
    }
    
    public static void main(String[] args) {
        long result = calculatePower(5, 2);
        System.out.println(result);
    }
}
