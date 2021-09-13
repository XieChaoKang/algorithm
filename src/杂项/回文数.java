package 杂项;

/**
 * 杂项.回文数 顺序翻转过来的两个整数是否相等
 * 解题思路：
 * 1，如果为负数 则翻转后肯定不相等 false
 * 2，利用取模运算 翻转整数
 * 注意 取模运算中 x的值会改变 所以需要先把x赋给另外一个变量来保存原本的值
 */
public class 回文数 {

    static boolean isPalindrome(int x) {
        if (x < 0) return false;
        int ans = 0;
        int y = x;
        while (x != 0) {
            int pop = x % 10;
            //乘10拼接
            ans = ans * 10 + pop;
            x /= 10;
        }
        return y == ans;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(123));
    }
}
