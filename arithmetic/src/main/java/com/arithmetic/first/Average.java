package com.arithmetic.first;

import com.algs4.stdlib.StdIn;
import com.algs4.stdlib.StdOut;

/**
 * 因为那个jar包无法直接使用，结果我是解压之后拷贝到src下面，然后把package改了一下
 * 另外，其中还少一个jar包，com.sun.j3d，网上搜了一大堆没找到，结果在maven仓库找到了java3d-core的镜像
 * 一下载结果发现就是这个啊
 * 
 * @author koala
 * @since 2017年7月18日
 */
public class Average {

    public static void main(String[] args) {
        double sum = 0.0;
        int cnt = 0;
        while (!StdIn.isEmpty()) {// StdIn.isEmpty方法是找下一个在控制台输入的值
            // 该方法基本上会保证无限循环，如果使用撤销命令可以结束方法(ctrl+z)
            // 读取一个数并计算累计之和
            sum += StdIn.readDouble();
            cnt++;
        }
        double avg = sum / cnt;
        StdOut.printf("Averate is %.5f\n", avg);
    }
}
