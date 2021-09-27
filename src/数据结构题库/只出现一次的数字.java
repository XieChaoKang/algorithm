package 数据结构题库;

import java.util.HashMap;
import java.util.Map;

public class 只出现一次的数字 {

    //使用额外辅助空间
    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int num : nums) {
            if (map.containsKey(num)){
                map.put(num, map.get(num)+1);
            }else {
                map.put(num, 1);
            }
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                res = entry.getKey();
                break;
            }
        }
        return res;
    }

    //使用位运算
    public static int singleNumber1(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new  int[]{1,1,4,3,3};
        System.out.println(singleNumber1(nums));
    }
}
