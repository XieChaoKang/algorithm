
public class 整数反转 {

    //暴力解法
    static int reverse(int x) {
        if (x == 0){
            return x;
        }
        String s = String.valueOf(x);
        char[] s1 = s.toCharArray();
        boolean check = false;
        StringBuilder stringBuilder = new StringBuilder();
        if ("-".equals(String.valueOf(s1[0]))){
            stringBuilder.append(s1[0]);
            check = true;
        }
        for (int i = s1.length-1; i >= 0; i--) {
            if (check && i == 0){
                break;
            }
            stringBuilder.append(s1[i]);
        }
        try {
            //边界问题 直接异常抛出 返回0
            int y = Integer.parseInt(stringBuilder.toString());
            return (y >= Math.pow(2,31) -1 || Math.pow(-2,31) >= y) ? 0 : y;
        }catch (Exception e){
            return 0;
        }
    }

    static int reverse2(int x){
        int ans = 0;
        while (x != 0) {
            int pop = x % 10;
            // 7是2^31-1 的个位数 定边界
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;
            // 8是-2^31的个位数 定边界
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;
            ans = ans * 10 + pop;
            x /= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(reverse2(1534236469));
        System.out.println(reverse(-123));
    }
}
