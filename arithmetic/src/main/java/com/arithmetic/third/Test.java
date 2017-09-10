package com.arithmetic.third;

import java.util.Arrays;

public class Test {

    public static int sonSum(int arr[]){
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }
    
    public static int sonSum2(int arr[]){
        int max = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum < 0){
                sum = 0;
            }else if (sum > 0 && sum > max) {
                max = sum;
            }
        }
        return max;
    }
    
    public static void main(String[] args) {
        int arr[] = {-5,-3,-1,-9,-2,-3,-1};
        int result = sonSum(arr);
        System.out.println(result);
    }
}
