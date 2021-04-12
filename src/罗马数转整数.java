import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 给定一个罗马数转换为整数
 * 罗马数和整数的对应规则可以参考 整数转换为罗马数
 */

public class 罗马数转整数 {

    static int romanToInt(String s) {
        int ans = 0;
        //罗马数对应的整数
        Integer[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        //整数对应的组成的罗马数
        String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        List<String> symbolsList = new ArrayList<>(Arrays.asList(symbols));
        if (s.length() == 1){
            return values[symbolsList.indexOf(s)];
        }
        char[] s1 = s.toCharArray();
        int i = 0;
        while (i < s1.length){
            if (i == s1.length-1){
                ans = ans + values[symbolsList.indexOf(String.valueOf(s1[i]))];
                break;
            }
            if (values[symbolsList.indexOf(String.valueOf(s1[i+1]))] <= values[symbolsList.indexOf(String.valueOf(s1[i]))]){
                ans = ans + values[symbolsList.indexOf(String.valueOf(s1[i]))];
                i += 1;
            }else {
                ans = ans + values[symbolsList.indexOf(String.valueOf(s1[i]) + String.valueOf(s1[i+1]))];
                i += 2;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
}
