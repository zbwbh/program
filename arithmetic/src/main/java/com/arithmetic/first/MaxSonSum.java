package com.arithmetic.first;


public class MaxSonSum {

    /**
     * 穷举法列举所有子序列和的情况，取出其中最大值
     *
     * @author koala
     * @since 2017年8月29日
     */
    public static int sonSum(int arr[]) {
        int i,k;
        int max = 0;
        for (i = 0; i < arr.length; i++) {
            int sum = 0;
            for (k = i; k < arr.length; k++) {
                sum += arr[k];
                if (sum > max) {//该条件截获最大值并将最大值进行替换，从而保证最大值始终被记录，方法核心
                    max = sum;
                }
            }
        }
        return max;
    }
    
    /**
     * 对上面方法的一个测试，因为刚开始对穷举算法的保存最大值的过程有些疑惑
     *
     * @author koala
     * @since 2017年8月29日
     */
    public static int sum(int arr[]) {
        int max = 0,sum = 0;
        for (int i = 0; i< arr.length; i++) {
            sum += arr[i];
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }
    
    /**
     * 联机算法，最优算法，只对数据读入一次
     *
     * @author koala
     * @since 2017年8月29日
     */
    public static int easySum(int arr[]){
        int max = 0, sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum > max) {
                max = sum;
            }else if (sum < 0) {//如果小于0则代表下一次累加一定比截取掉该负数的累加小，所以将sum置零
                sum = 0;
            }
        }
        return max;
    }
    
    /**
     * 三木运算返回三个数中的最大值，还算比较直观吧
     *
     * @author koala
     * @since 2017年8月29日
     */
    public static int maxResult(int x, int y, int z) {
        int m = x > y ? x : y;
        int n = m > z ? m : z;
        return n;
    }
    
    /**
     * 分治法求解最大子序列和问题
     * 百度上说易懂，。。。为什么我就不懂了
     * @author koala
     * @since 2017年8月29日
     */
    public static int maxMerge(int arr[], int left, int right) {
        //很显然这是只含一个元素的情况，如果大于0那就返回该元素本身，否则返回0
        //这应该是基本情况吧，最后肯定都拆没了，就剩一个元素啊
        if (left == right) {
            if (arr[left] > 0) {
                return arr[left];
            }else{
                return 0;
            }
        }
        
        //接下来左右拆分吧
        int mid = (left + right)/2;
        int maxLeftMerge = maxMerge(arr,left,mid);
        int maxRightMerge = maxMerge(arr,mid+1,right);
        
        //具体细节,右半部分可以理解，可是为什么左半部分要是用递减求和呢，如果左半部分采用递增求和结果不一样
        int sumLeft = 0, leftmax = 0;
        for (int i = mid; i >= left; i--) {
            sumLeft += arr[i];
            if (sumLeft > leftmax) {
                leftmax = sumLeft;
            }
        }
        
        int sumRight = 0, rightmax = 0;
        for (int i = mid + 1; i <= right; i++) {
            sumRight += arr[i];
            if (sumRight > rightmax) {
                rightmax = sumRight;
            }
        }
        return maxResult(maxLeftMerge, maxRightMerge, rightmax + leftmax);
    }
    
    public static void main(String[] args) {
        int arr[] = {4,-6,1,-1,7,-4,5,2,-3,9};
//        int max = sonSum(arr);
//        int max = sum(arr);
        int max1 = easySum(arr);
//        System.out.println(max);
        System.out.println(max1);
        int max = maxMerge(arr, 0, arr.length - 1);
        System.out.println(max);
    }
}
