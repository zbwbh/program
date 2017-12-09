package com.sourcecode;

/**
 * 方法：
 * public static int numberOfLeadingZeros(int i);
 * 
 *
 * @author zbw
 * @since 2017年11月17日
 */
public class NumberOfLeadingZeros {

    /**
     * 该函数的功能，在指定int值的二进制补码表示形式中最高位的 1 位之前，返回零位的数量。
     * 如果指定值在其二进制补码表示形式中不存在1位，换句话说，如果它等于零，返回32.
     * 
     * 该源码：应用了典型的二分查找，先把32位整型分为高16位和低16位查找非零数，
     * 再对高16位或低16位进行二分
     * 
     * 首先在JVM中一个int类型的数据占4个字节，共32位，其实就相当于一个长度为32的数组。
     * 那我们要计算首部0的个数，就是从左边第一个位开始累加0的个数，直到遇到一个非零值。
     * 
     * @param i
     * @return
     *
     * @author zbw
     * @since 2017年11月17日
     */
//    public static int numberOfLeadingZeros(int i) {
//        if (i == 0) return 32;
//        int n = 1;
//        
//        if (i >>> 16 == 0) {n += 16; i <<= 16;}
//        if (i >>> 24 == 0) {n +=  8; i <<=  8;}
//    }
}
