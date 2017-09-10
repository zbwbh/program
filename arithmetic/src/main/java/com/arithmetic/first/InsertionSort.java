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
                arr[i + 1] = arr[i];// 实际上key的位置不变，只不过是首先将key提取出来，然后将key前面比key大的数进行移动
                i--;                 //key只起到一个基准数的作用，只要比key大，那么在此基础上当前位置的数向后移位arr[i + 1] = arr[i];
            }
            arr[i + 1] = key;//因为while循环最后一次需要做比较，所以进行了i--操作，如果不+1，那么key就不是在正确的位置上了
        }
    }
    
    public static void main(String[] args) {
        int arr[] = {5,6,9,4,2};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
