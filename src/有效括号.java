import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * 有效括号
 * https://leetcode-cn.com/problems/valid-parentheses/
 */

public class 有效括号 {

    public static boolean isValid(String s) {
        if (s.length() % 2 == 1){
            return false;
        }
        char[] chars = s.toCharArray();
        String c = String.valueOf(chars[0]);
        if (!("(".equals(c) || "{".equals(c) || "[".equals(c))){
            return false;
        }
        HashMap<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "({})";
        System.out.println(isValid(s));
    }
}
