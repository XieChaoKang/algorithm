package 数据结构题库;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 数组是否存在重复元素 {

    public static boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> temp = new HashMap<>(nums.length);
        for (int num : nums) {
            if (temp.containsKey(num)){
                return true;
            }else {
                temp.put(num,1);
            }
        }
        return false;
    }

    public static boolean containsDuplicate1(int[] nums) {
        Set<Integer> temp = new HashSet<>(nums.length);
        for (int num : nums) {
            if (!temp.add(num)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1,2,3,4}));
        System.out.println(containsDuplicate(new int[]{1,2,3,1}));
        System.out.println(containsDuplicate1(new int[]{1,1,1,3,3,4,3,2,4,2}));
    }
}
