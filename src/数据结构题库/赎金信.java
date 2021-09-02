package 数据结构题库;

import java.util.HashMap;
import java.util.Map;

/**
 * 判断第一个字符串能否由第二个字符串组成
 */
public class 赎金信 {

    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> magazineMap = new HashMap<>(magazine.length());
        for (int i = 0; i < magazine.length(); i++) {
            if (magazineMap.containsKey(magazine.charAt(i))){
                magazineMap.put(magazine.charAt(i), magazineMap.get(magazine.charAt(i)) + 1);
            }else {
                magazineMap.put(magazine.charAt(i),1);
            }
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (!magazineMap.containsKey(ransomNote.charAt(i))){
                return false;
            }else if (magazineMap.get(ransomNote.charAt(i)) == 0){
                return false;
            }else {
                magazineMap.put(ransomNote.charAt(i), magazineMap.get(ransomNote.charAt(i)) - 1);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("a","b"));
        System.out.println(canConstruct("aa","ab"));
        System.out.println(canConstruct("aa","aca"));
    }
}
