package com.arithmetic.second;

import java.util.Arrays;
import java.util.Random;

public class BinarySeach {

    /**
     * 数据结构与算法分析--C语言描述这本书确实不错
     * 不过算法书读起来真的都很耗时，算法导论也是
     * 这段代码跟c语言描述那本书里面的还有些区别，因为那个不是java实现的
     * 不过大体意思是能看懂的
     * @author koala
     * @since 2017年8月31日
     */
    public static int binarySearch(int arr[], int x){
        int index = -1;
        int left = 0, right = arr.length - 1;
        while(left <= right){
            int mid = (left + right)/2;
            if (x > arr[mid]) {
                left = mid + 1;
            }else if (x < arr[mid]) {
                right = mid - 1;//刚开始实现的时候写的right=mid，最后跟别人代码对的时候才发现写错了，始终不改变寻找长度怎么行
            }else {
                return mid;//这个直接让index=mid不可以？？不知道为什么
            }
        }
        return index;
    }
    
    public static void main(String[] args) {
        int arr[] = new int[10000];
        Random r = new Random();
        for (int i =0;i<arr.length;i++){
            arr[i] = r.nextInt(10000);
        }
        System.out.println(Arrays.toString(arr));
        long begin = System.currentTimeMillis();
        int index = binarySearch(arr, 2575);
        long end = System.currentTimeMillis();
        long time = end - begin;
        System.out.println(index);
        System.out.println(time);
    }
}
