package com.arithmetic.first;

import java.util.Arrays;

import com.algs4.stdlib.StdIn;
import com.algs4.stdlib.StdOut;

/**
 * 执行之后才明白，这是一个过滤黑名单的程序，
 * 不是数组的元素会出现在控制台输出
 * 二分查找法
 *
 * @author koala
 * @since 2017年7月19日
 */
public class BinarySearchDemo {

    public static int rank(int key, int[] a) {
        //数组必须是有序的，可以采用API中的sort进行排序
        int lo = 0;
        int hi = a.length-1;
        while (lo<=hi) {
            //被查找的键要么不存在，要么必然存在于他们之间
            int mid = lo + (hi-lo)/2;
            if      (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else                   return mid;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] whitelist = {3,1,5,6,9,7,8};
        Arrays.sort(whitelist);
        while(!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if(rank(key,whitelist)<0){
                StdOut.println(key);
            }
        }
    }
}
