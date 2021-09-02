package 数据结构题库;

import java.util.HashMap;
import java.util.Map;

public class 字符串第一个唯一字符 {

    public static int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (map.containsKey(a)){
                map.put(a, map.get(a)+1);
            }else {
                map.put(a, 1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
        System.out.println(firstUniqChar("loveleetcode"));
    }
}
