package com.arithmetic.second;

/**
 * 线性查找
 * 之前是用python写的
 *
 * @author koala
 * @since 2017年8月29日
 */
public class LineSearch {

    public static int lineSearch(int arr[], int x) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                index = i;
            }
        }
        return index;
    }
    
    public static void main(String[] args) {
        int arr[] = {3,5,7,9,6,0};
        int a = 5;
        int i = lineSearch(arr, a);
        System.out.println(i);
    }
}
