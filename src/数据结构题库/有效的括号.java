package 数据结构题库;

public class 有效的括号 {

    public static boolean isValid(String s) {
        int l = s.length() / 2;
        for (int i = 0; i < l; i++) {
            s = s.replace("()","");
            s = s.replace("{}","");
            s = s.replace("[]","");
        }
        return s.length() == 0;
    }

    public static boolean isValid1(String s){
        while (s.contains("()") || s.contains("{}") || s.contains("[]")){
            s = s.replace("()","");
            s = s.replace("{}","");
            s = s.replace("[]","");
        }
        return "".equals(s);
    }

    public static void main(String[] args) {
        //System.out.println(isValid("(){}[]"));
        System.out.println(isValid1("{[]}"));
        //System.out.println(isValid("({[]})"));
        System.out.println(isValid("[{])"));
        System.out.println(isValid1("({[]})"));
        System.out.println(isValid1("[{])"));
    }
}
