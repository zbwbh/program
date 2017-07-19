package com.arithmetic.first;

import java.util.Arrays;

/**
 * 快速排序
 * 这个比冒泡排序难理解，代码实现也比较麻烦，所以用两个类来实现
 * 当前类
 * 也用到了二分法的思想
 * 
 * @author koala
 * @since 2017年7月19日
 */
public class quicksort {

    static void quickSort(int[] s, int left, int right) {
        if (left < right) {// 始终以左边的下标小于右边的下标为大前提
            int i = left;
            int j = right;
            int x = s[left];// 将下标为left的元素定位基数
            while (i < j) {// 大前提
                //分析思路的时候就是j从右向左找小于基数的数，那么条件肯定就是比基数大或者等于就不停留，肯定是j--咯
                //此时while大括号外侧就代表是else的条件了，代表找到了，那么进行替换
                while (i < j && s[j] >= x) {
                    j--;
                }
                if (i < j)
                    s[i] = s[j];//这里为什么是如果这里写s[i++]也没有问题是为什么
                while (i < j && s[i] < x) {
                    i++;
                }
                if (i < j)
                    s[j] = s[i];
            }
            s[i] = x;
            quickSort(s, left, i - 1);
            quickSort(s, i + 1, right);
        }
    }

    public static void main(String[] args) {
        int[] a = new int[10];
        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (1 + Math.random() * 100);
        }
        System.out.println(Arrays.toString(a));
        quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
}
