package com.arithmetic.first;

import java.util.Arrays;

public class Queue {

    /**
     * 直接把取出来的数输出了
     * 。。。无语了，好像C语言无法用变量定义数组长度，比如inta[5]
     * Java可以int[]a = new int[i],其他的好像没有区别了
     * @author koala
     * @since 2017年7月20日
     */
    public static void main(String[] args) {
        int b[] = {6,3,1,7,5,8,9,2,4};
        int a[] = new int[100];
        System.arraycopy(b, 0, a, 0, 9);
        int head = 0;
        int tail = 9;
        while(head<tail){
            System.out.print(a[head]);
            head++;//第一的位置输出之后向后移位，此时在第二个元素上，将第二个元素放到末尾，如下
            a[tail]=a[head];
            tail++;//如果数组空间不够大，在接下来的tail赋值中会报越界异常
            head++;//因为第二个元素已经放到末尾了，此时将要输出第三个元素，向后移位，如此往复
        }
    }
}
