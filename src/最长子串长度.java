import java.util.*;

/**
 * 给出一个字符串 找出最长子串的长度
 */
public class 最长子串长度 {
    static int length(String s){
        //空格字符串 直接输出
        if (s.equals(" ")){
            return 1;
        }
        char[] chars = s.toCharArray();
        //只有1个字符 直接输出
        if (chars.length == 1) return 1;
        int length = 1;
        ArrayList<Integer> list = new ArrayList<>(10);
        for (int i = 0; i < chars.length; i++) {
            if (i == chars.length-1){
                break;
            }
            char s1 = chars[i];
            HashMap<Object, Object> map = new HashMap<>(16);
            map.put(s1,0);
            for (int j = i+1; j < chars.length; j++) {
                if (!map.containsKey(chars[j])){
                    length = length + 1;
                    map.put(chars[j],j);
                    //遍历到最后一个字符时 else不走就不会填加当前子字符串长度 因此需要在这里添加
                    if (j == chars.length - 1){
                        list.add(length);
                        length = 1;
                    }
                }else {
                    list.add(length);
                    length = 1;
                    break;
                }
            }
        }
        Collections.sort(list);
        System.out.println(list);
        //空字符串进来 list为空
        if (list.size() == 0){
            return 0;
        }else {
            return list.get(list.size()-1);
        }
    }
    public static void main(String[] args) {
        String s = "";
        System.out.print(length(s));
    }
}
