import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 整数转换为罗马数
 * 罗马数字包含以下七种字符：I，V，X，L，C，D和M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做IIII，而是IV。
 * 数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为IX。
 * 这个特殊的规则只适用于以下六种情况：
 * I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。
 * X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
 * C可以放在D(500) 和M(1000) 的左边，来表示400 和900。
 */

public class 整数转罗马数 {

    /**
     * 解题思路：
     * 1，列出整数和罗马数对应的数组 把它们按照对应的值分别放在同一下标的两个数组中
     * 2，开始遍历 直到num为0
     * @param num
     * @return
     */
    static String intToRoman(int num) {
        StringBuilder builder = new StringBuilder();
        //罗马数对应的整数
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        //整数对应的组成的罗马数
        String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        for (int i = 0; i < values.length && num > 0; i++) {
            while (values[i] <= num){
                num = num - values[i];
                builder.append(symbols[i]);
            }
        }

        return builder.toString();
    }

    /**
     * 此做法行不通 可以转换 但不符合题意
     * 因为遍历key并不是按key的大小开始遍历的 而是随机的 也就是说key是无序的 所以转换出来的罗马数不是最优解 不符合题意
     * @param num
     * @return
     */
    static String intToRoman2(int num){
        StringBuilder builder = new StringBuilder();
        ConcurrentHashMap<Integer,Object> hashMap = new ConcurrentHashMap<Integer,Object>(16){
            {
                put(1000,"M");put(900,"CM");put(500,"D");put(400,"CD");put(100,"C");put(90,"XC");
                put(50,"L");put(40,"XL");put(10,"X");put(9,"IX");put(5,"V");put(4,"IV");put(1,"I");
            }
        };
        Iterator<Map.Entry<Integer, Object>> iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, Object> next = iterator.next();
            while (next.getKey() <= num){
                num = num - next.getKey();
                builder.append(next.getValue());
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
        System.out.println(intToRoman(58));
    }
}
