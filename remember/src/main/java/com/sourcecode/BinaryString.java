package com.sourcecode;

/**
 * java源码Integer包装类toBinaryString()方法
 * 
 *
 * @author zbw
 * @since 2017年11月17日
 */
public class BinaryString {

    /**
     * 返回int变量的二进制表示的字符串
     */
    public static String toBinaryString(int i) {
        return toUnsignedString(i, 1);
    }
    
    /**
     * 返回int变量的八进制表示的字符串
     */
    public static String toOctalString(int i) {
        return toUnsignedString(i, 3);
    }
    
    /**
     * 返回int变量的十六进制表示的字符串
     */
    public static String toHexString(int i) {
        return toUnsignedString(i, 4);
    }
    
    /**
     * 
     * 
     * @param val 需要被转换的int型整数
     * @param shift
     * @return
     *
     * @author zbw
     * @since 2017年11月17日
     */
    private static String toUnsignedString(int val, int shift) {
        int mag = Integer.SIZE - numberOfLeadingZeros(val); 
        int chars = Math.max(((mag + (shift - 1)) / shift), 1);
        char[] buf = new char[chars];
        
        formatUnsignedInt(val, shift, buf, 0, chars);
        
        return new String(buf);//写return new String(buf,true);会报错，但是源码是这么写的
        /**
         * Integer.SIZE = 32;  二进制补码形式中用来表示int值的位数,int是32位，short是16位，byte是8位二进制码
         * 
         */
    }
    
    
    static int numberOfLeadingZeros(int i) {
        if (i == 0) return 32;
        int n = 1;
        if (i >>> 16 == 0) {n += 16; i <<= 16;}
        if (i >>> 24 == 0) {n +=  8; i <<=  8;}
        if (i >>> 28 == 0) {n +=  4; i <<=  4;}
        if (i >>> 30 == 0) {n +=  2; i <<=  2;}
        n -= i >>> 31;
        return n;
    }
    /**
     * <<:左移，右边补0，符号位和其他位一样要移动。
     * 例如:3 << 2 ，则是将数字3左移2位
     * 计算过程 ：3 << 2
     * 首先把3转换为二进制数字0000 0000 0000 0000 0000 0000 0000 0011，然后把该
     * 数字高位(左侧)的两个0移出，其他数字都朝左平移2位，最后在低位(右侧)的两个空位补0.则得到
     * 的最重结果是0000 0000 0000 0000 0000 0000 0000 1100，转换成十进制数是12。
     * 数学意义：
     * 在数字没有溢出的前提下，对于正数和负数，左移一位都相当于乘以2的1次方，左移n位就相当于
     * 乘以2的n次方
     * 好吧，网上米有找到，我个人理解数字溢出应该是你能存的数就那么多（毕竟计算机硬件属于物理硬件，
     * 容量是有限的），
     * 但是你突然冒出来一个比她范围大一的数，而且在数值类型范围内他是一个循环，
     * 你大一我就按照循环的方式往下走，结果就变成最小的值了，从而导致数不准确了，
     * 
     * 
     * >> 与 << 类似，唯一的区别是 >> 因为是高位补位，低位移出，所以他的补位要考虑符号的问题
     * 如果该数原来是正数，则高位补0，若为负数，则高位补1。
     * 如果觉得难理解，就直接认为<< n 乘以2的n次方， >> n 除以2的n次方
     * >>> 表示无符号右移，也叫逻辑右移，无论该数本身正负，移位后，高位均补0。
     * 提示：左移没有<<<运算符
     * 
     * 知识没学到家啊，哈哈，太招笑了，上网一查
     * >>>= 右移位并赋值 ，这和+= 不是同样的道理么。。。
     * @author zbw
     * @since 2017年11月17日
     */
    static int formatUnsignedInt(int val, int shift, char[]buf, int offset, int len) {
        int charPos = len;
        int radix = 1 << shift;
        int mask = radix - 1;
        do {
            buf[offset + --charPos] = digits[val & mask];
            val >>>= shift;
        }while(val != 0 && charPos > 0);
        
        return charPos;
    }
    
    final static char[] digits = {
       '0','1','2','3','4','5',
       '6','7','8','9','a','b',
       'c','d','e','f','g','h',
       'i','j','k','l','m','n',
       'o','p','q','r','s','t',
       'u','v','w','x','y','z'                   
    };
    
    public static void main(String[] args) {
        String b = toBinaryString(10);
        System.out.println(b);
//        String h = toHexString(10);
//        System.out.println(h);
//        
//        String o = toOctalString(10);
//        System.out.println(o);
    }
}
