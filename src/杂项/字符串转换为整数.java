package 杂项;

import java.math.BigInteger;

/**
 * 题解思路
 * 1，去掉空格
 * 2，判断首位是否为数字 不是则判断是否是 - +
 * 3，根据首位是否为数字来确定开始循环的下标 是 则0 不是 则1
 * 4，循环里面 通过*10相加拼接数字
 * 5，判断拼接后的数字是否到边界值
 */
public class 字符串转换为整数 {

    static int myAtoi(String str){
        //去掉空格
        str = str.trim();
        if (str.length() == 0) return 0;
        //判断首位字符
        if (!Character.isDigit(str.charAt(0))
                && str.charAt(0) != '-' && str.charAt(0) != '+')
            return 0;
        long ans = 0L;
        boolean neg = str.charAt(0) == '-';
        int i = !Character.isDigit(str.charAt(0)) ? 1 : 0;
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            ans = ans * 10 + (str.charAt(i++) - '0');
            //为正 边界为 2147483647
            if (!neg && ans > Integer.MAX_VALUE) {
                ans = Integer.MAX_VALUE;
                break;
            }
            //为负 边界则为 2147483648
            if (neg && ans > 1L + Integer.MAX_VALUE) {
                ans = 1L + Integer.MAX_VALUE;
                break;
            }
        }
        return neg ? (int) -ans : (int) ans;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("+3.23"));
        /*System.out.println(myAtoi("   -42"));
        System.out.println(myAtoi(" 0000-3"));
        System.out.println(myAtoi("+-23"));
        System.out.println(myAtoi("+3.2424"));
        System.out.println(myAtoi("-+23"));
        System.out.println(myAtoi("-9147483648"));
        System.out.println(myAtoi(" -42"));
        System.out.println(myAtoi("2147483648"));
        System.out.println(myAtoi("-2147483649"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("-+23"));
        System.out.println(myAtoi("-W23"));
        System.out.println(myAtoi("+w23"));
        System.out.println(myAtoi("00000-42a1234"));
        System.out.println(myAtoi(" 00043"));
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi("  -0012a42"));*/
    }
}
