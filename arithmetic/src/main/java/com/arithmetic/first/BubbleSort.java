package com.arithmetic.first;

import java.util.Arrays;

/**
 * 冒泡排序基本思路
 * 
 *
 * @author koala
 * @since 2017年7月19日
 */
public class BubbleSort {

    /*
     * 冒泡排序是只能是相邻的两个数之间进行比较，不能一个数与N个数逐一比较
     */
    public static void main(String[] args) {
        // 随机生成一个整数数组
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (1 + Math.random() * 100);// Math.random()是介于0~1之间的小数
        }
        System.out.println(Arrays.toString(arr));// java.util工具类API
        // 为了加深理解，首先只进行一次比较，将数组中的最小值放在最末尾
        System.out.println("开始移动");
        int temp;// 中间变量
        // 如果要测试单次移动，请将下方整体排序代码注释，将上面两个分段移动取消注释
        // for(int j=0; j<arr.length-1;j++){
        // if(arr[j]<arr[j+1]){
        // temp=arr[j];
        // arr[j]=arr[j+1];
        // arr[j+1]=temp;
        // }
        // }
        // System.out.println("结束移动");
        // 之后会发现数组中最小的元素被移动到了最后一位，期间每个数之间都进行了比较
        // System.out.println(Arrays.toString(arr));
        // System.out.println("开始移动1");
        // for(int j = 0;j<arr.length-1-1;j++) {
        // if(arr[j]<arr[j+1]){
        // temp = arr[j];
        // arr[j] = arr[j+1];
        // arr[j+1]=temp;
        // }
        // }
        // System.out.println("结束移动1");
        // System.out.println(Arrays.toString(arr));
        /*
         * 针对上述移动做了一个测试，发现冒泡排序的真正核心就是内层循环，外层循环只是起到一个次数限制的作用
         * 内层循环可以发现，循环条件每次都减少一次，就是说每次移动结束最后一位都不用再比较了，所以
         * 形成的最终的循环就是循环嵌套，外层循环限制次数，内层循环进行比较,
         * **并且起始比较次数就比数组的长度少一，因为
         * 数组元素之间空隙的个数比数组长度少一个，所以总的比较次数比数组长度少一
         */
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < (arr.length - 1) - i; j++) {
                if (arr[j] < arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("移动结束");// 该排序为倒序排序
        System.out.println(Arrays.toString(arr));
    }
}
