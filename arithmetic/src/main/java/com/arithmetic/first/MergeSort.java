package com.arithmetic.first;

import java.util.Arrays;

/**
 * 归并排序，书读百遍其义自见，代码也是一样的道理，刚开始看归并排序的时候这个懵逼啊，现在好多了
 * 归并排序伪代码：
 * MERGE(A,p,q,r)
 * n1 = q - p + 1
 * n2 = r - q
 * let L[1..n1 + 1] and R[1..n2 + 1]be new arrays
 * for i = 1 to n1
 *     L[i] = A[p + i -1]
 * for j = 1 to n2
 *     R[j] = A[q + j]
 * L[n1 + 1]=哨兵
 * R[n2 + 1]=哨兵
 * i = 1
 * j = 1
 * for k = p to r
 *     if L[i] <= R[j]
 *     A[k] = L[i]
 *     i = i + 1
 * else
 *     A[k] = R[j]
 *     j = j + 1
 * 这段伪代码包含了分解和合并，但是仅仅是一个方法是写不出算法的，还需要一个递归方法，但是递归我个人理解起来比较吃力，可能也是刚学的时候
 * 给自己留下阴影了吧，现在看看之前的阶乘递归还是能接受的，阶乘递归看下面的方法
 * 那么归并排序的边界条件呢？
 * @author koala
 * @since 2017年8月24日
 */
public class MergeSort {

    //递归阶乘，很明显的是他的边界条件是n=1
    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
    
    /**
     * 如果不参照伪代码，可以敲出来吗
     * 伪代码的第一个条件就是要有一个原始数组
     * @author koala
     * @since 2017年8月24日
     */
    public static void mergeArray(int arr[], int left, int mid, int right, int temp[]) {
        int i = left;//左序列指针
        int j = mid + 1;//右序列指针
        int k = 0;//中间数组序列指针
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                k++;
                i++;
            }
            if (arr[i] > arr[j]) {
                temp[k] = arr[j];
                k++;
                j++;
            }
        }
        
        while (i <= mid) {
            temp[k] = arr[i];
            k++;
            i++;
        }
        
        while(j <= right) {
            temp[k] = arr[j];
            k++;
            j++;
        }
        
        k = 0;
        while (left <= right) {
            arr[left++] = temp[k++];
        }
    }
    
    /**
     * 递归方法，每次执行调用该方法，边界条件就是左下标小于右下标
     *
     * @author koala
     * @since 2017年8月24日
     */
    public static void sort(int arr[], int left, int right, int temp[]){
        if (left < right) {
            int mid = (left + right)/2;
            sort(arr, left, mid, temp);
            sort(arr, mid + 1, right, temp);
            mergeArray(arr,left,mid,right,temp);
        }
    }
    
    public static void sort(int arr[]){
        int temp[] = new int[arr.length];//在排序前，先创建一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        sort(arr,0,arr.length - 1,temp);
    }
    
    public static void main(String[] args) {
//        int result = factorial(5);
//        System.out.println(result);
        int arr[] = {4,6,8,1,7};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
