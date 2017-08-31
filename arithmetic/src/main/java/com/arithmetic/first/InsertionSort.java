package com.arithmetic.first;

import java.util.Arrays;

/**
 * 插入排序
 * 
 *
 * @author koala
 * @since 2017年8月28日
 */
public class InsertionSort {

    /**
     * 根据插入排序的描述可知
     * 1、需要一个数组，arr[]
     * 2、数组的起始位置，结束位置，数组长度根据arr[]可知，可以不必传入
     * 3、中间变量仅仅起到传递作用，不必传入
     *
     * @author koala
     * @since 2017年8月28日
     */
    public static void insertionSort(int arr[]) {
        for (int j = 1; j < arr.length; j++) {//数组下标为0为基准，从第二张牌开始比较
            int key = arr[j];
            int i = j - 1;
            while (i >= 0 && arr[i] >= key) {
                arr[i + 1] = arr[i];
                i--;
            }
            arr[i + 1] = key;
        }
    }
    
    public static void main(String[] args) {
        int arr[] = {5,6,9,4,2};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
