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
public class Quicksort {

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
                if (i < j)//当第一时间满足s[j]>=x的条件的时候就代表找到大于基数的数了，此时换坑
                    s[i] = s[j];//有的代码写的是s[i++]=s[j]，不明白你i位缺的坑为什么上后一位去填
                while (i < j && s[i] < x) {
                    i++;
                }
                if (i < j)
                    s[j] = s[i];//有的代码写的是s[j--]=s[i]，跟上面同样的疑问
            }
            s[i] = x;//最后是s[i]填的坑
            quickSort(s, left, i - 1);//第i位填的坑，当然避开第i位了，左面的就从减一个位置开始，右面的就从加一的位置开始
            quickSort(s, i + 1, right);
        }
    }

    public static void main(String[] args) {
        int[] a = new int[9999];
        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (1 + Math.random() * 100);
        }
        System.out.println(Arrays.toString(a));
        long begin = System.currentTimeMillis();
        quickSort(a, 0, a.length - 1);
        long end = System.currentTimeMillis();
        long time = end - begin;
        System.out.println(time);
        System.out.println(Arrays.toString(a));
    }
}
