package 数据结构题库;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两个字符串的字符数量是一致的
 */
public class 有效的字母异位词 {

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        Map<Character, Integer> map = new HashMap<>(s.length());
        for (char c : s.toCharArray()){
            if (map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            }else {
                map.put(c, 1);
            }
        }
        for (char c : t.toCharArray()){
            if (!map.containsKey(c)){
                return false;
            }else if (map.get(c) == 0){
                return false;
            }else {
                map.put(c, map.get(c) -1);
            }
        }
        return true;
    }

    public static boolean isAnagram1(String s, String t){
        if (s.length() != t.length()) return false;
        char[] chars = s.toCharArray();
        char[] chars1 = t.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chars1);
        return Arrays.equals(chars,chars1);
    }

    public static void main(String[] args) {
        System.out.println(isAnagram1("anagram","anagram"));
        System.out.println(isAnagram("cat","rat"));
    }
}
