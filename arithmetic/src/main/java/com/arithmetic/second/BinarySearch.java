package com.arithmetic.second;

/**
 * 
 * 二分查找，二分查找又称折半查找，它是一种效率较高的查找方法。
 * 【二分查找要求】：1.必须采用顺序存储结构。2.必须按关键字大小有序排列。
 * 
 *
 * @author koala
 * @since 2017年11月17日
 */
public class BinarySearch {
    
    /**
     * 二分查找法
     * 
     * @param srcArray 有序数组
     * @param des 查找元素
     * @return des的数组下标，没找到返回-1
     *
     * @author koala
     * @since 2017年11月17日
     */
    public static int binarySearch(int[] srcArray, int des) {
        int low = 0;
        int high = srcArray.length - 1;
        while (low <= high) {
            int middle = low + (high - low) / 2;// int middle = (low + high) / 2;是有可能出现整数溢出的
            if (des == srcArray[middle]) {
                return middle;
            }else if (des > srcArray[middle]) {
                low = middle + 1;
            }else if (des < srcArray[middle]) {
                high = middle - 1;
            }
        }
        
        return -1;
    }
    
    /**
     * 以递归的形式实现二分查找，但是由于递归比较消耗栈内存，
     * 所以不建议采用这种方式实现
     * 
     * @param dataset 整型数组
     * @param data 待查找的整数
     * @param beginIndex 起始下标
     * @param endIndex 结束下标
     * @return 具体位置下标
     *
     * @author zbw
     * @since 2017年11月17日
     */
    public static int binarySearch(int[] dataset, int data, int beginIndex, int endIndex) {
        int middleIndex = beginIndex + (endIndex - beginIndex) / 2;//是不是原始表达式拆分后发现了这种方式？？原始表达式如上：可能会整数溢出的那个
        if (data < dataset[beginIndex] || data > dataset[endIndex] || beginIndex > endIndex) {
            return -1;
        }
        if (data > dataset[middleIndex]) {
            return binarySearch(dataset, data, middleIndex + 1, endIndex);
        }else if (data < dataset[middleIndex]) {
            return binarySearch(dataset, data, beginIndex, middleIndex - 1);
        }else {
            return middleIndex;
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {1,2,4,5,6,8,12};
        int index = binarySearch(arr, 8);
        System.out.println(index);
        int otherIndex = binarySearch(arr, 8, 0, arr.length - 1);
        System.out.println(otherIndex);
    }
}
