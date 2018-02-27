package com.arithmetic.check;

/**
 * 奇偶校验位
 * 
 *
 * @author zbw
 * @since 2018年2月26日
 */
public class IMEIGen {

    private static String genCode(String code) {
        int total = 0, sum1 = 0, sum2 = 0;
        int temp = 0;
        char [] chs = code.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            int num = chs[i] - '0'; //ascii to num
//            System.out.println(num);
            // 将奇数位数字相加(从1开始计数),才明白这里为什么用i%2==0来找出奇数，
            //因为按照正整数和元素下标的对应关系来看，1对应下标0,3对应下标2，这回能看明白了吧
            if (i % 2 == 0) {
                sum1 = sum1 + num;
            }else {
                //将偶数位数字分别乘以2，分别计算个位数和十位数之和
                temp = num * 2;
                if (temp < 10) {
                    sum2 = sum2 + temp;
                }else {
                    sum2 = sum2 + temp + 1 - 10;
                }
            }
        }
        total = sum1 + sum2;
        // 如果得出的数个位是0则校验位为0，否则为10减去个位数
        if (total % 10 == 0) {
            return "0";
        }else {
            return (10 - (total % 10)) + "";
        }
    }
    
    private static String genCode2(String code) {
        if (!code.isEmpty()) {
            char [] codeChar = code.toCharArray();
            int resultInt = 0;
            for (int i = 0; i < codeChar.length; i++) {
                int a = Integer.parseInt(String.valueOf(codeChar[i]));
                i++;
                final int temp = Integer.parseInt(String.valueOf(codeChar[i]))*2;
                final int b = temp < 10 ? temp : temp - 9;
                resultInt += a + b;
            }
            resultInt%=10;
            resultInt = resultInt == 0 ? 0 : 10 - resultInt;
            return resultInt + "";
        }else {
            return "";
        }
        
    }
    
    /** 
     * 
     * 这个是我根据描述并参考上面两个自己写出来的
     * 根据IMEI的前14位，得到第15位的校验位 
     * IMEI校验码算法： 
     * (1).将偶数位数字分别乘以2，分别计算个位数和十位数之和 
     * (2).将奇数位数字相加，再加上上一步算得的值 
     * (3).如果得出的数个位是0则校验位为0，否则为10减去个位数 
     * 如：35 89 01 80 69 72 41 偶数位乘以2得到5*2=10 9*2=18 1*2=02 0*2=00 9*2=18 2*2=04 1*2=02,计算奇数位数字之和和偶数位个位十位之和， 
     * 得到 3+(1+0)+8+(1+8)+0+(0+2)+8+(0+0)+6+(1+8)+7+(0+4)+4+(0+2)=63  
     * 校验位 10-3 = 7 
     * @param imei 
     * @return 
     */ 
    private static String genCode3(String code) {
        int sumEven = 0, sumOdd = 0, total = 0;
        if (!code.isEmpty()) {
            char [] chs = code.toCharArray();
            for (int i = 0; i < chs.length; i++) {
//                System.out.println(chs[i]);//这里输出的就是具体的数字字符，不是转换后的int类型
//                int num1 = chs[i];//转换后的int类型变成了ASCII码对应的数字，不再是原来的数字了，所以要找到具体变化了多少
//                System.out.println(num1);//这里变化的正好是'0'这个字符所代表的ASCII码
                int num = chs[i] - '0';
                //所有奇数相加
                if (i % 2 == 0) {
                    sumOdd += num;
                }else {
                    int temp = num * 2;
                    sumEven += (temp < 10 ? temp : (temp + 1 - 10));
                }
            }
        }
        total = sumOdd + sumEven;
        int result = total % 10;
        result = result == 0 ? 0 : (10 - result);
        return result + "" ;
    }
    
    private static String genCode4(String code) {
        int sumEven = 0, sumOdd = 0, total = 0;
        if (!code.isEmpty()) {
            code = code.substring(6,12);
            char [] letters = code.toCharArray();
            StringBuilder codeJoin = new StringBuilder();
            for (char letter : letters) {
                codeJoin.append((int)letter);//我不确定这么做是否保险
            }
            String joinStr = codeJoin.toString();
            System.out.println(joinStr);
            char[] chs = joinStr.toCharArray();
            for (int i = 0; i < chs.length; i++) {
                int num = chs[i] - '0';
                if (i % 2 == 0) {
                    sumOdd += num;
                }else {
                    int temp = num * 2;
                    sumEven += (temp < 10 ? temp : (temp + 1 - 10));
                }
            }
        }
        total = sumEven + sumOdd;
        int result = total % 10;
        result = result == 0 ? 0 : (10 - result);
        return result + "";
    }
    
    public static void main(String[] args) {
        String code = "431046WZHYNZ";//879072897890   431046WZHYNZ
//        String newCode = genCode4(code);
//        System.out.println("==========" + newCode);
//        System.out.println(code + newCode);
    }
}
