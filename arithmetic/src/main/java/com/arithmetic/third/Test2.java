package com.arithmetic.third;


public class Test2 {

    public static int search(int arr[], int x) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (x > arr[mid]) {
                left = mid + 1;
            }else if (x < arr[mid]) {
                right = mid - 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        int arr[] = {1,3,5,6,9};
        int result = search(arr,9);
        System.out.println(result);
    }
}
