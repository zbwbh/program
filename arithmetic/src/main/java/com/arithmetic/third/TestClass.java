package com.arithmetic.third;

import java.util.Arrays;

public class TestClass {

    public static void mergeArray(int arr[], int left, int mid, int right, int temp[]){
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            }
            if (arr[j] < arr[i]) {
                temp[k++] = arr[j++];
            }
        }
        
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        
        k = 0;
        while (left <= right) {
            arr[left++] = temp[k++];
        }
    }
    
    public static void sort(int arr[], int left, int right, int temp[]) {
        if (left >= right) return;
            int mid = (left + right)/2;
            sort(arr,left,mid,temp);
            sort(arr,mid+1,right,temp);
            mergeArray(arr,left,mid,right,temp);
    }
    
    public static void sort(int arr[]) {
        int temp[] = new int[arr.length];
        sort(arr,0,arr.length-1,temp);
    }
    
    public static void main(String[] args) {
        int arr[] = {5,9,76,4,6,77,2,45,55};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
