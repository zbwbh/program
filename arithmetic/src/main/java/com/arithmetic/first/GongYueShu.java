package com.arithmetic.first;

/**
 * 欧几里得算法，求最大公约数
 * 最大公约数概念，打比方的方式好记12,16他们同时可以被1,2,4整除，这些
 * 都是12和16的公约数，最大的那个就是4
 *
 * @author koala
 * @since 2017年7月18日
 */
public class GongYueShu {

    /**
     * 算法方法
     * 自然语言描述：计算两个非负整数p和q的最大公约数：若q是0，则最大公约数就是p
     * 否则，将p除以q得到余数r，p和q的最大公约数就是q和r的最大公约数
     * 
     * 因为采用了递归的方式，那么如果要跳出递归的唯一方法就是r=0，那么就会返回p，是一次次筛选之后得到的结果
     * @author koala
     * @since 2017年7月18日
     */
    public static int gcd(int p,int q){
        if(q==0)return p;
        int r = p % q;
        return gcd(q,r);
    }
    
    public static void main(String[] args) {
        int result = gcd(16,12);
        System.out.println(result);//4
    }
}
